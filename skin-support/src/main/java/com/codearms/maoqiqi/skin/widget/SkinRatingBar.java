package com.codearms.maoqiqi.skin.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RatingBar;

import com.codearms.maoqiqi.skin.helper.SkinProgressBarHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinRatingBar继承RatingBar,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/9 19:32
 */
@SuppressLint("AppCompatCustomView")
public class SkinRatingBar extends RatingBar implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * ProgressBar更新皮肤帮助类
     */
    private SkinProgressBarHelper skinProgressBarHelper;

    public SkinRatingBar(Context context) {
        this(context, null);
    }

    public SkinRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.ratingBarStyle);
    }

    public SkinRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SkinRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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