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
import com.example.shap.bean.SubjectRelatedBean;
import com.example.shap.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class SubRelatedAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<SubjectRelatedBean.DataBean> mSubjectRelatedBeans;


    public SubRelatedAdapter(Context context, ArrayList<SubjectRelatedBean.DataBean> subjectRelatedBeans) {
        mContext = context;

        mSubjectRelatedBeans = subjectRelatedBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_subject_related, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        ViewHolder viewHolder = (ViewHolder) holder;
        SubjectRelatedBean.DataBean dataBean = mSubjectRelatedBeans.get(i);
        Glide.with(mContext).load(dataBean.getScene_pic_url()).into(viewHolder.mSubjectItemRelatedIv);
        viewHolder.mSubjectItemRelatedTv1.setText(dataBean.getTitle());
        viewHolder.mSubjectItemRelatedTv1.setText(dataBean.getSubtitle());
        viewHolder.mSubjectItemRelatedTv1.setText(dataBean.getPrice_info()+"元起");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, RelatedActivity.class);
//                intent.putExtra("listId", id);
//                mContext.startActivity(intent);
                ToastUtil.showLong("url");
            }
        });
    }


    @Override
    public int getItemCount() {
        return mSubjectRelatedBeans.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mSubjectItemRelatedIv;
        TextView mSubjectItemRelatedTv1;
        TextView mSubjectItemRelatedTv2;
        TextView mSubjectItemRelatedTv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mSubjectItemRelatedIv = (ImageView) itemView.findViewById(R.id.subject_item_related_iv);
            this.mSubjectItemRelatedTv1 = (TextView) itemView.findViewById(R.id.subject_item_related_tv1);
            this.mSubjectItemRelatedTv2 = (TextView) itemView.findViewById(R.id.subject_item_related_tv2);
            this.mSubjectItemRelatedTv3 = (TextView) itemView.findViewById(R.id.subject_item_related_tv3);
        }
    }
}
