package com.codearms.maoqiqi.skin.v7.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinProgressBarHelper;
import com.codearms.maoqiqi.skin.helper.SkinSeekBarHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinAppCompatSeekBar继承AppCompatSeekBar,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/20 22:35
 */
public class SkinAppCompatSeekBar extends AppCompatSeekBar implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * ProgressBar更新皮肤帮助类
     */
    private SkinProgressBarHelper skinProgressBarHelper;

    /**
     * SeekBar更新皮肤帮助类
     */
    private SkinSeekBarHelper skinSeekBarHelper;

    public SkinAppCompatSeekBar(Context context) {
        this(context, null);
    }

    public SkinAppCompatSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.seekBarStyle);
    }

    public SkinAppCompatSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinProgressBarHelper = new SkinProgressBarHelper(this);
        skinProgressBarHelper.loadFromAttribute(attrs, defStyleAttr);
        skinSeekBarHelper = new SkinSeekBarHelper(this);
        skinSeekBarHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinSeekBarHelper != null) {
            skinSeekBarHelper.updateSkin();
        }
    }
}