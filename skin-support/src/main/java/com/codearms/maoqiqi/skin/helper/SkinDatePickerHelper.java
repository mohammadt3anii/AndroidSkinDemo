package com.codearms.maoqiqi.skin.helper;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.codearms.maoqiqi.skin.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * DatePicker更新皮肤帮助类,DatePicker及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/12 21:58
 */
public class SkinDatePickerHelper extends SkinHelper<DatePicker> {

    private int headerBackgroundResId = INVALID_RESOURCES;
    private int calendarTextColorResId = INVALID_RESOURCES;

    public SkinDatePickerHelper(DatePicker view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinDatePickerHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinDatePickerHelper_android_headerBackground)) {
                headerBackgroundResId = a.getResourceId(R.styleable.SkinDatePickerHelper_android_headerBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinDatePickerHelper_android_calendarTextColor)) {
                calendarTextColorResId = a.getResourceId(R.styleable.SkinDatePickerHelper_android_calendarTextColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 得到设置的模式
     *
     * @param view 视图
     * @return 模式
     */
    private int getMode(DatePicker view) {
        try {
            String name = "getMode";
            Method method = DatePicker.class.getMethod(name);
            return (int) method.invoke(view);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 设置头部背景
     *
     * @param view     视图
     * @param drawable 背景资源
     */
    private void setHeaderBackground(DatePicker view, Drawable drawable) {
        try {
            String name = "mDelegate";
            Field fDelegate = DatePicker.class.getDeclaredField(name);
            fDelegate.setAccessible(true);
            Object delegate = fDelegate.get(view);

            if (getMode(view) == 2) {
                Field fContainer = delegate.getClass().getDeclaredField("mContainer");
                fContainer.setAccessible(true);
                ViewGroup container = (ViewGroup) fContainer.get(delegate);

                Resources resources = view.getContext().getResources();
                int id = resources.getIdentifier("date_picker_header", "id", "android");
                final ViewGroup header = container.findViewById(id);
                ViewCompat.setBackground(header, drawable);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用头部背景
     */
    private void applySupportHeaderBackground() {
        if (isNotNeedSkin(headerBackgroundResId)) return;
        String typeName = getTypeName(headerBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(headerBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(headerBackgroundResId);
        }
        if (drawable == null) return;
        Log.e("info",view.getClass().getName()+"headerBackgroundResId:"+headerBackgroundResId);
        setHeaderBackground(view, drawable);
    }

    /**
     * 设置头部文本颜色
     *
     * @param view           视图
     * @param colorStateList 文本颜色
     */
    private void setHeaderTextColor(DatePicker view, ColorStateList colorStateList) {
        try {
            String name = "mDelegate";
            Field fDelegate = DatePicker.class.getDeclaredField(name);
            fDelegate.setAccessible(true);
            Object delegate = fDelegate.get(view);

            if (getMode(view) == 2) {
                Field fHeaderYear = delegate.getClass().getDeclaredField("mHeaderYear");
                fHeaderYear.setAccessible(true);
                TextView headerYear = (TextView) fHeaderYear.get(delegate);

                Field fHeaderMonthDay = delegate.getClass().getDeclaredField("mHeaderMonthDay");
                fHeaderMonthDay.setAccessible(true);
                TextView headerMonthDay = (TextView) fHeaderMonthDay.get(delegate);

                headerYear.setTextColor(colorStateList);
                headerMonthDay.setTextColor(colorStateList);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSkin() {
        applySupportHeaderBackground();
    }
}