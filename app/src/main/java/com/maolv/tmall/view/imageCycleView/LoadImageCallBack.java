package com.maolv.tmall.view.imageCycleView;

import android.widget.ImageView;

import com.maolv.tmall.bean.CycleImageInfo;

/**
 * Created by zhujingling on 16/5/12.
 */
public interface LoadImageCallBack {
    /**
     * 自己如何设置加载图片
     *
     * @param cycleImageInfo 数据信息
     */
    ImageView loadAndDisplay(CycleImageInfo cycleImageInfo);
}
