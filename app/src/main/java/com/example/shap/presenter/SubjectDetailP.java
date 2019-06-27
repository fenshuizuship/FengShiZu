package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.SubjectDetailBean;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.interfaces.contract.Subject;
import com.example.shap.interfaces.contract.SubjectDetail;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class SubjectDetailP extends BasePresenter<SubjectDetail.SubjectDetailView>
        implements SubjectDetail.SubjectDetailPresenter
{

    @Override
    public void getSubjectDetailBean(int id) {
        addSubscribe(HttpUtils.getMyServer().getSubjectDetailBean(id)
                .compose(RxUtils.<SubjectDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SubjectDetailBean>(mView) {

                    @Override
                    public void onNext(SubjectDetailBean subjectDetailBean) {
                        mView.getSubjectDetailBean(subjectDetailBean);
                    }

                }));
    }
}
