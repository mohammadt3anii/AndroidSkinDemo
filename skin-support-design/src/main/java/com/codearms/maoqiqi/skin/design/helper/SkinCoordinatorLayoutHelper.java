package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * CoordinatorLayout更新皮肤帮助类,CoordinatorLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 18:24
 */
public class SkinCoordinatorLayoutHelper extends SkinHelper<CoordinatorLayout> {

    private int statusBarBackgroundResId = INVALID_RESOURCES;

    public SkinCoordinatorLayoutHelper(CoordinatorLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinCoordinatorLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinCoordinatorLayoutHelper_statusBarBackground)) {
                statusBarBackgroundResId = a.getResourceId(R.styleable.SkinCoordinatorLayoutHelper_statusBarBackground, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 设置StatusBar背景资源
     *
     * @param resId resource id
     */
    public void setSupportStatusBarBackgroundResource(int resId) {
        statusBarBackgroundResId = resId;
        applySupportStatusBarBackground();
    }

    /**
     * 应用StatusBar背景资源
     */
    private void applySupportStatusBarBackground() {
        if (isNotNeedSkin(statusBarBackgroundResId)) return;
        String typeName = getTypeName(statusBarBackgroundResId);
        if (isColor(typeName)) {
            int color = getColor(statusBarBackgroundResId);
            if (color == 0) return;
            view.setStatusBarBackgroundColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(statusBarBackgroundResId);
            if (drawable == null) return;
            view.setStatusBarBackground(drawable);
        }
    }

    @Override
    public void updateSkin() {
        applySupportStatusBarBackground();
    }
}