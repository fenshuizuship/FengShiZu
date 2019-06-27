package com.example.shap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.shap.R;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.interfaces.IBaseView;
import com.example.shap.utils.SystemUtils;

import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by dell on 2019/5/30.
 */

public abstract class BaseActivity<V extends IBaseView, P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);

        if (!SystemUtils.checkNetWork()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.not_net, null);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addContentView(inflate, params);
        } else {
            mPresenter = getPresenter();
       //     mPresenter.attchView(this);

            initFragments();
            initView();
            initData();
            initListener();
        }


    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void initFragments() {

    }


    protected abstract P getPresenter();

    protected abstract int getLayoutId();


    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public void addFragment(FragmentManager manager, Class<? extends BaseFragment> zClass, int layoutID, Bundle args) {

        String tag = zClass.getName();

        Fragment fragment = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment == null) {
            try {
                fragment = zClass.newInstance();

                BaseFragment baseFragment = (BaseFragment) fragment;
                fragment.setArguments(args);
                transaction.add(layoutID, fragment,tag);
                hideOtherFragment(manager, transaction, fragment);
                if (baseFragment.isNeedToBackStack()) {
                    transaction.addToBackStack(tag);
                }
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    fragment.setArguments(args);
                    transaction.show(fragment);
                    hideOtherFragment(manager, transaction, fragment);
                    transaction.commit();
                }
            } else {

                fragment.setArguments(args);
                transaction.add(layoutID, fragment,tag);
                hideOtherFragment(manager, transaction, fragment);
                transaction.commit();
            }
        }
    }

    private void hideOtherFragment(FragmentManager manager, FragmentTransaction transaction, Fragment willShowFragment) {
        List<Fragment> fragments = manager.getFragments();

        for (Fragment fragment : fragments) {
            if (fragment != willShowFragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }

}
