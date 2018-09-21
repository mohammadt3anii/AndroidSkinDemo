package com.codearms.maoqiqi.skin.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinSpinnerHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinAppCompatSpinner继承AppCompatSpinner,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 11:10
 */
public class SkinAppCompatSpinner extends AppCompatSpinner implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * Spinner更新皮肤帮助类
     */
    private SkinSpinnerHelper skinSpinnerHelper;

    public SkinAppCompatSpinner(Context context) {
        this(context, null);
    }

    public SkinAppCompatSpinner(Context context, int mode) {
        this(context, null, android.support.v7.appcompat.R.attr.spinnerStyle, mode);
    }

    public SkinAppCompatSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.spinnerStyle);
    }

    public SkinAppCompatSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public SkinAppCompatSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        this(context, attrs, defStyleAttr, mode, null);
    }

    public SkinAppCompatSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinSpinnerHelper = new SkinSpinnerHelper(this);
        skinSpinnerHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setPopupBackgroundResource(int resId) {
        super.setPopupBackgroundResource(resId);
        if (skinSpinnerHelper != null) {
            skinSpinnerHelper.setSupportPopupBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinSpinnerHelper != null) {
            skinSpinnerHelper.updateSkin();
        }
    }
}