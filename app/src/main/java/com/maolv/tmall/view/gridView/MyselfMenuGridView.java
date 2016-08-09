package com.maolv.tmall.view.gridView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by zhujingling on 16/5/16.
 */
public class MyselfMenuGridView extends GridView {

    public MyselfMenuGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyselfMenuGridView(Context context) {
        super(context);
    }

    public MyselfMenuGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
