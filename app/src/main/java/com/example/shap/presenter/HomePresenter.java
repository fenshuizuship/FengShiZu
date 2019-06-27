package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.IndexBean;
import com.example.shap.interfaces.contract.HomeContracy;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeContracy.View>implements HomeContracy.Presenter{

    @Override
    public void Bann() {
        addSubscribe(HttpUtils.getMyServer().getData()
        .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView) {
                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.BannerReturen(indexBean);
                    }
                })
        );
    }
}
