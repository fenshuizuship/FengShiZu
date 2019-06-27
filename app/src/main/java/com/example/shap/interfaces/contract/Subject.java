package com.example.shap.interfaces.contract;

import com.example.shap.bean.Bean_search;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface Subject {
    interface SubjectView extends IBaseView {
        void  getSubjectListBean(SubjectListBean subjectListBean);
    }
    interface SubjetPresenter extends IBasePresenter<SubjectView> {
        void getSubjectListBean();
    }

}
