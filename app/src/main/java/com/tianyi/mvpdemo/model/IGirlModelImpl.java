package com.tianyi.mvpdemo.model;




import android.util.Log;
import android.widget.Toast;

import com.tianyi.mvpdemo.R;
import com.tianyi.mvpdemo.bean.Girl;
import com.tianyi.retrofit_okhttp_rxjava_mvp.MainActivity;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.RxRestClient;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.rxbus.RxBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yyh on 2018/6/4.
 */

public class IGirlModelImpl implements IGirlModel{


    @Override
    public void loadGirlData() {



        RxBus.getInstance().chainProcess(new Function() {

            @Override
            public Object apply(@NonNull final Object o) throws Exception {
                //在这里面进行网络操作

                String url="site/sign";
                HashMap<String, Object> map = new HashMap<>();
                map.put("username","test");
                map.put("password","123123");

                Observable<String> observable = RxRestClient.create()
                        .url(url)
                        .params(map)
                        .build()
                        .post()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        ;
//                observable
//                        .subscribe(new Observer<String>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(String s) {
//
//
//                                Log.d("TAG", "onNext: 登录成功了");
//                                // Toast.makeText(MainActivity.this,"登录成功了22"+s,Toast.LENGTH_SHORT).show();
//
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.d("TAG", "onNext: 没网");
////                                Toast.makeText(MainActivity.this,"没网",Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });

//                List<Girl> data = new ArrayList<Girl>();
//                data.add(new Girl(R.drawable.f1, "*****", "123潮流女个性字母印花无袖露脐上衣"));
//                data.add(new Girl(R.drawable.f2, "231412星", "迷依诗诺夏天新款韩版女装性感夜店欧美风字母印花牛仔露脐背心上衣"));
//                data.add(new Girl(R.drawable.f3, "五颗星", "迷依诗诺春夏欧美新款性感女装单排扣牛仔背心露脐上衣"));
//                data.add(new Girl(R.drawable.f4, "三颗星", "美莉丹 新款欧美单排扣牛仔背心露脐上衣"));
//                data.add(new Girl(R.drawable.f5, "五颗星", "夏季新款韩版时尚个性字母无袖露脐上衣"));
//                data.add(new Girl(R.drawable.f6, "三颗星", "新款欧美单排扣牛仔背心露脐上衣"));
//                data.add(new Girl(R.drawable.f7, "四颗星", "夏装新款下摆波浪边挂脖露肩"));
//                data.add(new Girl(R.drawable.f8, "五颗星", "夏天新款欧美时尚潮流休闲百"));
//                data.add(new Girl(R.drawable.f9, "四颗星", "迷依诗诺夏季新款小香风甜美性感夜"));
//                data.add(new Girl(R.drawable.f10, "三颗星", "安巴克夏季新款韩版时尚套"));

//                return data;

                return observable;

            }
        });
    }
}
