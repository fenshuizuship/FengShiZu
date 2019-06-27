package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.Bean_search;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.interfaces.contract.Search;
import com.example.shap.interfaces.contract.Subject;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class SubjectP extends BasePresenter<Subject.SubjectView>
        implements Subject.SubjetPresenter
{


    @Override
    public void getSubjectListBean() {
        addSubscribe(HttpUtils.getMyServer().getSubjectListBean()
                .compose(RxUtils.<SubjectListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SubjectListBean>(mView) {

                    @Override
                    public void onNext(SubjectListBean subjectListBean) {
                        mView.getSubjectListBean(subjectListBean);
                    }

                }));
    }
}
