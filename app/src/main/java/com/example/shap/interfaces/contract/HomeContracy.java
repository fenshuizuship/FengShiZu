package com.example.shap.interfaces.contract;

import com.example.shap.bean.IndexBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface HomeContracy {
    interface View extends IBaseView{
       void BannerReturen(IndexBean indexBean);

    }
    interface Presenter extends IBasePresenter<View>{
        void Bann();

    }
}
