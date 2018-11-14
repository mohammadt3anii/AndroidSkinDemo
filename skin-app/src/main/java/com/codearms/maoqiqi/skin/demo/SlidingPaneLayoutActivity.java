package com.codearms.maoqiqi.skin.demo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * 演示SlidingPaneLayout换肤属性
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/11/6 16:45
 */
public class SlidingPaneLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_pane_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SlidingPaneLayout");
        setSupportActionBar(toolbar);
    }
}