package com.maolv.tmall.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maolv.tmall.R;

/**
 * Created by zhujingling on 16/5/4.
 */
public class RegisterActivity extends Activity {
    private LinearLayout title_back;
    private TextView setting_title_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.register_activity);
        viewInit();
        super.onCreate(savedInstanceState);
    }

    private void viewInit() {
        initControl();
        setEvent();
    }

    /*
    初始化控件
     */
    private void initControl() {
        title_back = (LinearLayout) findViewById(R.id.title_back);
        setting_title_txt = (TextView) findViewById(R.id.setting_title_txt);
        setting_title_txt.setText("注册");
    }

    /*
    设置事件
     */
    private void setEvent() {
        title_back.setOnClickListener(new ViewOnclik());
    }


    private class ViewOnclik implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.title_back:
                    RegisterActivity.this.finish();
                    break;
            }
        }
    }
}
