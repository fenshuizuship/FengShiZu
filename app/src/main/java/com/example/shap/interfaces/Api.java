package com.example.shap.interfaces;

import com.example.shap.bean.Bean_search;
import com.example.shap.bean.IndexBean;
import com.example.shap.bean.SubjectDetailBean;
import com.example.shap.bean.SubjectListBean;
import com.example.shap.bean.SubjectRelatedBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //---------home---------
    @GET("index/index")
    Flowable<IndexBean> getData();
    //==============fgsdf----------------
    //http://cdwan.cn:8360/api/goods/list
    @GET("goods/list")
    Flowable<Bean_search> getdata_search();



    //============subject==========
    @GET("topic/list")
    Flowable<SubjectListBean> getSubjectListBean();

    //========SubjectDetailBean========
    @GET("topic/detail")
    Flowable<SubjectDetailBean> getSubjectDetailBean(@Query("id") int id);

    //========SubjectDetailBean========
    @GET("topic/related")
    Flowable<SubjectRelatedBean> getSubjectRelatedBean(@Query("id") int id);

}
