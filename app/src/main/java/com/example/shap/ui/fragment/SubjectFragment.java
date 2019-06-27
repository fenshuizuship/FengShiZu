package com.example.shap.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shap.R;
import com.example.shap.adaper.SubListAdapter;
import com.example.shap.base.BaseFragment;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.contract.Subject;
import com.example.shap.presenter.SubjectP;
import com.example.shap.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends BaseFragment<Subject.SubjectView,
        SubjectP> implements Subject.SubjectView{

    @BindView(R.id.subject_list_rv)
    RecyclerView mSubjectListRv;
    private ArrayList<SubjectListBean.DataBeanX.DataBean> mDataBeans;
    private SubListAdapter mSubListAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_subject;
    }

    @Override
    protected void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mSubjectListRv.setLayoutManager(linearLayoutManager);
        mDataBeans = new ArrayList<>();
        mSubListAdapter = new SubListAdapter( getContext(),mDataBeans);
        mSubjectListRv.setAdapter(mSubListAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getSubjectListBean();
    }

    @Override
    protected SubjectP getPresenter() {
        return new SubjectP();
    }


    @Override
    public void getSubjectListBean(SubjectListBean subjectListBean) {
            if(subjectListBean != null){
                mDataBeans.addAll(subjectListBean.getData().getData());
                mSubListAdapter.notifyDataSetChanged();
            }else {
                ToastUtil.showLong("数据请求为空");
            }
    }
}
