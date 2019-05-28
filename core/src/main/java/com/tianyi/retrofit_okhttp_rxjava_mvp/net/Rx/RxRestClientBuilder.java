package com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx;

import com.tianyi.retrofit_okhttp_rxjava_mvp.net.RestClient;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IError;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IFailure;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IRequest;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.ISuccess;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Uesr：92863 on 2019/5/27 16:26
 * Email：928636443@qq.com
 * Project: Retrofit_okhttp_rxjava_mvp
 */
public class RxRestClientBuilder {

    private HashMap<String,Object> mParams;
    private  String mUrl;

    private RequestBody mBody;

    //上传下载
    private File mFile;


    RxRestClientBuilder(){

    }

    public final RxRestClientBuilder url(String url){
        this.mUrl=url;
        return this;
    }
    public final RxRestClientBuilder params(HashMap<String,Object> params){
        this.mParams=params;
        return this;
    }

    public final RxRestClientBuilder raw(String raw){
        this.mBody=RequestBody.create(
                MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }
    //上传
    public final RxRestClientBuilder file(File file){
        this.mFile=file;
        return this;
    }
    public final RxRestClientBuilder file(String file){
        this.mFile=new File(file);
        return this;
    }



    public final RxRestClient build(){
        return new RxRestClient(mParams,mUrl,mBody,mFile);
    }
}
