package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.Bean_search;
import com.example.shap.interfaces.contract.Search;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class Cart_Presenter extends BasePresenter<Search.View> implements Search.Presenter {

    @Override
    public void getData_search() {
        addSubscribe(HttpUtils.getMyServer().getdata_search()
                .compose(RxUtils.<Bean_search>rxScheduler())
                .subscribeWith(new CommonSubscriber<Bean_search>(mView) {

                    @Override
                    public void onNext(Bean_search bean_search) {
                        mView.getData_search(bean_search);
                    }
                }));
    }
}
