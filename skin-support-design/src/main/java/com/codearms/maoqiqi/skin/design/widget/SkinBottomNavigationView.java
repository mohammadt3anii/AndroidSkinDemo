package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.helper.SkinBottomNavigationViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinBottomNavigationView继承BottomNavigationView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 11:11
 */
public class SkinBottomNavigationView extends BottomNavigationView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * BottomNavigationView更新皮肤帮助类
     */
    private SkinBottomNavigationViewHelper skinBottomNavigationViewHelper;

    public SkinBottomNavigationView(Context context) {
        this(context, null);
    }

    public SkinBottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinBottomNavigationViewHelper = new SkinBottomNavigationViewHelper(this);
        skinBottomNavigationViewHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinBottomNavigationViewHelper != null) {
            skinBottomNavigationViewHelper.setSupportItemBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinBottomNavigationViewHelper != null) {
            skinBottomNavigationViewHelper.updateSkin();
        }
    }
}