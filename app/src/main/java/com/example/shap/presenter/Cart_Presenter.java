package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.ShoppingCartBean;
import com.example.shap.interfaces.contract.CartContracy;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class Cart_Presenter extends BasePresenter<CartContracy.View> implements CartContracy.Presenter {

    @Override
    public void getData_cart() {
        addSubscribe(HttpUtils.getMyServer().getdata_cart()
                .compose(RxUtils.<ShoppingCartBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ShoppingCartBean>(mView) {

                    @Override
                    public void onNext(ShoppingCartBean bean_search) {
                        mView.getData_cart(bean_search);
                    }
                }));
    }
}
