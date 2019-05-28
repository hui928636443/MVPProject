package com.tianyi.retrofit_okhttp_rxjava_mvp;

import android.app.Application;

import com.tianyi.retrofit_okhttp_rxjava_mvp.app.ProjectInit;

/**
 * Uesr：92863 on 2019/5/27 15:09
 * Email：928636443@qq.com
 * Project: Retrofit_okhttp_rxjava_mvp
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ProjectInit.init(this)
                .withApiHost("http://mars.yikong.tianyigps.com/")
                .configure();
    }
}
