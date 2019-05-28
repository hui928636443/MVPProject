package com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback;

/**
 * Created by yyh on 2018/6/6.
 */
public interface IError {
    void onError(int code, String msg);
}
