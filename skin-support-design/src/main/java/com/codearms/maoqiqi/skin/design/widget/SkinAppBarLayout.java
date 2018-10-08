package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinLinearLayoutHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinAppBarLayout继承AppBarLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 18:36
 */
public class SkinAppBarLayout extends AppBarLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * LinearLayout更新皮肤帮助类
     */
    private SkinLinearLayoutHelper skinLinearLayoutHelper;

    public SkinAppBarLayout(Context context) {
        this(context, null);
    }

    public SkinAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        int defStyleAttr = 0;
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinLinearLayoutHelper = new SkinLinearLayoutHelper(this);
        skinLinearLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinLinearLayoutHelper != null) {
            skinLinearLayoutHelper.updateSkin();
        }
    }
}