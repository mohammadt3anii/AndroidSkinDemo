package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * NavigationView更新皮肤帮助类,NavigationView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 11:14
 */
public class SkinNavigationViewHelper extends SkinHelper<NavigationView> {

    private int itemTextAppearanceResId = INVALID_RESOURCES;
    private int itemBackgroundResId = INVALID_RESOURCES;
    private int itemIconTintResId = INVALID_RESOURCES;
    private int itemTextColorResId = INVALID_RESOURCES;

    public SkinNavigationViewHelper(NavigationView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinNavigationViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinNavigationViewHelper_itemTextAppearance)) {
                itemTextAppearanceResId = a.getResourceId(R.styleable.SkinNavigationViewHelper_itemTextAppearance, INVALID_RESOURCES);
                obtainItemTextAppearance();
            }
            if (a.hasValue(R.styleable.SkinNavigationViewHelper_itemBackground)) {
                itemBackgroundResId = a.getResourceId(R.styleable.SkinNavigationViewHelper_itemBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinNavigationViewHelper_itemIconTint)) {
                itemIconTintResId = a.getResourceId(R.styleable.SkinNavigationViewHelper_itemIconTint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinNavigationViewHelper_itemTextColor)) {
                itemTextColorResId = a.getResourceId(R.styleable.SkinNavigationViewHelper_itemTextColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 解析itemTextAppearance,获取属性值
     */
    private void obtainItemTextAppearance() {
        if (itemTextAppearanceResId == INVALID_RESOURCES) return;
        TypedArray a = view.getContext().obtainStyledAttributes(itemTextAppearanceResId, R.styleable.SkinTextAppearance);
        try {
            if (a.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
                itemTextColorResId = a.getResourceId(R.styleable.SkinTextAppearance_android_textColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置每一项背景资源
     *
     * @param resId resource id
     */
    public void setSupportItemBackgroundResource(int resId) {
        itemBackgroundResId = resId;
        applySupportItemBackground();
    }

    /**
     * 应用每一项背景资源
     */
    private void applySupportItemBackground() {
        if (itemBackgroundResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(itemBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(itemBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(itemBackgroundResId);
        }
        if (drawable == null) return;
        view.setItemBackground(drawable);
    }

    /**
     * 应用每一项着色
     */
    private void applySupportItemIconTint() {
        if (itemIconTintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(itemIconTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(itemIconTintResId);
            if (colorStateList == null) return;
            view.setItemIconTintList(colorStateList);
        }
    }

    /**
     * 应用每一项文本颜色
     */
    private void applySupportItemTextColor() {
        if (itemTextColorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(itemTextColorResId);
        if (isColor(typeName) || isDrawable(typeName)) {
            ColorStateList colorStateList = getColorStateList(itemTextColorResId);
            if (colorStateList == null) return;
            view.setItemTextColor(colorStateList);
        }
    }

    @Override
    public void updateSkin() {
        applySupportItemBackground();
        applySupportItemIconTint();
        applySupportItemTextColor();
    }
}