package com.example.shap.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shap.R;
import com.example.shap.bean.IndexBean;

import java.util.ArrayList;

import butterknife.internal.Utils;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHloder> {
    private ArrayList<IndexBean.DataBean.BrandListBean>list;
    private Context context;

    public AdapterList(ArrayList<IndexBean.DataBean.BrandListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<IndexBean.DataBean.BrandListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list, null);
        ViewHloder viewHloder = new ViewHloder(inflate);
        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder viewHloder, int i) {
        viewHloder.tv1.setText(list.get(i).getName());
        viewHloder.tv2.setText(list.get(i).getFloor_price()+"元起");
        Glide.with(context).load(list.get(i).getNew_pic_url()).into(viewHloder.im);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;


        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im_home);
            tv1=itemView.findViewById(R.id.tv_home1);
            tv2=itemView.findViewById(R.id.tv_home2);

        }
    }
}
