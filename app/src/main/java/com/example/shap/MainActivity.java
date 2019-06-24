package com.example.shap;

import com.example.shap.base.BaseActivity;
import com.example.shap.interfaces.contract.MainContracy;
import com.example.shap.presenter.HomePresenter;

public class MainActivity extends BaseActivity<MainContracy.View,MainContracy.Presenter> implements MainContracy.View {
    //这是晚饭前五个完全过去伟哥
    @Override
    protected MainContracy.Presenter getPresenter() {
            return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void getData() {

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }


    @Override
    public void showError(String errorMsg) {

    }
}
