package com.codearms.maoqiqi.skin.helper;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

/**
 * NumberPicker更新皮肤帮助类,NumberPicker及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/12 21:45
 */
public class SkinNumberPickerHelper extends SkinHelper<NumberPicker> {

    private int solidColorResId = INVALID_RESOURCES;
    private int selectionDividerResId = INVALID_RESOURCES;
    private int virtualButtonPressedDrawableResId = INVALID_RESOURCES;

    public SkinNumberPickerHelper(NumberPicker view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        /*TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinNumberPickerHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinNumberPickerHelper_android_solidColor)) {
                solidColorResId = a.getResourceId(R.styleable.SkinNumberPickerHelper_android_solidColor, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinNumberPickerHelper_android_selectionDivider)) {
                selectionDividerResId = a.getResourceId(R.styleable.SkinNumberPickerHelper_android_selectionDivider, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinNumberPickerHelper_android_virtualButtonPressedDrawable)) {
                virtualButtonPressedDrawableResId = a.getResourceId(R.styleable.SkinNumberPickerHelper_android_virtualButtonPressedDrawable, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }*/
    }

    /**
     * 设置selectionDivider
     *
     * @param view     视图
     * @param drawable 需要赋值的值
     */
    private void setSelectionDivider(NumberPicker view, Drawable drawable) {
        try {
            String name = "mSelectionDivider";
            Field fVirtualButtonPressedDrawable = NumberPicker.class.getDeclaredField(name);
            fVirtualButtonPressedDrawable.setAccessible(true);
            fVirtualButtonPressedDrawable.set(view, drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用selectionDivider
     */
    private void applySupportSelectionDivider() {
        if (selectionDividerResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(selectionDividerResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(selectionDividerResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(selectionDividerResId);
        }
        if (drawable == null) return;
        setSelectionDivider(view, drawable);
    }

    /**
     * 设置solidColor,反射该属性会有警告
     *
     * @param view  视图
     * @param color 需要赋值的值
     */
    private void setSolidColor(NumberPicker view, int color) {
        try {
            String name = "mSolidColor";
            Field fVirtualButtonPressedDrawable = NumberPicker.class.getDeclaredField(name);
            fVirtualButtonPressedDrawable.setAccessible(true);
            fVirtualButtonPressedDrawable.set(view, color);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用solidColor
     */
    private void applySupportSolidColor() {
        if (solidColorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(solidColorResId);
        if (isColor(typeName)) {
            int color = getColor(solidColorResId);
            if (color == 0) return;
            setSolidColor(view, color);
        }
    }

    /**
     * 设置virtualButtonPressedDrawable,反射该属性会有警告
     *
     * @param view     视图
     * @param drawable 需要赋值的值
     */
    private void setVirtualButtonPressedDrawable(NumberPicker view, Drawable drawable) {
        try {
            String name = "mVirtualButtonPressedDrawable";
            Field fVirtualButtonPressedDrawable = NumberPicker.class.getDeclaredField(name);
            fVirtualButtonPressedDrawable.setAccessible(true);
            fVirtualButtonPressedDrawable.set(view, drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用virtualButtonPressedDrawable
     */
    private void applySupportVirtualButtonPressedDrawable() {
        if (virtualButtonPressedDrawableResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(virtualButtonPressedDrawableResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(virtualButtonPressedDrawableResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(virtualButtonPressedDrawableResId);
        }
        if (drawable == null) return;
        setVirtualButtonPressedDrawable(view, drawable);
    }

    @Override
    public void updateSkin() {
        applySupportSolidColor();
        applySupportSelectionDivider();
        applySupportVirtualButtonPressedDrawable();
    }
}