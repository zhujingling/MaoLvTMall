package com.maolv.tmall.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.maolv.tmall.bean.CycleImageInfo;
import com.maolv.tmall.view.imageCycleView.LoadImageCallBack;
import com.maolv.tmall.view.imageCycleView.OnPageClickListener;

import java.util.List;

/**
 * Created by zhujingling on 16/5/10.
 */
public class ImageCycleAdapter extends PagerAdapter {
    private LoadImageCallBack mLoadImageCallBack;
    private List<CycleImageInfo> data;
    private int mCount;
    private OnPageClickListener mOnPageClickListener;

    public ImageCycleAdapter(int mCount, List<CycleImageInfo> data, LoadImageCallBack mLoadImageCallBack, OnPageClickListener mOnPageClickListener) {
        this.mLoadImageCallBack = mLoadImageCallBack;
        this.data = data;
        this.mCount = mCount;
        this.mOnPageClickListener = mOnPageClickListener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final CycleImageInfo imageInfo = data.get(position % mCount);

        ImageView imageView = mLoadImageCallBack.loadAndDisplay(imageInfo);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        // 设置图片点击监听
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnPageClickListener != null) {
                    mOnPageClickListener.onClick(v, imageInfo);
                }
            }
        });

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
