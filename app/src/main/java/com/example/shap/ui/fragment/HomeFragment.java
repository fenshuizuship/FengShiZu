package com.example.shap.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shap.R;
import com.example.shap.adaper.AdapterList;
import com.example.shap.app.Constant;
import com.example.shap.base.BaseFragment;
import com.example.shap.bean.IndexBean;
import com.example.shap.interfaces.contract.HomeContracy;
import com.example.shap.presenter.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment<HomeContracy.View, HomeContracy.Presenter> implements HomeContracy.View {


    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.tv_pin_home)
    TextView tvPinHome;
    @BindView(R.id.rly_home)
    RecyclerView rlyHome;
    Unbinder unbinder;
    @BindView(R.id.banner_home)
    Banner bannerHome;
    private ArrayList<IndexBean.DataBean.BrandListBean> lis;
    private AdapterList adapterList;
    private StaggeredGridLayoutManager layoutManager;


    @Override
    protected HomeContracy.Presenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        lis = new ArrayList<>();
        initFragment();
        layoutManager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        rlyHome.setLayoutManager(layoutManager);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//防止item 交换位置
        adapterList = new AdapterList(lis, getActivity());
        rlyHome.setAdapter(adapterList);
        ((DefaultItemAnimator) rlyHome.getItemAnimator()).setSupportsChangeAnimations(false);
        ((SimpleItemAnimator) rlyHome.getItemAnimator()).setSupportsChangeAnimations(false);
        rlyHome.getItemAnimator().setChangeDuration(0);

    }

    @Override
    protected void initListener() {
        rlyHome.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                layoutManager.invalidateSpanAssignments();//防止第一行到顶部有空白
            }
        });


    }

    private void initFragment() {
        tabHome.addTab(tabHome.newTab().setText("居家").setIcon(R.mipmap.jiajujiafang));
        tabHome.addTab(tabHome.newTab().setText("餐厨").setIcon(R.mipmap.guo));
        tabHome.addTab(tabHome.newTab().setText("配件").setIcon(R.mipmap.gouwuche));
        tabHome.addTab(tabHome.newTab().setText("服装").setIcon(R.mipmap.coat));
        tabHome.addTab(tabHome.newTab().setText("更多").setIcon(R.mipmap.gengduoyundong));

        tabHome.getTabAt(0).select();
        tabHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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
    protected void initData() {
        HomePresenter presenter = (HomePresenter) mPresenter;
        presenter.Bann();
    }

    @Override
    public void BannerReturen(IndexBean indexBean) {
        bannerHome.setImages(indexBean.getData().getBanner())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        IndexBean.DataBean.BannerBean bannerBean = (IndexBean.DataBean.BannerBean) path;
                        Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
                    }
                }).start();
        List<IndexBean.DataBean.BrandListBean> brandList = indexBean.getData().getBrandList();
        lis.addAll(brandList);
        adapterList.setList(lis);
        adapterList.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
