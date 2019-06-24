package com.example.shap.app;

import java.io.File;

public class Constant {

    public static final String Url = "http://cdwan.cn:8360/api/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

}
