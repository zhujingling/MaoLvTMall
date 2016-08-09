package com.maolv.tmall.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maolv.tmall.R;

/**
 * Created by zhujingling on 16/5/8.
 */
public class ShoppingcartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingcart_fragment, container, false);
        initControl(view);
        return view;
    }

    private void initControl(View view) {
    }
}
