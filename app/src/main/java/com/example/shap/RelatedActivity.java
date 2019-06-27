package com.example.shap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shap.adaper.SubListAdapter;
import com.example.shap.adaper.SubRelatedAdapter;
import com.example.shap.base.BaseActivity;
import com.example.shap.bean.SubjectRelatedBean;
import com.example.shap.interfaces.contract.SubjectRelated;
import com.example.shap.presenter.SubjectRelatedP;
import com.example.shap.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RelatedActivity extends BaseActivity<SubjectRelated.SubjectRelatedView, SubjectRelatedP>
        implements SubjectRelated.SubjectRelatedView {


    @BindView(R.id.item_related_rv)
    RecyclerView mItemRelatedRv;

    private SubRelatedAdapter mSubRelatedAdapter;
    private ArrayList<SubjectRelatedBean.DataBean> mDataBeans;
    private int mListId;


    @Override
    protected SubjectRelatedP getPresenter() {
        return new SubjectRelatedP();
    }

    @Override
    protected void initData() {
        mPresenter.getSubjectRelatedBean(mListId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_related;
    }

    @Override
    public void getSubjectRelatedBean(SubjectRelatedBean subjectRelatedBean) {
        mDataBeans.addAll(subjectRelatedBean.getData());
        mSubRelatedAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMsg) {
        ToastUtil.showLong("错误信息" + errorMsg);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mListId = intent.getIntExtra("listId", 0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mItemRelatedRv.setLayoutManager(gridLayoutManager);
        mDataBeans = new ArrayList<>();
        mSubRelatedAdapter = new SubRelatedAdapter(RelatedActivity.this, mDataBeans);
        mItemRelatedRv.setAdapter(mSubRelatedAdapter);
    }

}
