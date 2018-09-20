package com.codearms.maoqiqi.skin.v7.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinProgressBarHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinAppCompatRatingBar继承AppCompatRatingBar,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/20 22:33
 */
public class SkinAppCompatRatingBar extends AppCompatRatingBar implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * ProgressBar更新皮肤帮助类
     */
    private SkinProgressBarHelper skinProgressBarHelper;

    public SkinAppCompatRatingBar(Context context) {
        this(context, null);
    }

    public SkinAppCompatRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.ratingBarStyle);
    }

    public SkinAppCompatRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinProgressBarHelper = new SkinProgressBarHelper(this);
        skinProgressBarHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinProgressBarHelper != null) {
            skinProgressBarHelper.updateSkin();
        }
    }
}