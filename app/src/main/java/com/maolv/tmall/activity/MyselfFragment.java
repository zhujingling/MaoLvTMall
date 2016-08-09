package com.maolv.tmall.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.maolv.tmall.R;
import com.maolv.tmall.data.MyselfRepository;
import com.maolv.tmall.view.gridView.MyselfMenuGridView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhujingling on 16/5/8.
 */
public class MyselfFragment extends Fragment {
    private MyselfMenuGridView myselfMenuGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myself_fragment, container, false);
        initControl(view);
        return view;
    }

    private void initControl(View view) {
        myselfMenuGridView = (MyselfMenuGridView) view.findViewById(R.id.myself_menu_gridview);
        setData();
    }


    private void setData(){

        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        lstImageItem= MyselfRepository.getMyselfMenuInfo(getContext());
        SimpleAdapter saImageItems = new SimpleAdapter(getContext(), //没什么解释
                lstImageItem,//数据来源
                R.layout.myself_gridview_item,//night_item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.myself_menu_iv_item, R.id.myself_menu_tv_item});
        //添加并且显示
        myselfMenuGridView.setAdapter(saImageItems);
    }
}
