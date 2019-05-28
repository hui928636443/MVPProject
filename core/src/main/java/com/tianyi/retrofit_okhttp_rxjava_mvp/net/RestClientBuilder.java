package com.tianyi.retrofit_okhttp_rxjava_mvp.net;

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
public class RestClientBuilder {

    private HashMap<String,Object> mParams;
    private  String mUrl;
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private RequestBody mBody;

    //上传下载
    private File mFile;

    private String mDownloadDir;
    private  String mExtension;
    private  String mFilename;

    RestClientBuilder(){

    }

    public final RestClientBuilder url(String url){
        this.mUrl=url;
        return this;
    }
    public final RestClientBuilder params(HashMap<String,Object> params){
        this.mParams=params;
        return this;
    }
    public final RestClientBuilder success(ISuccess success){
        this.mSuccess=success;
        return this;
    }
    public final RestClientBuilder request(IRequest request){
        this.mRequest=request;
        return this;
    }
    public final RestClientBuilder error(IError error ){
        this.mError=error;
        return this;
    }
    public final RestClientBuilder failure(IFailure failure){
        this.mFailure=failure;
        return this;
    }
    public final RestClientBuilder raw(String raw){
        this.mBody=RequestBody.create(
                MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }
    //上传
    public final RestClientBuilder file(File file){
        this.mFile=file;
        return this;
    }
    public final RestClientBuilder file(String file){
        this.mFile=new File(file);
        return this;
    }
    //下载
    public final RestClientBuilder dir(String dir){
        this.mDownloadDir=dir;
        return this;
    }
    public final RestClientBuilder extension(String extension){
        this.mExtension=extension;
        return this;
    }
    public final RestClientBuilder filename(String filename){
        this.mFilename=filename;
        return this;
    }


    public final RestClient build(){
        return new RestClient(mParams,mUrl,mRequest,mSuccess,mFailure,mError,mBody,mFile,mDownloadDir,mExtension,mFilename);
    }
}