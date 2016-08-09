package com.maolv.tmall.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maolv.tmall.R;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private Context mContext;
    private Button btnToRegister;
    private Button btnLogin;
    private LinearLayout title_back;
    private TextView setting_title_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            setContentView(R.layout.login_activity);
            viewInit();
            super.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewInit() {
        mContext = this;
        initControl();
        setEvent();
    }

    /*
    初始化控件
     */
    private void initControl() {
        btnToRegister = (Button) findViewById(R.id.btn_toregister);
        btnLogin = (Button) findViewById(R.id.btn_login);
        title_back = (LinearLayout) findViewById(R.id.title_back);
        setting_title_txt = (TextView) findViewById(R.id.setting_title_txt);
        setting_title_txt.setText("登录");
    }

    /*
    设置事件
     */
    private void setEvent() {
        btnToRegister.setOnClickListener(new ViewOnclik());
        btnLogin.setOnClickListener(new ViewOnclik());
        title_back.setOnClickListener(new ViewOnclik());
    }


    private class ViewOnclik implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.btn_toregister:
                    intent = new Intent(mContext, RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_login:
                    intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.title_back:
                    LoginActivity.this.finish();
                    break;
            }
        }
    }

}

