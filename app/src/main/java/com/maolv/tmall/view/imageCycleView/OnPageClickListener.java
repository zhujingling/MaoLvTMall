package com.maolv.tmall.view.imageCycleView;

import android.view.View;

import com.maolv.tmall.bean.CycleImageInfo;

/**
 * Created by zhujingling on 16/5/12.
 */
public interface OnPageClickListener {
    /**
     * 单击图片事件
     *
     * @param imageView 被点击的View对象
     * @param imageInfo 数据信息
     */
    void onClick(View imageView, CycleImageInfo imageInfo);
}
