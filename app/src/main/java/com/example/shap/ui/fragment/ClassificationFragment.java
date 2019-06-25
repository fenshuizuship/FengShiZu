package com.example.shap.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.shap.R;
import com.example.shap.base.BaseFragment;
import com.example.shap.bean.Bean_search;
import com.example.shap.interfaces.contract.Search;
import com.example.shap.presenter.Search_Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificationFragment extends BaseFragment<Search.View, Search.Presenter> implements Search.View {



    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tablayout2)
    VerticalTabLayout tablayout2;
    @BindView(R.id.rx)
    RecyclerView rx;
    Unbinder unbinder;
    private ArrayList<Bean_search.DataBeanX.FilterCategoryBean> filterCategoryBeans;
    private ArrayList<String> strings;

    @Override
    protected Search.Presenter getPresenter() {
        return new Search_Presenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classification;
    }

    @Override
    protected void initView() {
        filterCategoryBeans = new ArrayList<>();
    }

    @Override
    protected void initData() {
        mPresenter.getData_search();
    }

    @Override
    public void getData_search(Bean_search bean_search) {
            if (bean_search!=null){
                List<Bean_search.DataBeanX.FilterCategoryBean> filterCategory = bean_search.getData().getFilterCategory();
                filterCategoryBeans.addAll(filterCategory);
            }
        strings = new ArrayList<>();
        for (int i = 0; i < filterCategoryBeans.size(); i++) {
            String name = filterCategoryBeans.get(i).getName();
            strings.add(name);
        }
        tablayout2.setTabAdapter(new TabAdapter() {
                @Override
                public int getCount() {
                    return strings.size();
                }

                @Override
                public ITabView.TabBadge getBadge(int position) {
                    return null;
                }

                @Override
                public ITabView.TabIcon getIcon(int position) {
                    return null;
                }

                @Override
                public ITabView.TabTitle getTitle(int position) {
                    return  new ITabView.TabTitle.Builder()
                            .setContent(strings.get(position))
                            .setTextColor(Color.BLUE, Color.BLACK)
                            .build();
                }

                @Override
                public int getBackground(int position) {
                    return 0;
                }
            });
    }
}
