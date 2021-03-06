package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.ListPopupWindow;

import com.codearms.maoqiqi.skin.R;

import java.lang.reflect.Field;

/**
 * AutoCompleteTextView更新皮肤帮助类,AutoCompleteTextView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/6 21:11
 */
public class SkinAutoCompleteTextViewHelper extends SkinHelper<AutoCompleteTextView> {

    private int popupThemeResId = INVALID_RESOURCES;
    private int popupBackgroundResId = INVALID_RESOURCES;
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
            if (a.hasValue(R.styleable.SkinAutoCompleteTextViewHelper_android_popupBackground)) {
                popupBackgroundResId = a.getResourceId(R.styleable.SkinAutoCompleteTextViewHelper_android_popupBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinAutoCompleteTextViewHelper_android_dropDownSelector)) {
                dropDownSelectorResId = a.getResourceId(R.styleable.SkinAutoCompleteTextViewHelper_android_dropDownSelector, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
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
        // TODO: 18/10/28 待完善
    }

    /**
     * 应用popup的背景
     */
    private void applySupportPopupBackground() {
        if (isNotNeedSkin(popupBackgroundResId)) return;
        String typeName = getTypeName(popupBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(popupBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(popupBackgroundResId);
        }
        if (drawable == null) return;
        view.setDropDownBackgroundDrawable(drawable);
    }

    /**
     * 设置popup项的背景
     *
     * @param autoCompleteTextView 视图
     * @param drawable             需要赋值的资源
     */
    private void setDropDownSelector(AutoCompleteTextView autoCompleteTextView, Drawable drawable) {
        try {
            String name = "mPopup";
            Field fPopup = AutoCompleteTextView.class.getDeclaredField(name);
            fPopup.setAccessible(true);
            ListPopupWindow popup = (ListPopupWindow) fPopup.get(autoCompleteTextView);
            popup.setListSelector(drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用popup项的背景
     */
    private void applySupportDropDownSelector() {
        if (isNotNeedSkin(dropDownSelectorResId)) return;
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
        setDropDownSelector(view, drawable);
    }

    @Override
    public void updateSkin() {
        applySupportPopupTheme();
        applySupportPopupBackground();
        applySupportDropDownSelector();
    }
}