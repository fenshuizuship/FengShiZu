package com.example.shap.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends IBaseView, P extends IBasePresenter> extends Fragment implements IBaseView {

    private Unbinder bind;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(),null);
        bind = ButterKnife.bind(this, inflate);

        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }

        initFragments();
        initView();
        initData();
        initListener();

        return inflate;
    }

    protected void initListener() {

    }


    protected void initData() {

    }

    protected void initView() {

    }

    protected void initFragments() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }
    }

    protected abstract P getPresenter();

    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (bind != null) {
            bind.unbind();
        }
    }

    @Override
    public void showError(String errorMsg) {

    }

    protected boolean isNeedToBackStack() {
        return false;
    }
}
