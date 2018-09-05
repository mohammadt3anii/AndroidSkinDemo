package com.codearms.maoqiqi.skin.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.R;

/**
 * View更新皮肤帮助类,View及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/4 20:16
 */
public class SkinViewHelper extends SkinHelper<View> {

    private int backgroundResId = INVALID_RESOURCES;
    private int backgroundTintResId = INVALID_RESOURCES;
    private int foregroundResId = INVALID_RESOURCES;
    private int foregroundTintResId = INVALID_RESOURCES;

    public SkinViewHelper(View view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinViewHelper_android_background)) {
                backgroundResId = a.getResourceId(R.styleable.SkinViewHelper_android_background, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinViewHelper_android_backgroundTint)) {
                backgroundTintResId = a.getResourceId(R.styleable.SkinViewHelper_android_backgroundTint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinViewHelper_android_foreground)) {
                foregroundResId = a.getResourceId(R.styleable.SkinViewHelper_android_foreground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinViewHelper_android_foregroundTint)) {
                foregroundTintResId = a.getResourceId(R.styleable.SkinViewHelper_android_foregroundTint, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置背景资源
     *
     * @param resId resource id
     */
    public void setSupportBackgroundResource(int resId) {
        backgroundResId = resId;
        applySupportBackground();
    }

    /**
     * 应用背景资源
     */
    private void applySupportBackground() {
        if (backgroundResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(backgroundResId);
        if (isColor(typeName)) {
            int color = getColor(backgroundResId);
            if (color == 0) return;
            view.setBackgroundColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(backgroundResId);
            if (drawable == null) return;
            ViewCompat.setBackground(view, drawable);
        }
    }

    /**
     * 应用背景着色
     */
    private void applySupportBackgroundTint() {
        if (backgroundTintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(backgroundTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(backgroundTintResId);
            if (colorStateList == null) return;
            ViewCompat.setBackgroundTintList(view, colorStateList);
        }
    }

    /**
     * 应用前景资源
     */
    private void applySupportForeground() {
        if (foregroundResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(foregroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(foregroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(foregroundResId);
        }
        if (drawable == null) return;
        view.setForeground(drawable);
    }

    /**
     * 应用前景着色
     */
    private void applySupportForegroundTint() {
        if (foregroundTintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(foregroundTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(foregroundTintResId);
            if (colorStateList == null) return;
            view.setForegroundTintList(colorStateList);
        }
    }

    @Override
    public void updateSkin() {
        applySupportBackground();
        applySupportBackgroundTint();
        applySupportForeground();
        applySupportForegroundTint();
    }
}
