package com.example.shap;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shap.base.BaseActivity;
import com.example.shap.base.BaseFragment;
import com.example.shap.interfaces.IBaseView;
import com.example.shap.interfaces.contract.MainContracy;
import com.example.shap.presenter.HomePresenter;
import com.example.shap.ui.fragment.HomeFragment;

public class MainActivity extends BaseActivity<MainContracy.View,MainContracy.Presenter> implements MainContracy.View {

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
