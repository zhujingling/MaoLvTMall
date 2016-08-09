package com.maolv.tmall.data;

import android.content.Context;

import com.maolv.tmall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhujingling on 16/5/17.
 */
public class MyselfRepository {

    public static ArrayList<HashMap<String,Object>> getMyselfMenuInfo(Context context){
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_orders);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_myorders));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_coupons);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_mycoupons));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_collection);//添加图像资源的ID
        map.put("ItemText", R.string.myself_menu_mycollection);//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_messagecenter);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_messagecenter));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_onlinecustomerservice);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_onlinecustomerservice));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_distribution);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_mydistribution));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_helpandfeedback);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_helpandfeedback));//按序号做ItemText
        lstImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.myself_receivedaddress);//添加图像资源的ID
        map.put("ItemText", context.getResources().getString(R.string.myself_menu_receivedaddress));//按序号做ItemText
        lstImageItem.add(map);

        return  lstImageItem;
    }
}
