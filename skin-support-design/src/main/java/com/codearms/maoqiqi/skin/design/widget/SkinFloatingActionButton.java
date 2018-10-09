package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinFloatingActionButtonHelper;
import com.codearms.maoqiqi.skin.helper.SkinImageViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinFloatingActionButton继承FloatingActionButton,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 10:55
 */
public class SkinFloatingActionButton extends FloatingActionButton implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * ImageView更新皮肤帮助类
     */
    private SkinImageViewHelper skinImageViewHelper;

    /**
     * FloatingActionButton更新皮肤帮助类
     */
    private SkinFloatingActionButtonHelper skinFloatingActionButtonHelper;

    public SkinFloatingActionButton(Context context) {
        this(context, null);
    }

    public SkinFloatingActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinImageViewHelper = new SkinImageViewHelper(this);
        skinImageViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinFloatingActionButtonHelper = new SkinFloatingActionButtonHelper(this);
        skinFloatingActionButtonHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (skinImageViewHelper != null) {
            skinImageViewHelper.setSupportImageResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinImageViewHelper != null) {
            skinImageViewHelper.updateSkin();
        }
        if (skinFloatingActionButtonHelper != null) {
            skinFloatingActionButtonHelper.updateSkin();
        }
    }
}