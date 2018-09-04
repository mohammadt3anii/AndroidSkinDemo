package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
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

    }

    /**
     * 应用背景着色
     */
    private void applySupportBackgroundTint() {

    }

    /**
     * 应用前景资源
     */
    private void applySupportForeground() {

    }

    /**
     * 应用前景着色
     */
    private void applySupportForegroundTint() {

    }

    @Override
    public void updateSkin() {
        applySupportBackground();
        applySupportBackgroundTint();
        applySupportForeground();
        applySupportForegroundTint();
    }
}