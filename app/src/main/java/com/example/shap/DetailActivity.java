package com.example.shap;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shap.base.BaseActivity;
import com.example.shap.bean.SubjectDetailBean;
import com.example.shap.interfaces.contract.SubjectDetail;
import com.example.shap.presenter.SubjectDetailP;
import com.example.shap.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailActivity extends BaseActivity<SubjectDetail.SubjectDetailView, SubjectDetailP>
        implements SubjectDetail.SubjectDetailView {


    @BindView(R.id.detail_banner)
    Banner mDetailBanner;
    @BindView(R.id.detail_tv1)
    TextView mDetailTv1;
    @BindView(R.id.detail_cb)
    CheckBox mDetailCb;
    @BindView(R.id.detail_iv2)
    ImageView mDetailIv2;
    @BindView(R.id.detail_tv2)
    TextView mDetailTv2;
    @BindView(R.id.detail_tv3)
    TextView mDetailTv3;
    @BindView(R.id.detail_tv4)
    TextView mDetailTv4;
    @BindView(R.id.detail_tv5)
    TextView mDetailTv5;
    @BindView(R.id.detail_tv6)
    TextView mDetailTv6;
    @BindView(R.id.detail_tv7)
    TextView mDetailTv7;
    private int mListId;
    private ArrayList<String> mUrl;

    @Override
    protected SubjectDetailP getPresenter() {
        return new SubjectDetailP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mListId = intent.getIntExtra("listId", 0);
        mDetailCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mDetailCb.setBackground(getDrawable(R.drawable.wujiaoxings1));
                }else {
                    mDetailCb.setBackground(getDrawable(R.drawable.wujiaoxingk));
                }
            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.getSubjectDetailBean(mListId);
    }

    @Override
    public void getSubjectDetailBean(SubjectDetailBean subjectDetailBean) {
        SubjectDetailBean.DataBean data = subjectDetailBean.getData();
        String title = data.getTitle();//主标题
        String subtitle = data.getSubtitle();//副标题
        String item_pic_url = data.getItem_pic_url();//第一张图片
        String scene_pic_url = data.getScene_pic_url(); //第二张图片
        float price_info = data.getPrice_info();
        mUrl = new ArrayList<>();
        mUrl.add(item_pic_url);
        mUrl.add(scene_pic_url);
        mDetailBanner.setImages(mUrl).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        mDetailTv5.setText(title);
        mDetailTv6.setText(subtitle);
        mDetailTv7.setText("¥"+price_info);




    }

    @Override
    public void showError(String errorMsg) {
        ToastUtil.showLong("错误是：" + errorMsg);
    }

    @OnClick({R.id.detail_tv1, R.id.detail_tv3, R.id.detail_tv4, R.id.detail_cb, R.id.detail_iv2, R.id.detail_tv2})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.detail_tv1:
                break;
            case R.id.detail_tv3:
                break;
            case R.id.detail_tv4:
                break;
            case R.id.detail_cb:
                break;
            case R.id.detail_iv2:
                break;
            case R.id.detail_tv2:
                break;
        }
    }

}
