package com.maolv.tmall.view.circleImageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.maolv.tmall.R;

/**
 * Created by zhujingling on 16/5/12.
 */
public class CircleImageView extends ImageView {

    Path path;
    public PaintFlagsDrawFilter mPaintFlagsDrawFilter;// 毛边过滤
    Paint paint;

    private int backGroundColor;

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleImage);
        this.backGroundColor = array.getColor(R.styleable.CircleImage_backGroundColor,0XFFFFFFFF);
        array.recycle();
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleImage);
        this.backGroundColor = array.getColor(R.styleable.CircleImage_backGroundColor,0XFFFFFFFF);
        array.recycle();
        // TODO Auto-generated constructor stub
        init();
    }

    public void init() {
        mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0,
                Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
//        paint.setColor(Color.rgb(0x80, 0xBB, 0x41));
        paint.setColor(this.backGroundColor);

    }

    @Override
    protected void onDraw(Canvas cns) {
        // TODO Auto-generated method stub
        float h = getMeasuredHeight() - 3.0f;
        float w = getMeasuredWidth() - 3.0f;
        if (path == null) {
            path = new Path();
            path.addCircle(
                    w / 2.0f
                    , h / 2.0f
                    , (float) Math.min(w / 2.0f, (h / 2.0)) + 20f
                    , Path.Direction.CCW);
            path.close();
        }
        cns.drawCircle(w / 2.0f, h / 2.0f, Math.min(w / 2.0f, h / 2.0f) + 20f, paint);
        int saveCount = cns.getSaveCount();
        cns.save();
        cns.setDrawFilter(mPaintFlagsDrawFilter);
        cns.clipPath(path, Region.Op.REPLACE);
        cns.setDrawFilter(mPaintFlagsDrawFilter);
//        cns.drawColor(Color.rgb(0x80, 0xBB, 0x41));
        cns.drawColor(this.backGroundColor);
        super.onDraw(cns);
        cns.restoreToCount(saveCount);
    }
}
