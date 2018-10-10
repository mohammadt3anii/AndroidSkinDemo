package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinTextInputLayoutHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinTextInputLayout继承TextInputLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/10 11:15
 */
public class SkinTextInputLayout extends TextInputLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * TextInputLayout更新皮肤帮助类
     */
    private SkinTextInputLayoutHelper skinTextInputLayoutHelper;

    public SkinTextInputLayout(Context context) {
        this(context, null);
    }

    public SkinTextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinTextInputLayoutHelper = new SkinTextInputLayoutHelper(this);
        skinTextInputLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setHintTextAppearance(int resId) {
        super.setHintTextAppearance(resId);
        if (skinTextInputLayoutHelper != null) {
            skinTextInputLayoutHelper.setSupportHintTextAppearance(resId);
        }
    }

    @Override
    public void setErrorTextAppearance(int resId) {
        super.setErrorTextAppearance(resId);
        if (skinTextInputLayoutHelper != null) {
            skinTextInputLayoutHelper.setSupportErrorTextAppearance(resId);
        }
    }

    @Override
    public void setPasswordVisibilityToggleDrawable(int resId) {
        super.setPasswordVisibilityToggleDrawable(resId);
        if (skinTextInputLayoutHelper != null) {
            skinTextInputLayoutHelper.setSupportPasswordVisibilityToggleDrawable(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinTextInputLayoutHelper != null) {
            skinTextInputLayoutHelper.updateSkin();
        }
    }
}