package com.example.shap.presenter;

import com.example.shap.base.BasePresenter;
import com.example.shap.bean.IndexBean;
import com.example.shap.interfaces.contract.MainContracy;
import com.example.shap.utils.CommonSubscriber;
import com.example.shap.utils.HttpUtils;
import com.example.shap.utils.RxUtils;

public class HomePresenter extends BasePresenter<MainContracy.View> implements MainContracy.Presenter {
    @Override
    public void getData() {
        addSubscribe(HttpUtils.getMyServer().getData().compose(RxUtils.<IndexBean>rxScheduler()).subscribeWith(new CommonSubscriber<IndexBean>(mView) {
            @Override
            public void onNext(IndexBean homeBean) {

            }
        }));
    }
}
