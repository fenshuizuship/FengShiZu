package com.example.shap.adaper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shap.R;
import com.example.shap.RelatedActivity;
import com.example.shap.bean.SubjectListBean;

import java.util.ArrayList;

 public class SubListAdapter extends RecyclerView.Adapter {

     private Context mContext;
     private ArrayList<SubjectListBean.DataBeanX.DataBean> mDataBeans;


    public SubListAdapter(Context context, ArrayList<SubjectListBean.DataBeanX.DataBean> dataBeans) {
        mContext = context;

        mDataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_subject_list, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        ViewHolder viewHolder = (ViewHolder) holder;
        SubjectListBean.DataBeanX.DataBean model = mDataBeans.get(i);
        Glide.with(mContext).load(model.getScene_pic_url()).into(viewHolder.mSubjectItemIv);
        viewHolder.mSubjectItemTv1.setText(model.getTitle());
        viewHolder.mSubjectItemTv2.setText(model.getSubtitle());
        viewHolder.mSubjectItemTv3.setText(model.getPrice_info()+"元起");

        final int id = model.getId();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RelatedActivity.class);
                intent.putExtra("listId",id);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataBeans.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mSubjectItemIv;
        TextView mSubjectItemTv1;
        TextView mSubjectItemTv2;
        TextView mSubjectItemTv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mSubjectItemIv = (ImageView) itemView.findViewById(R.id.subject_item_iv);
            this.mSubjectItemTv1 = (TextView) itemView.findViewById(R.id.subject_item_tv1);
            this.mSubjectItemTv2 = (TextView) itemView.findViewById(R.id.subject_item_tv2);
            this.mSubjectItemTv3 = (TextView) itemView.findViewById(R.id.subject_item_tv3);
        }
    }



}
