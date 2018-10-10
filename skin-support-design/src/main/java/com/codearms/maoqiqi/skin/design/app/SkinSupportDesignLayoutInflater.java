package com.codearms.maoqiqi.skin.design.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.design.widget.SkinAppBarLayout;
import com.codearms.maoqiqi.skin.design.widget.SkinBottomNavigationView;
import com.codearms.maoqiqi.skin.design.widget.SkinCollapsingToolbarLayout;
import com.codearms.maoqiqi.skin.design.widget.SkinCoordinatorLayout;
import com.codearms.maoqiqi.skin.design.widget.SkinFloatingActionButton;
import com.codearms.maoqiqi.skin.design.widget.SkinNavigationView;
import com.codearms.maoqiqi.skin.design.widget.SkinTabLayout;
import com.codearms.maoqiqi.skin.design.widget.SkinTextInputEditText;
import com.codearms.maoqiqi.skin.design.widget.SkinTextInputLayout;

/**
 * 实现自定义SkinLayoutInflater接口来创建视图
 * 使用自定义SkinView替换系统对应View,而不是通过反射创建对应的视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/10 11:22
 */
public class SkinSupportDesignLayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (!name.startsWith("android.support.design.widget.")) return null;
        View view = null;
        switch (name) {
            case "android.support.design.widget.CoordinatorLayout":
                view = new SkinCoordinatorLayout(context, attrs);
                break;
            case "android.support.design.widget.AppBarLayout":
                view = new SkinAppBarLayout(context, attrs);
                break;
            case "android.support.design.widget.CollapsingToolbarLayout":
                view = new SkinCollapsingToolbarLayout(context, attrs);
                break;
            case "android.support.design.widget.FloatingActionButton":
                view = new SkinFloatingActionButton(context, attrs);
                break;
            case "android.support.design.widget.BottomNavigationView":
                view = new SkinBottomNavigationView(context, attrs);
                break;
            case "android.support.design.widget.NavigationView":
                view = new SkinNavigationView(context, attrs);
                break;
            case "android.support.design.widget.TabLayout":
                view = new SkinTabLayout(context, attrs);
                break;
            case "android.support.design.widget.TextInputLayout":
                view = new SkinTextInputLayout(context, attrs);
                break;
            case "android.support.design.widget.TextInputEditText":
                view = new SkinTextInputEditText(context, attrs);
                break;
        }
        return view;
    }
}