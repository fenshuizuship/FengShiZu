package com.example.shap.interfaces;

import com.example.shap.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Api {

    //---------home---------
    @GET("index/index")
    Flowable<IndexBean> getData();


    //==============fgsdf----------------
}
