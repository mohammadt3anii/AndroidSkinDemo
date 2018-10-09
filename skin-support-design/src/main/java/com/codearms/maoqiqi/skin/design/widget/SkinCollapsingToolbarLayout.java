package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinCollapsingToolbarLayoutHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinCollapsingToolbarLayout继承CollapsingToolbarLayout,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 10:45
 */
public class SkinCollapsingToolbarLayout extends CollapsingToolbarLayout implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * CollapsingToolbarLayout更新皮肤帮助类
     */
    private SkinCollapsingToolbarLayoutHelper skinCollapsingToolbarLayoutHelper;

    public SkinCollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public SkinCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinCollapsingToolbarLayoutHelper = new SkinCollapsingToolbarLayoutHelper(this);
        skinCollapsingToolbarLayoutHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setExpandedTitleTextAppearance(int resId) {
        super.setExpandedTitleTextAppearance(resId);
        if (skinCollapsingToolbarLayoutHelper != null) {
            skinCollapsingToolbarLayoutHelper.setSupportExpandedTitleTextAppearance(resId);
        }
    }

    @Override
    public void setCollapsedTitleTextAppearance(int resId) {
        super.setCollapsedTitleTextAppearance(resId);
        if (skinCollapsingToolbarLayoutHelper != null) {
            skinCollapsingToolbarLayoutHelper.setSupportCollapsedTitleTextAppearance(resId);
        }
    }

    @Override
    public void setContentScrimResource(int resId) {
        super.setContentScrimResource(resId);
        if (skinCollapsingToolbarLayoutHelper != null) {
            skinCollapsingToolbarLayoutHelper.setSupportContentScrimResource(resId);
        }
    }

    @Override
    public void setStatusBarScrimResource(int resId) {
        super.setStatusBarScrimResource(resId);
        if (skinCollapsingToolbarLayoutHelper != null) {
            skinCollapsingToolbarLayoutHelper.setSupportStatusBarScrimResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinCollapsingToolbarLayoutHelper != null) {
            skinCollapsingToolbarLayoutHelper.updateSkin();
        }
    }
}