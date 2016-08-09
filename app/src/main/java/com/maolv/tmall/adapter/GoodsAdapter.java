package com.maolv.tmall.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maolv.tmall.R;
import com.maolv.tmall.bean.GoodInfo;

import java.util.List;

/**
 * Created by zhujingling on 16/5/15.
 */
public class GoodsAdapter extends BaseAdapter {

    private final String TAG = GoodsAdapter.class.getName();
    private List<GoodInfo> list;
    private Context mContext;

    public GoodsAdapter(Context context, List<GoodInfo> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.hotseal_listview, viewGroup, false);
            holder = new ViewHolder();
            holder.iv_hotsealgood = (ImageView) view.findViewById(R.id.iv_hotsealgood);
            holder.introductions = (TextView) view.findViewById(R.id.introductions);

            holder.specifications = (TextView) view.findViewById(R.id.specifications);
            holder.fresh = (TextView) view.findViewById(R.id.fresh);
            holder.prices = (TextView) view.findViewById(R.id.prices);

            view.setTag(holder);

        } else {// 有直接获得ViewHolder
            holder = (ViewHolder) view.getTag();
        }

        Log.i(TAG, "getViewPosition:" + i);
        GoodInfo goodInfo = list.get(i);

        //赋值
        holder.iv_hotsealgood.setImageResource(R.drawable.raw_1461058498);
        holder.introductions.setText(goodInfo.getIntroductions());
        holder.specifications.setText(goodInfo.getSpecifications());
        holder.fresh.setText(goodInfo.getFresh());
        holder.prices.setText(goodInfo.getPrices());

        return view;
    }


    static class ViewHolder {
        ImageView iv_hotsealgood;
        TextView introductions;
        TextView specifications;
        TextView fresh;
        TextView prices;
    }
}
