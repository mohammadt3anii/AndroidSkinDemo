package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * BottomNavigationView更新皮肤帮助类,BottomNavigationView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 10:57
 */
public class SkinBottomNavigationViewHelper extends SkinHelper<BottomNavigationView> {

    private int itemBackgroundResId = INVALID_RESOURCES;
    private int itemIconTintResId = INVALID_RESOURCES;
    private int itemTextColorResId = INVALID_RESOURCES;

    public SkinBottomNavigationViewHelper(BottomNavigationView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinBottomNavigationViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinBottomNavigationViewHelper_itemBackground)) {
                itemBackgroundResId = a.getResourceId(R.styleable.SkinBottomNavigationViewHelper_itemBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinBottomNavigationViewHelper_itemIconTint)) {
                itemIconTintResId = a.getResourceId(R.styleable.SkinBottomNavigationViewHelper_itemIconTint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinBottomNavigationViewHelper_itemTextColor)) {
                itemTextColorResId = a.getResourceId(R.styleable.SkinBottomNavigationViewHelper_itemTextColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
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
        if (isNotNeedSkin(itemBackgroundResId)) return;
        String typeName = getTypeName(itemBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(itemBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(itemBackgroundResId);
        }
        view.setItemBackground(drawable);
    }

    /**
     * 应用每一项着色
     */
    private void applySupportItemIconTint() {
        if (isNotNeedSkin(itemIconTintResId)) return;
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
        if (isNotNeedSkin(itemTextColorResId)) return;
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