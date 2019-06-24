package com.example.shap.app;

import android.app.Application;

/**
 * Created by dell on 2019/5/30.
 */

public class MyApp extends Application {
    public static MyApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}
