package com.maolv.tmall.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.maolv.tmall.R;
import com.maolv.tmall.adapter.ClassifyPagerAdapter;
import com.maolv.tmall.tools.ViewFindUtils;
import com.maolv.tmall.view.classifyFragmentView.SildingClassifyFragment;

import java.util.ArrayList;

/**
 * Created by zhujingling on 16/5/8.
 */
public class ClassifyFragment extends Fragment implements OnTabSelectListener {

    private Context mContext = getActivity();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "全部", "热卖水果", "零食小吃", "坚果干货"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classify_fragment, container, false);
        initControl(view);
        return view;
    }

    private void initControl(View view) {
        for (String title : mTitles) {
            mFragments.add(SildingClassifyFragment.getInstance(title));
        }

        ViewPager vp = (ViewPager) view.findViewById(R.id.vp);
        vp.setAdapter(new ClassifyPagerAdapter(getActivity().getSupportFragmentManager(), mFragments, mTitles));

        /** 默认 */
        SlidingTabLayout tabLayout_1 = (SlidingTabLayout)view.findViewById(R.id.tl_1);

        tabLayout_1.setViewPager(vp);
        vp.setCurrentItem(0);//默认选中第三个
//        tabLayout_1.showDot(3);//增加右上角红点
    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }
}
