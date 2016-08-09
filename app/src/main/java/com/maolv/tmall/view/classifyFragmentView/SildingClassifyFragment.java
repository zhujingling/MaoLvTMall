package com.maolv.tmall.view.classifyFragmentView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.maolv.tmall.R;

/**
 * Created by zhujingling on 16/5/25.
 */

public class SildingClassifyFragment extends Fragment {
    private String mTitle;

    public static SildingClassifyFragment getInstance(String title) {
        SildingClassifyFragment sf = new SildingClassifyFragment();
        sf.mTitle = title;
        return sf;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_simple_silding, null);
        TextView content_tv = (TextView) v.findViewById(R.id.content_tv);
        content_tv.setText(mTitle);

        return v;
    }
}
