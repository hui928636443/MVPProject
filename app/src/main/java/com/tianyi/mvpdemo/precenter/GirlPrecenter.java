package com.tianyi.mvpdemo.precenter;



import android.util.Log;

import com.tianyi.mvpdemo.bean.Girl;
import com.tianyi.mvpdemo.model.IGirlModel;
import com.tianyi.mvpdemo.model.IGirlModelImpl;
import com.tianyi.mvpdemo.view.IGirlView;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.rxbus.RegisterRxBus;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableObserveOn;

/**
 * 所有的业务逻辑都在表示层完成
 */

public class GirlPrecenter<T extends IGirlView> {
    //1.view层的引用
    WeakReference<T> mView;
    //2.model层的引用
    IGirlModel iGirlModel=new IGirlModelImpl();

    public GirlPrecenter(T view){
        this.mView=new WeakReference<T>(view);

        //请求网络数据
        iGirlModel.loadGirlData();
    }

    //3.执行UI逻辑操作
//    public void fetch(){
//        if(mView.get()!=null && iGirlModel!=null){
//            iGirlModel.loadGirl(new IGirlModel.GirlOnLoadListener() {
//                @Override
//                public void onComplete(List<Girl> list) {
//                    mView.get().showGirls(list);
//                }
//            });
//        }
//    }


    @RegisterRxBus
    public void getShowGirlsData(ObservableObserveOn observable){
        if(mView.get()!=null){

            observable.subscribe(new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(String s) {

                    mView.get().showGirls(s);
                    Log.d("TAG", "onNext: 登录成功了"+s);
                    // Toast.makeText(MainActivity.this,"登录成功了22"+s,Toast.LENGTH_SHORT).show();


                }

                @Override
                public void onError(Throwable e) {
                    Log.d("TAG", "onNext: 没网");
//                                Toast.makeText(MainActivity.this,"没网",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onComplete() {

                }
            });

//            mView.get().showGirls(list);
        }
    }
}








