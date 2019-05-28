package com.tianyi.retrofit_okhttp_rxjava_mvp.app;

import android.content.Context;

/**
 * Uesr：92863 on 2019/5/27 14:44
 * Email：928636443@qq.com
 * Project: Retrofit_okhttp_rxjava_mvp
 */
public class ProjectInit {

    public static Configurator init(Context context) {

        Configurator.getInstance()
                .getConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT.name());
    }

}

