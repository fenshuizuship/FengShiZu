package com.example.shap.interfaces.contract;

import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface MainContracy {
    interface View extends IBaseView{
        void  getData();
    }
    interface Presenter extends IBasePresenter<View> {
        void getData();
    }
}
