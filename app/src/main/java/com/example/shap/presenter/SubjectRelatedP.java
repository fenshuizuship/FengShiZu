package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.bean.SubjectRelatedBean;
import com.example.shap.interfaces.contract.Subject;
import com.example.shap.interfaces.contract.SubjectRelated;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class SubjectRelatedP extends BasePresenter<SubjectRelated.SubjectRelatedView>
        implements SubjectRelated.SubjectRelatedPresenter
{

    @Override
    public void getSubjectRelatedBean(int id) {
        addSubscribe(HttpUtils.getMyServer().getSubjectRelatedBean(id)
                .compose(RxUtils.<SubjectRelatedBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SubjectRelatedBean>(mView) {

                    @Override
                    public void onNext(SubjectRelatedBean subjectRelatedBean) {
                        mView.getSubjectRelatedBean(subjectRelatedBean);
                    }

                }));
    }
}
