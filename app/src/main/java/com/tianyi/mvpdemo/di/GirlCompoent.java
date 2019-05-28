package com.tianyi.mvpdemo.di;

import com.tianyi.mvpdemo.MainActivity;

import dagger.Component;

/**
 * Uesr：92863 on 2019/5/28 10:55
 * Email：928636443@qq.com
 * Project: mvpdemo
 */
@Component(modules = {GirlPrecenterModule.class})
public interface GirlCompoent {

    void inject(MainActivity mainActivity);
}
