package com.codearms.maoqiqi.skin.v4.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.v4.helper.SkinDrawerLayoutHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinDrawerLayout继承DrawerLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/22 0:18
 */
public class SkinDrawerLayout extends DrawerLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * DrawerLayout更新皮肤帮助类
     */
    private SkinDrawerLayoutHelper skinDrawerLayoutHelper;

    public SkinDrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public SkinDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinDrawerLayoutHelper = new SkinDrawerLayoutHelper(this);
        skinDrawerLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setStatusBarBackground(int resId) {
        super.setStatusBarBackground(resId);
        if (skinDrawerLayoutHelper != null) {
            skinDrawerLayoutHelper.setSupportStatusBarBackground(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinDrawerLayoutHelper != null) {
            skinDrawerLayoutHelper.updateSkin();
        }
    }
}