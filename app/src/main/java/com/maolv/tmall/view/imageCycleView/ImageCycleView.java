package com.maolv.tmall.view.imageCycleView;

/**
 * Created by zhujingling on 16/5/10.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maolv.tmall.R;
import com.maolv.tmall.adapter.ImageCycleAdapter;
import com.maolv.tmall.bean.CycleImageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <Pre>
 * 自定义图片自动轮播控件，自定轮播指示器样式，支持点击，无限轮播，网络下载图片</br>
 * 可是使用XUtil的BitmapUtils也可是使用smart-image-view加载图片，支持轮播文字切换</br>
 * 此插件是基于viewpager实现的,需要导入android-support-v4.jar</br></br>
 * <p>
 * 如果使用网络图片记得加权限。</br>
 * uses-permission android:name="android.permission.INTERNET"
 * uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
 * <p>
 * 主要功能:</br></br>
 * 1.支持设置文字提示</br>
 * 2.支持修改轮播指示器的样式及位置（修改view_cycle_image.xml样式,不能修改id）</br>
 * 3.支持修改文字提样式及位置（修改view_cycle_image.xml样式,不能修改id）</br>
 * 4.支持设置是否开启自动轮播</br>
 * 5.支持运行中启动和停止自动轮播</br>
 * 6.支持网络加载图片，资源图片id，sd卡图片</br>
 * 7.设置支持XUtil的BitmapUtils也可是使用smart-image-view加载图片</br>
 * 8.支持点击事件</br>
 * 9.默认是第一张</br></br>
 * <p>
 * demo实例:</br> </br>
 * <p>
 * List<ImageCycleView.ImageInfo> list=new ArrayList<ImageCycleView.ImageInfo>();
 * mImageCycleView = (ImageCycleView) findViewById(R.id.icv_topView);
 * <p>
 * //避免网络图片和本地图片混合使用，特殊要求可在ImageCycleView.LoadImageCallBack回调中判断处理
 * //判断是数字加载本地图片，是http请求加载网络图片
 * List<ImageCycleView.ImageInfo> list=new ArrayList<ImageCycleView.ImageInfo>();
 * <p>
 * //使用本地图片
 * //list.add(new ImageCycleView.ImageInfo(R.drawable.a1,"111111111111",""));
 * //list.add(new ImageCycleView.ImageInfo(R.drawable.a2,"222222222222222",""));
 * //list.add(new ImageCycleView.ImageInfo(R.drawable.a3,"3333333333333",""));
 * <p>
 * //SD卡图片资源
 * list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a1.jpg"),"11111",""));
 * list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a2.jpg"),"22222",""));
 * list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a3.jpg"),"33333",""));
 * <p>
 * //使用网络加载图片
 * list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/57ab6dc2-43f2-4087-81e2-b5ab5681642d.jpg","3333333333333",""));
 * list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/cb56a1a6-6c33-41e4-9c3c-363f4ec6b728.jpg","222222222222222",""));
 * list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/e4229e25-3906-4049-9fe8-e2b52a98f6d1.jpg","3333333333333",""));
 * <p>
 * <p>
 * mImageCycleView.loadData(list, new ImageCycleView.LoadImageCallBack() {
 *
 * @Override public ImageView loadAndDisplay(ImageCycleView.ImageInfo imageInfo){
 * <p>
 * //本地图片
 * //ImageView imageView=new ImageView(MainActivity.this);
 * //imageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
 * //return imageView;
 * <p>
 * //使用SD卡图片
 * SmartImageView smartImageView=new SmartImageView(MainActivity.this);
 * smartImageView.setImageURI(Uri.fromFile((File)imageInfo.image));
 * return smartImageView;
 * <p>
 * //使用SmartImageView
 * //SmartImageView smartImageView=new SmartImageView(MainActivity.this);
 * //smartImageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
 * //return smartImageView;
 * <p>
 * //使用BitmapUtils
 * BitmapUtils bitmapUtils=new BitmapUtils(MainActivity.this);
 * ImageView imageView=new ImageView(MainActivity.this);
 * bitmapUtils.display(imageView,imageInfo.image.toString());
 * return imageView;
 * }
 * });
 */
public class ImageCycleView extends FrameLayout {

    private Context mContext;
    private ImageCycleViewPager mViewPager;
    private List<CycleImageInfo> data = new ArrayList<CycleImageInfo>();
    private LoadImageCallBack mLoadImageCallBack;//加载图片回调函数
    private LinearLayout mIndicationGroup;// 图片轮播指示器容器
    private int mCount;//轮播总数
    private Bitmap unFocusIndicationStyle;//未获得焦点指示器资源
    private Bitmap focusIndicationStyle;//获得焦点指示器资源
    private float indication_self_margin_percent = 0.5f;//指示器间距相对于自身的百分比,默认间距为指示器高度的1/2
    private OnPageClickListener mOnPageClickListener;//单击事件监听器
    private TextView mText;//图片文本提示


    public ImageCycleView(Context context) {
        super(context);
        init(context);
    }

    public ImageCycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        unFocusIndicationStyle = drawCircle(50, Color.GRAY);
        focusIndicationStyle = drawCircle(50, Color.WHITE);
        initView();
    }


    /**
     * 初始化view控件
     */
    private void initView() {
        View.inflate(mContext, R.layout.view_image_cycle, this);
        FrameLayout fl_image_cycle = (FrameLayout) findViewById(R.id.fl_image_cycle);
        mViewPager = new ImageCycleViewPager(mContext);
        mViewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fl_image_cycle.addView(mViewPager);
        mViewPager.setOnPageChangeListener(new ImageCyclePageChangeListener());
        mIndicationGroup = (LinearLayout) findViewById(R.id.ll_indication_group);
        mText = (TextView) findViewById(R.id.tv_text);
    }

    public enum IndicationStyle {
        COLOR, IMAGE
    }

    /**
     * 设置轮播指示器样式，如果你对默认的样式不满意可以自己设置
     *
     * @param indicationStyle         资源类型,color,image,shape
     * @param unFocus                 未获得焦点指示器资源id  图片或shape或color值
     * @param focus                   获得焦点指示器资源id 图片或shape或color值
     * @param indication_self_percent 自身高度的百分比 >=0f
     */
    public void setIndicationStyle(IndicationStyle indicationStyle, int unFocus, int focus, float indication_self_percent) {
        if (indicationStyle == IndicationStyle.COLOR) {
            unFocusIndicationStyle = drawCircle(50, unFocus);
            focusIndicationStyle = drawCircle(50, focus);
        } else if (indicationStyle == IndicationStyle.IMAGE) {
            unFocusIndicationStyle = BitmapFactory.decodeResource(mContext.getResources(), unFocus);
            focusIndicationStyle = BitmapFactory.decodeResource(mContext.getResources(), focus);
        }
        indication_self_margin_percent = indication_self_percent;
        initIndication();
    }

    /**
     * 图片轮播是自动滚动状态  true 自动滚动，false 图片不能自动滚动只能手动左右滑动
     */
    private boolean isAutoCycle = true;
    /**
     * 自动轮播时间间隔默认5秒
     */
    private long mCycleDelayed = 5000;

    /**
     * 设置是否自动无限轮播
     *
     * @param delayed 自动轮播时间间隔
     */
    public void setCycleDelayed(long delayed) {
        mCycleDelayed = delayed;
    }

    /**
     * 设置是否自动无限轮播
     *
     * @param state
     */
    public void setAutoCycle(Boolean state) {
        isAutoCycle = state;
    }

    /**
     * 加载显示的数据  网络图片资源及标题
     *
     * @param list     数据
     * @param callBack 如何加载图片及显示的回调方法 not null
     */
    public void loadData(List<CycleImageInfo> list, LoadImageCallBack callBack) {
        data = list;
        mCount = list.size();
        initIndication();
        if (callBack == null) {
            new IllegalArgumentException("LoadImageCallBack 回调函数不能为空！");
        }
        mLoadImageCallBack = callBack;
        mViewPager.setAdapter(new ImageCycleAdapter(mCount, data, mLoadImageCallBack, mOnPageClickListener));
        //最大值中间 的第一个
        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - ((Integer.MAX_VALUE / 2) % mCount));
    }

    /**
     * 设置点击事件监听回调函数
     *
     * @param listener
     */
    public void setOnPageClickListener(OnPageClickListener listener) {
        mOnPageClickListener = listener;
    }


    /**
     * 初始化指标器
     */
    private void initIndication() {
        mIndicationGroup.removeAllViews();
        for (int i = 0; i < mCount; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mIndicationGroup.getLayoutParams().height, LinearLayout.LayoutParams.MATCH_PARENT);
            params.leftMargin = (int) (mIndicationGroup.getLayoutParams().height * indication_self_margin_percent);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(params);
            if (i == 0) {
                imageView.setImageBitmap(focusIndicationStyle);
            } else {
                imageView.setImageBitmap(unFocusIndicationStyle);
            }
            mIndicationGroup.addView(imageView);
        }
    }

    private Bitmap drawCircle(int radius, int color) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);// 设置颜色
        Bitmap bitmap = Bitmap.createBitmap(radius, radius, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(radius / 2, radius / 2, radius / 2, paint);
        return bitmap;
    }


    public static class ImageInfo {
        public ImageInfo(Object image, String text, Object value) {
            this.image = image;
            this.text = text;
            this.value = value;
        }

        public Object image;
        public String text = "";
        public Object value;
    }


    public class ImageCyclePageChangeListener implements ViewPager.OnPageChangeListener {
        //上次指示器指示的位置,开始为默认位置0
        private int preIndex = 0;

        @Override
        public void onPageSelected(int index) {
            index = index % mCount;
            //更新文本信息
            String text = data.get(index).text;
            mText.setText(TextUtils.isEmpty(text) ? "" : text);
            //恢复默认没有获得焦点指示器样式
            ((ImageView) (mIndicationGroup.getChildAt(preIndex))).setImageBitmap(unFocusIndicationStyle);
            // 设置当前显示图片的指示器样式
            ((ImageView) (mIndicationGroup.getChildAt(index))).setImageBitmap(focusIndicationStyle);
            preIndex = index;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

    }

}
