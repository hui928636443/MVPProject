package com.tianyi.retrofit_okhttp_rxjava_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tianyi.retrofit_okhttp_rxjava_mvp.net.RestClient;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.RxRestClient;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IError;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.IFailure;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.callback.ISuccess;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url="site/sign";
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","test");
        map.put("password","123123");
        /**
         * 没使用rxjava的方式
         */

//        RestClient.create().url("site/sign")
//                .params(map)
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String response) {
//                        Toast.makeText(MainActivity.this,"登录成功了"+response,Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .failure(new IFailure() {
//                    @Override
//                    public void onFailure() {
//                        Toast.makeText(MainActivity.this,"没网",Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .error(new IError() {
//                    @Override
//                    public void onError(int code, String msg) {
//                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .build()
//                .post();

        /**
         * 使用rxjava
         */

        RxRestClient.create()
                .url(url)
                .params(map)
                .build()
                .post()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(MainActivity.this,"登录成功了22"+s,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this,"没网",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}


