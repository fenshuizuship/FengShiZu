package com.example.shap.interfaces.contract;

import com.example.shap.bean.Bean_search;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface Search {
    interface View extends IBaseView {
        void  getData_search(Bean_search bean_search);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_search();
    }
}
