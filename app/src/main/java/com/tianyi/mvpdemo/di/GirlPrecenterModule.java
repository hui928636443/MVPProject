package com.tianyi.mvpdemo.di;

import com.tianyi.mvpdemo.MainActivity;
import com.tianyi.mvpdemo.precenter.GirlPrecenter;

import dagger.Module;
import dagger.Provides;

/**
 * Uesr：92863 on 2019/5/28 10:52
 * Email：928636443@qq.com
 * Project: mvpdemo
 */

@Module
public class GirlPrecenterModule {

    private MainActivity mMainActivity;

    public GirlPrecenterModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    public GirlPrecenter provideGirlPrecenter(){
        return new GirlPrecenter(mMainActivity);
    }
}
