package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinNavigationViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinNavigationView继承NavigationView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 11:32
 */
public class SkinNavigationView extends NavigationView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * NavigationView更新皮肤帮助类
     */
    private SkinNavigationViewHelper skinNavigationViewHelper;

    public SkinNavigationView(Context context) {
        this(context, null);
    }

    public SkinNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinNavigationViewHelper = new SkinNavigationViewHelper(this);
        skinNavigationViewHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setItemBackgroundResource(int resId) {
        super.setItemBackgroundResource(resId);
        if (skinNavigationViewHelper != null) {
            skinNavigationViewHelper.setSupportItemBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinNavigationViewHelper != null) {
            skinNavigationViewHelper.updateSkin();
        }
    }
}