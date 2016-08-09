package com.maolv.tmall.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.maolv.tmall.R;

/**
 * Created by zhujingling on 16/5/6.
 */
public class MainActivity extends FragmentActivity {

    private TextView fragmentSettingTitle;

    private HomepageFragment homepageFragment;
    private ClassifyFragment classifyFragment;
    private ShoppingcartFragment shoppingcartFragment;
    private MyselfFragment myselfFragment;

    private TextView menu_txt_homepage, menu_txt_classify, menu_txt_shoppingcart, menu_txt_myself;

    private FrameLayout fragment_homepage, fragment_classify, fragment_shoppingcart, fragment_myself;

    private ImageView imv_homepage, imv_classify, imv_shoppingcart, imv_myself;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_activity);
            viewInit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewInit() {
        initControl();
        setEvent();
        clickHomePage();
    }

    /*
  初始化控件
   */
    private void initControl() {

        fragmentSettingTitle = (TextView) findViewById(R.id.fragment_setting_title_txt);
//        Color.rgb(128, 187, 65)

        fragment_homepage = (FrameLayout) findViewById(R.id.fragment_homepage);
        fragment_classify = (FrameLayout) findViewById(R.id.fragment_classify);
        fragment_shoppingcart = (FrameLayout) findViewById(R.id.fragment_shoppingcart);
        fragment_myself = (FrameLayout) findViewById(R.id.fragment_myself);

        imv_homepage = (ImageView) findViewById(R.id.imv_homepage);
        imv_classify = (ImageView) findViewById(R.id.imv_classify);
        imv_shoppingcart = (ImageView) findViewById(R.id.imv_shoppingcart);
        imv_myself = (ImageView) findViewById(R.id.imv_myself);

        menu_txt_homepage = (TextView) findViewById(R.id.menu_txt_homepage);
        menu_txt_classify = (TextView) findViewById(R.id.menu_txt_classify);
        menu_txt_shoppingcart = (TextView) findViewById(R.id.menu_txt_shoppingcart);
        menu_txt_myself = (TextView) findViewById(R.id.menu_txt_myself);

    }

    /*
    设置事件
     */
    private void setEvent() {
        fragment_homepage.setOnClickListener(new ViewOnclick());
        fragment_classify.setOnClickListener(new ViewOnclick());
        fragment_shoppingcart.setOnClickListener(new ViewOnclick());
        fragment_myself.setOnClickListener(new ViewOnclick());

    }

    private class ViewOnclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fragment_homepage:
                    clickHomePage();
                    break;
                case R.id.fragment_classify:
                    clickClassify();
                    break;
                case R.id.fragment_shoppingcart:
                    clickShoppingcart();
                    break;
                case R.id.fragment_myself:
                    clickMyself();
                    break;
            }

        }
    }

    private void clickMyself() {
        myselfFragment = new MyselfFragment();
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // 替换当前的页面
        fragmentTransaction.replace(R.id.fragment_content, myselfFragment);
        // 事务管理提交
        fragmentTransaction.commit();
        // 改变选中状态
        setSelect(fragment_homepage, imv_homepage, menu_txt_homepage, false);

        setSelect(fragment_classify, imv_classify, menu_txt_classify, false);

        setSelect(fragment_shoppingcart, imv_shoppingcart, menu_txt_shoppingcart, false);

        setSelect(fragment_myself, imv_myself, menu_txt_myself, true);

        fragmentSettingTitle.setText("个人中心");

    }


    private void clickShoppingcart() {
        shoppingcartFragment = new ShoppingcartFragment();
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // 替换当前的页面
        fragmentTransaction.replace(R.id.fragment_content, shoppingcartFragment);
        // 事务管理提交
        fragmentTransaction.commit();
        // 改变选中状态
        setSelect(fragment_homepage, imv_homepage, menu_txt_homepage, false);

        setSelect(fragment_classify, imv_classify, menu_txt_classify, false);

        setSelect(fragment_shoppingcart, imv_shoppingcart, menu_txt_shoppingcart, true);

        setSelect(fragment_myself, imv_myself, menu_txt_myself, false);

        fragmentSettingTitle.setText("购物车");
    }

    private void clickClassify() {
        classifyFragment = new ClassifyFragment();
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // 替换当前的页面
        fragmentTransaction.replace(R.id.fragment_content, classifyFragment);
        // 事务管理提交
        fragmentTransaction.commit();
        // 改变选中状态
        setSelect(fragment_homepage, imv_homepage, menu_txt_homepage, false);

        setSelect(fragment_classify, imv_classify, menu_txt_classify, true);

        setSelect(fragment_shoppingcart, imv_shoppingcart, menu_txt_shoppingcart, false);

        setSelect(fragment_myself, imv_myself, menu_txt_myself, false);

        fragmentSettingTitle.setText("分类");

    }

    private void clickHomePage() {
        homepageFragment = new HomepageFragment();
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager().beginTransaction();
        // 替换当前的页面
        fragmentTransaction.replace(R.id.fragment_content, homepageFragment);
        // 事务管理提交
        fragmentTransaction.commit();
        // 改变选中状态
        setSelect(fragment_homepage, imv_homepage, menu_txt_homepage, true);

        setSelect(fragment_classify, imv_classify, menu_txt_classify, false);

        setSelect(fragment_shoppingcart, imv_shoppingcart, menu_txt_shoppingcart, false);

        setSelect(fragment_myself, imv_myself, menu_txt_myself, false);

        fragmentSettingTitle.setText("毛驴商城");
    }

    private void setSelect(FrameLayout frameLayout, ImageView imv, TextView textView, boolean flag) {
        frameLayout.setSelected(flag);
        imv.setSelected(flag);
        textView.setSelected(flag);

    }
}
