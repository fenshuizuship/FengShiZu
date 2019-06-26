package com.example.shap.interfaces;

import com.example.shap.bean.Bean_search;
import com.example.shap.bean.IndexBean;
import com.example.shap.bean.SubjectListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

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

}
