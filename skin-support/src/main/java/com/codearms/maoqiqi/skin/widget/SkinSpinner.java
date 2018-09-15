package com.codearms.maoqiqi.skin.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Spinner;

import com.codearms.maoqiqi.skin.helper.SkinSpinnerHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinSpinner继承Spinner,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/15 17:04
 */
@SuppressLint("AppCompatCustomView")
public class SkinSpinner extends Spinner implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * Spinner更新皮肤帮助类
     */
    private SkinSpinnerHelper skinSpinnerHelper;

    public SkinSpinner(Context context) {
        this(context, null);
    }

    public SkinSpinner(Context context, int mode) {
        this(context, null, android.R.attr.spinnerStyle, mode);
    }

    public SkinSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.spinnerStyle);
    }

    public SkinSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public SkinSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        this(context, attrs, defStyleAttr, 0, mode);
    }

    public SkinSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode) {
        this(context, attrs, defStyleAttr, defStyleRes, mode, null);
    }

    public SkinSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, defStyleRes, mode, popupTheme);
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