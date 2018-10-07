package com.codearms.maoqiqi.skin.v4.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.v4.widget.SkinContentLoadingProgressBar;
import com.codearms.maoqiqi.skin.v4.widget.SkinDrawerLayout;
import com.codearms.maoqiqi.skin.v4.widget.SkinNestedScrollView;
import com.codearms.maoqiqi.skin.v4.widget.SkinPagerTabStrip;
import com.codearms.maoqiqi.skin.v4.widget.SkinPagerTitleStrip;
import com.codearms.maoqiqi.skin.v4.widget.SkinSlidingPaneLayout;
import com.codearms.maoqiqi.skin.v4.widget.SkinSwipeRefreshLayout;
import com.codearms.maoqiqi.skin.v4.widget.SkinViewPager;

/**
 * 实现自定义SkinLayoutInflater接口来创建视图
 * 使用自定义SkinView替换系统对应View,而不是通过反射创建对应的视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/7 23:37
 */
public class SkinSupportV4LayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (!name.startsWith("android.support.v4.")) return null;
        View view = null;
        switch (name) {
            case "android.support.v4.widget.ContentLoadingProgressBar":
                view = new SkinContentLoadingProgressBar(context, attrs);
                break;
            case "android.support.v4.widget.NestedScrollView":
                view = new SkinNestedScrollView(context, attrs);
                break;
            case "android.support.v4.widget.DrawerLayout":
                view = new SkinDrawerLayout(context, attrs);
                break;
            case "android.support.v4.widget.SlidingPaneLayout":
                view = new SkinSlidingPaneLayout(context, attrs);
                break;
            case "android.support.v4.widget.SwipeRefreshLayout":
                view = new SkinSwipeRefreshLayout(context, attrs);
                break;
            case "android.support.v4.view.ViewPager":
                view = new SkinViewPager(context, attrs);
                break;
            case "android.support.v4.view.PagerTitleStrip":
                view = new SkinPagerTitleStrip(context, attrs);
                break;
            case "android.support.v4.view.PagerTabStrip":
                view = new SkinPagerTabStrip(context, attrs);
                break;
        }
        return view;
    }
}