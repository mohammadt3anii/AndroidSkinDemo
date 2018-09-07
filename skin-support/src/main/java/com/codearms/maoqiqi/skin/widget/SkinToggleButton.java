package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

import com.codearms.maoqiqi.skin.helper.SkinCompoundButtonHelper;
import com.codearms.maoqiqi.skin.helper.SkinTextViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinToggleButton继承ToggleButton,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/7 20:22
 */
public class SkinToggleButton extends ToggleButton implements Skinable {

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

    public SkinToggleButton(Context context) {
        this(context, null);
    }

    public SkinToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyleToggle);
    }

    public SkinToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SkinToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinTextViewHelper = new SkinTextViewHelper(this);
        skinTextViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinCompoundButtonHelper = new SkinCompoundButtonHelper(this);
        skinCompoundButtonHelper.loadFromAttribute(attrs, defStyleAttr);
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
    }
}