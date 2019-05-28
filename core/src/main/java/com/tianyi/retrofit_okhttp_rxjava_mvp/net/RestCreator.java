package com.tianyi.retrofit_okhttp_rxjava_mvp.net;

import com.tianyi.retrofit_okhttp_rxjava_mvp.app.ConfigKeys;
import com.tianyi.retrofit_okhttp_rxjava_mvp.app.ProjectInit;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.RxRestService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Uesr：92863 on 2019/5/27 15:50
 * Email：928636443@qq.com
 * Project: Retrofit_okhttp_rxjava_mvp
 */
public class RestCreator {

    /**
     * 产生一个全局的Retrofit客户端
     */
    private static final class RetrofitHolder{
        private static final String BASE_URL = ProjectInit.getConfiguration(ConfigKeys.API_HOST);
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    private static final class OKHttpHolder{
        private static final int TIME_OUT=60;
        private static final OkHttpClient OK_HTTP_CLIENT=new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    //提供接口让调用者得到retrofit对象
    private static final class RestServiceHolder{
        // 这里的私有没有什么意义
        /* private */ static final RestService REST_SERVICE=RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    /**
     * 获取对象
     */
    public static RestService getRestService(){
        // 外围类能直接访问内部类（不管是否是静态的）的私有变量
        return RestServiceHolder.REST_SERVICE;
    }

    //提供接口让调用者得到retrofit对象
    private static final class RxRestServiceHolder{
        // 这里的私有没有什么意义
        /* private */ static final RxRestService REST_SERVICE=RetrofitHolder.RETROFIT_CLIENT.create(RxRestService.class);
    }

    public static RxRestService getRxRestService(){
        // 外围类能直接访问内部类（不管是否是静态的）的私有变量
        return RxRestServiceHolder.REST_SERVICE;
    }

}
