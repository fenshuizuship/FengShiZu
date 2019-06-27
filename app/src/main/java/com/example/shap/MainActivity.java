package com.example.shap;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

import com.example.shap.base.BaseActivity;
import com.example.shap.interfaces.IBasePresenter;
import com.example.shap.ui.fragment.ClassificationFragment;
import com.example.shap.ui.fragment.HomeFragment;
import com.example.shap.ui.fragment.MyFragment;
import com.example.shap.ui.fragment.ShoppingFragment;
import com.example.shap.ui.fragment.SubjectFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tb)
    Toolbar mTb;
    private FragmentManager manager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initFragments() {

        manager = getSupportFragmentManager();

        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.drawable.home));
        mTl.addTab(mTl.newTab().setText("专题").setIcon(R.drawable.subject));
        mTl.addTab(mTl.newTab().setText("分类").setIcon(R.drawable.classification));
        mTl.addTab(mTl.newTab().setText("购物车").setIcon(R.drawable.shopping));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.drawable.my));
    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        addFragment(getSupportFragmentManager(), HomeFragment.class, R.id.fl, null);
        mTb.setTitle("");
        setSupportActionBar(mTb);
    }

    @Override
    protected void initListener() {
        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    addFragment(manager, HomeFragment.class, R.id.fl, null);
                } else if (position == 1) {
                    addFragment(manager, SubjectFragment.class, R.id.fl, null);
                } else if (position == 2) {
                    addFragment(manager, ClassificationFragment.class, R.id.fl, null);
                } else if (position == 3) {
                    addFragment(manager, ShoppingFragment.class, R.id.fl, null);
                } else if (position == 4) {
                    addFragment(manager, MyFragment.class, R.id.fl, null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void showError(String errorMsg) {

    }
}
