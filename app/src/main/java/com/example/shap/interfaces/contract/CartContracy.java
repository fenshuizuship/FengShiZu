package com.example.shap.interfaces.contract;

import com.example.shap.bean.ShoppingCartBean;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

public interface CartContracy {
    interface View extends IBaseView {
        void  getData_cart(ShoppingCartBean bean_search);
    }
    interface Presenter extends IBasePresenter<View> {
        void getData_cart();
    }
}
