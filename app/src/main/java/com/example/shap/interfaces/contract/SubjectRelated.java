package com.example.shap.interfaces.contract;
import com.example.shap.bean.SubjectRelatedBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface SubjectRelated {
    interface SubjectRelatedView extends IBaseView {
        void  getSubjectRelatedBean(SubjectRelatedBean subjectRelatedBean);
    }

    interface SubjectRelatedPresenter extends IBasePresenter<SubjectRelatedView> {
        void getSubjectRelatedBean(int id);
    }
}
