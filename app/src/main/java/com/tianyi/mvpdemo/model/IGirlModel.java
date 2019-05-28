package com.tianyi.mvpdemo.model;


import com.tianyi.mvpdemo.bean.Girl;

import java.util.List;

/**
 * model还是原来的model
 */
public interface IGirlModel {
//    //也通过回调的方式返回数据
//    void loadGirl(GirlOnLoadListener girlOnLoadListener);
//    //设置一个回调接口
//    interface GirlOnLoadListener{
//        void onComplete(List<Girl> list);
//    }

    /**
     * 采用rxbus代表接口回调
     */
    public void loadGirlData();
}
















