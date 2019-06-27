package com.example.shap.interfaces.contract;

import com.example.shap.bean.SubjectDetailBean;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface SubjectDetail {
    interface SubjectDetailView extends IBaseView {
        void  getSubjectDetailBean(SubjectDetailBean subjectDetailBean);
    }
    interface SubjectDetailPresenter extends IBasePresenter<SubjectDetailView> {
        void getSubjectDetailBean(int id);
    }

}
