package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinTabLayoutHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinTabLayout继承TabLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 15:12
 */
public class SkinTabLayout extends TabLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * TabLayout更新皮肤帮助类
     */
    private SkinTabLayoutHelper skinTabLayoutHelper;

    public SkinTabLayout(Context context) {
        this(context, null);
    }

    public SkinTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinTabLayoutHelper = new SkinTabLayoutHelper(this);
        skinTabLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinTabLayoutHelper != null) {
            skinTabLayoutHelper.updateSkin();
        }
    }
}