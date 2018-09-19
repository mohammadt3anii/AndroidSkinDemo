package com.codearms.maoqiqi.skin.v7.widget;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinCompoundButtonHelper;
import com.codearms.maoqiqi.skin.helper.SkinTextViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.v7.helper.SkinSwitchCompatHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinSwitchCompat继承SwitchCompat,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/19 14:20
 */
public class SkinSwitchCompat extends SwitchCompat implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * TextView更新皮肤帮助类
     */
    private SkinTextViewHelper skinTextViewHelper;

    /**
     * CompoundButton更新皮肤帮助类
     */
    private SkinCompoundButtonHelper skinCompoundButtonHelper;

    /**
     * SwitchCompat更新皮肤帮助类
     */
    private SkinSwitchCompatHelper skinSwitchCompatHelper;

    public SkinSwitchCompat(Context context) {
        this(context, null);
    }

    public SkinSwitchCompat(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.switchStyle);
    }

    public SkinSwitchCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinTextViewHelper = new SkinTextViewHelper(this);
        skinTextViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinCompoundButtonHelper = new SkinCompoundButtonHelper(this);
        skinCompoundButtonHelper.loadFromAttribute(attrs, defStyleAttr);
        skinSwitchCompatHelper = new SkinSwitchCompatHelper(this);
        skinSwitchCompatHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setTextAppearance(int resId) {
        super.setTextAppearance(resId);
        if (skinTextViewHelper != null) {
            skinTextViewHelper.setSupportTextAppearance(resId);
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (skinTextViewHelper != null) {
            skinTextViewHelper.setSupportCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        }
    }

    @Override
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        if (skinTextViewHelper != null) {
            skinTextViewHelper.setSupportCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        }
    }

    @Override
    public void setButtonDrawable(int resId) {
        super.setButtonDrawable(resId);
        if (skinCompoundButtonHelper != null) {
            skinCompoundButtonHelper.setSupportButtonDrawable(resId);
        }
    }

    @Override
    public void setSwitchTextAppearance(Context context, int resId) {
        super.setSwitchTextAppearance(context, resId);
        if (skinSwitchCompatHelper != null) {
            skinSwitchCompatHelper.setSupportSwitchTextAppearance(resId);
        }
    }

    @Override
    public void setThumbResource(int resId) {
        super.setThumbResource(resId);
        if (skinSwitchCompatHelper != null) {
            skinSwitchCompatHelper.setSupportThumbResource(resId);
        }
    }

    @Override
    public void setTrackResource(int resId) {
        super.setTrackResource(resId);
        if (skinSwitchCompatHelper != null) {
            skinSwitchCompatHelper.setSupportTrackResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinTextViewHelper != null) {
            skinTextViewHelper.updateSkin();
        }
        if (skinCompoundButtonHelper != null) {
            skinCompoundButtonHelper.updateSkin();
        }
        if (skinSwitchCompatHelper != null) {
            skinSwitchCompatHelper.updateSkin();
        }
    }
}