package com.codearms.maoqiqi.skin.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v4.widget.TintableCompoundButton;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.codearms.maoqiqi.skin.R;

/**
 * CompoundButton更新皮肤帮助类,CompoundButton及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/7 19:45
 */
public class SkinCompoundButtonHelper extends SkinHelper<CompoundButton> {

    private int buttonResId = INVALID_RESOURCES;
    private int buttonTintResId = INVALID_RESOURCES;
    private int appButtonTintResId = INVALID_RESOURCES;

    public SkinCompoundButtonHelper(CompoundButton view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinCompoundButtonHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinCompoundButtonHelper_android_button)) {
                buttonResId = a.getResourceId(R.styleable.SkinCompoundButtonHelper_android_button, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCompoundButtonHelper_android_buttonTint)) {
                buttonTintResId = a.getResourceId(R.styleable.SkinCompoundButtonHelper_android_buttonTint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCompoundButtonHelper_buttonTint)) {
                appButtonTintResId = a.getResourceId(R.styleable.SkinCompoundButtonHelper_buttonTint, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 设置CompoundButton Drawable
     *
     * @param resId resource id
     */
    public void setSupportButtonDrawable(int resId) {
        buttonResId = resId;
        applySupportButton();
    }

    /**
     * 应用CompoundButton Drawable
     */
    private void applySupportButton() {
        if (isNotNeedSkin(buttonResId)) return;
        String typeName = getTypeName(buttonResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(buttonResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(buttonResId);
        }
        if (drawable == null) return;
        view.setButtonDrawable(drawable);
    }

    /**
     * 应用CompoundButton Drawable着色
     */
    private void applySupportButtonTint() {
        if (IS_LOLLIPOP) {
            // RadioButton CheckBox 和 ToggleButton 使用 buttonTintResId
            if (!isNotNeedSkin(buttonTintResId)) {
                String typeName = getTypeName(buttonTintResId);
                if (isColor(typeName)) {
                    ColorStateList colorStateList = getColorStateList(buttonTintResId);
                    if (colorStateList != null) view.setButtonTintList(colorStateList);
                }
            }

            // 如果是 AppCompatRadioButton 和 AppCompatCheckBox,并且窜在 appButtonTintResId 便使用
            if (view instanceof TintableCompoundButton) {
                if (isNotNeedSkin(appButtonTintResId)) return;
                String typeName = getTypeName(appButtonTintResId);
                if (isColor(typeName)) {
                    ColorStateList colorStateList = getColorStateList(appButtonTintResId);
                    if (colorStateList != null) view.setButtonTintList(colorStateList);
                }
            }
        } else {
            if (view instanceof TintableCompoundButton) {
                if (isNotNeedSkin(appButtonTintResId)) return;
                String typeName = getTypeName(appButtonTintResId);
                if (isColor(typeName)) {
                    ColorStateList colorStateList = getColorStateList(appButtonTintResId);
                    if (colorStateList == null) return;
                    ((TintableCompoundButton) view).setSupportButtonTintList(colorStateList);
                }
            }
        }
    }

    @Override
    public void updateSkin() {
        applySupportButton();
        applySupportButtonTint();
    }
}