package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.codearms.maoqiqi.skin.R;

/**
 * AutoCompleteTextView更新皮肤帮助类,AutoCompleteTextView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/6 21:11
 */
public class SkinAutoCompleteTextViewHelper extends SkinHelper<AutoCompleteTextView> {

    private int popupThemeResId = INVALID_RESOURCES;
    private int dropDownSelectorResId = INVALID_RESOURCES;

    public SkinAutoCompleteTextViewHelper(AutoCompleteTextView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinAutoCompleteTextViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinAutoCompleteTextViewHelper_android_popupTheme)) {
                popupThemeResId = a.getResourceId(R.styleable.SkinAutoCompleteTextViewHelper_android_popupTheme, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinAutoCompleteTextViewHelper_android_dropDownSelector)) {
                dropDownSelectorResId = a.getResourceId(R.styleable.SkinAutoCompleteTextViewHelper_android_dropDownSelector, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置下拉菜单的背景
     *
     * @param resId resource id
     */
    public void setSupportDropDownBackgroundResource(int resId) {
        dropDownSelectorResId = resId;
        applySupportDropDownSelector();
    }

    /**
     *
     */
    private void applySupportPopupTheme() {

    }

    /**
     * 应用下拉菜单的背景
     */
    private void applySupportDropDownSelector() {
        if (dropDownSelectorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(dropDownSelectorResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(dropDownSelectorResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(dropDownSelectorResId);
        }
        if (drawable == null) return;
        view.setDropDownBackgroundDrawable(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportPopupTheme();
        applySupportDropDownSelector();
    }
}