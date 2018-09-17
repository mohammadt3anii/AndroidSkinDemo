package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterViewFlipper;

import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinAdapterViewFlipper继承AdapterViewFlipper,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/17 10:52
 */
public class SkinAdapterViewFlipper extends AdapterViewFlipper implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    public SkinAdapterViewFlipper(Context context) {
        this(context, null);
    }

    public SkinAdapterViewFlipper(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinAdapterViewFlipper(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SkinAdapterViewFlipper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
    }
}