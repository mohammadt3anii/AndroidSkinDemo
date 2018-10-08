package com.codearms.maoqiqi.skin.design.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinCoordinatorLayoutHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinCoordinatorLayout继承CoordinatorLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 18:32
 */
public class SkinCoordinatorLayout extends CoordinatorLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * CoordinatorLayout更新皮肤帮助类
     */
    private SkinCoordinatorLayoutHelper skinCoordinatorLayoutHelper;

    public SkinCoordinatorLayout(Context context) {
        this(context, null);
    }

    @SuppressLint("PrivateResource")
    public SkinCoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.coreui.R.attr.coordinatorLayoutStyle);
    }

    public SkinCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinCoordinatorLayoutHelper = new SkinCoordinatorLayoutHelper(this);
        skinCoordinatorLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setStatusBarBackgroundResource(int resId) {
        super.setStatusBarBackgroundResource(resId);
        if (skinCoordinatorLayoutHelper != null) {
            skinCoordinatorLayoutHelper.setSupportStatusBarBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinCoordinatorLayoutHelper != null) {
            skinCoordinatorLayoutHelper.updateSkin();
        }
    }
}