package com.codearms.maoqiqi.skin.demo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * 演示ScrimInsetsFrameLayout,NavigationView换肤属性
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/11/7 11:45
 */
public class NavigationViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("NavigationView");
        setSupportActionBar(toolbar);
    }
}