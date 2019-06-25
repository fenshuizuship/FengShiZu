package com.example.shap;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.shap.base.BaseActivity;
import com.example.shap.interfaces.contract.MainContracy;
import com.example.shap.presenter.HomePresenter;
import com.example.shap.ui.fragment.ClassificationFragment;
import com.example.shap.ui.fragment.HomeFragment;
import com.example.shap.ui.fragment.MyFragment;
import com.example.shap.ui.fragment.ShoppingFragment;
import com.example.shap.ui.fragment.SubjectFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContracy.View, MainContracy.Presenter> implements MainContracy.View {

    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentManager manager;

    @Override
    protected MainContracy.Presenter getPresenter() {
            return new HomePresenter();
    }

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
    protected void initView() {
        addFragment(getSupportFragmentManager(), HomeFragment.class, R.id.fl, null);
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
