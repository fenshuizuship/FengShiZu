package com.example.shap.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.shap.bean.Bean_search;

import java.util.ArrayList;

public class adaper_Search extends RecyclerView.Adapter<adaper_Search.ViewHolder> {
    private ArrayList<Bean_search.DataBeanX.FilterCategoryBean> nei;
    private Context context;

    public adaper_Search(ArrayList<Bean_search.DataBeanX.FilterCategoryBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
