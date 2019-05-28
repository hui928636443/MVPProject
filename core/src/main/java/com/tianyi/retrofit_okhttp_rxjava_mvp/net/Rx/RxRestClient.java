package com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx;

import com.tianyi.retrofit_okhttp_rxjava_mvp.net.HttpMethod;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.RestClientBuilder;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.RestCreator;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.RestService;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IError;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IFailure;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IRequest;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.ISuccess;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.RequestCallbacks;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.download.DownloadHandler;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Uesr：92863 on 2019/5/27 16:06
 * Email：928636443@qq.com
 * Project: Retrofit_okhttp_rxjava_mvp
 *
 *
 *
 * 使用Rxjava的方式
 */
public class RxRestClient {

    private final HashMap<String,Object> PARAMS;
    private final String URL;

    private final RequestBody BODY;
    //上传下载
    private final File FILE;


    public RxRestClient(HashMap<String, Object> params,
                        String url,
                        RequestBody body,
                        File file) {
        this.PARAMS = params;
        this.URL = url;

        this.BODY = body;

        this.FILE=file;

    }

    public static RxRestClientBuilder create(){
        return new RxRestClientBuilder();
    }

    //开始实现真实的网络操作
    private Observable<String> request(HttpMethod method){
        RxRestService service = RestCreator.getRxRestService();
        Observable<String> observable=null;

        switch(method){
            case GET:
                observable=service.get(URL,PARAMS);
                break;
            case POST:
                observable=service.post(URL,PARAMS);
                break;
            case PUT:
                observable=service.put(URL,PARAMS);
                break;
            case DELETE:
                observable=service.delete(URL,PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MultipartBody.FORM,FILE);
                final MultipartBody.Part body=MultipartBody.Part.createFormData(
                        "file",FILE.getName(),requestBody);
                observable=service.upload(URL,body);
                break;
            default:
                break;
        }

        return observable;
    }


    //各种请求
    public final Observable<String> get(){
       return request(HttpMethod.GET);
    }
    public final Observable<String> post(){
        return request(HttpMethod.POST);
    }
    public final Observable<String> put(){
        return request(HttpMethod.PUT);
    }
    public final Observable<String> delete(){
        return request(HttpMethod.DELETE);
    }
    public final Observable<String> upload(){
        return request(HttpMethod.UPLOAD);
    }
    public final Observable<ResponseBody> download(){
        return RestCreator.getRxRestService().download(URL,PARAMS);
    }
}
