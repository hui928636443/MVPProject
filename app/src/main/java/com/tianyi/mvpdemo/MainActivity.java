package com.tianyi.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


import com.tianyi.mvpdemo.adapter.GirlAdapter;
import com.tianyi.mvpdemo.bean.Girl;
import com.tianyi.mvpdemo.di.DaggerGirlCompoent;
import com.tianyi.mvpdemo.di.GirlPrecenterModule;
import com.tianyi.mvpdemo.precenter.GirlPrecenter;
import com.tianyi.mvpdemo.view.IGirlView;
import com.tianyi.retrofit_okhttp_rxjava_mvp.net.Rx.rxbus.RxBus;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IGirlView {
    ListView list;

    @Inject
    GirlPrecenter precenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listview);
//        new GirlPrecenter(this).fetch();

//        precenter = new GirlPrecenter(this);

        DaggerGirlCompoent.builder().girlPrecenterModule(new GirlPrecenterModule(this)).build()
                .inject(this);

        RxBus.getInstance().register(precenter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        RxBus.getInstance().unregister(precenter);
    }

    @Override
    public void showGirls(String response) {
        //model层的数据在girls中返回了

        Toast.makeText(this,"返回api数据: "+response,Toast.LENGTH_SHORT).show();
    }


}
