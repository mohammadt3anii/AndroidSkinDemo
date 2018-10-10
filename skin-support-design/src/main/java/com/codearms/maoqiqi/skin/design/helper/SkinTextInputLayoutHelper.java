package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * TextInputLayout更新皮肤帮助类,TextInputLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/10 10:10
 */
public class SkinTextInputLayoutHelper extends SkinHelper<TextInputLayout> {

    private boolean isApplyHintTextAppearance = true;
    private boolean isApplyErrorTextAppearance = true;
    private boolean isApplyCounterTextAppearance = true;
    private boolean isApplyCounterOverflowTextAppearance = true;

    private int textColorHintResId = INVALID_RESOURCES;
    private int hintTextAppearanceResId = INVALID_RESOURCES;
    private int errorTextAppearanceResId = INVALID_RESOURCES;
    private int counterTextAppearanceResId = INVALID_RESOURCES;
    private int counterOverflowTextAppearanceResId = INVALID_RESOURCES;
    private int passwordToggleDrawableResId = INVALID_RESOURCES;
    private int passwordToggleTintResId = INVALID_RESOURCES;

    public SkinTextInputLayoutHelper(TextInputLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinTextInputLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_android_textColorHint)) {
                textColorHintResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_android_textColorHint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_hintTextAppearance)) {
                hintTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_hintTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_errorTextAppearance)) {
                errorTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_errorTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_counterTextAppearance)) {
                counterTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_counterTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_counterOverflowTextAppearance)) {
                counterOverflowTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_counterOverflowTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_passwordToggleDrawable)) {
                passwordToggleDrawableResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_passwordToggleDrawable, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_passwordToggleTint)) {
                passwordToggleTintResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_passwordToggleTint, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置字体样式
     *
     * @param resId resource id
     */
    public void setSupportHintTextAppearance(int resId) {
        if (isApplyHintTextAppearance) {
            hintTextAppearanceResId = resId;
            applySupportHintTextAppearance();
        } else {
            isApplyHintTextAppearance = true;
        }
    }

    /**
     * 设置字体样式
     *
     * @param resId resource id
     */
    public void setSupportErrorTextAppearance(int resId) {
        if (isApplyErrorTextAppearance) {
            errorTextAppearanceResId = resId;
            applySupportErrorTextAppearance();
        } else {
            isApplyErrorTextAppearance = true;
        }
    }

    /**
     * 设置密码开关资源
     *
     * @param resId resource id
     */
    public void setSupportPasswordVisibilityToggleDrawable(int resId) {
        passwordToggleDrawableResId = resId;
        applySupportPasswordVisibilityToggleDrawable();
    }

    /**
     * 应用字体样式
     */
    private void applySupportHintTextAppearance() {
        if (hintTextAppearanceResId == INVALID_RESOURCES) return;
        int id = getTargetResId(hintTextAppearanceResId);
        if (id == 0) id = hintTextAppearanceResId;
        isApplyHintTextAppearance = false;
        view.setHintTextAppearance(id);
    }

    /**
     * 应用字体样式
     */
    private void applySupportErrorTextAppearance() {
        if (errorTextAppearanceResId == INVALID_RESOURCES) return;
        int id = getTargetResId(errorTextAppearanceResId);
        if (id == 0) id = errorTextAppearanceResId;
        isApplyErrorTextAppearance = false;
        view.setErrorTextAppearance(id);
    }

    /**
     * 应用密码开关资源
     */
    private void applySupportPasswordVisibilityToggleDrawable() {
        if (passwordToggleDrawableResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(passwordToggleDrawableResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(passwordToggleDrawableResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(passwordToggleDrawableResId);
        }
        if (drawable == null) return;
        view.setPasswordVisibilityToggleDrawable(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportHintTextAppearance();
        applySupportErrorTextAppearance();
        applySupportPasswordVisibilityToggleDrawable();
    }
}