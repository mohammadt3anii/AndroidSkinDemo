package com.codearms.maoqiqi.skin.v7.widget;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.v7.helper.SkinSearchViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

/**
 * 定义SkinSearchView继承SearchView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 10:45
 */
public class SkinSearchView extends SearchView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * SearchView更新皮肤帮助类
     */
    private SkinSearchViewHelper skinSearchViewHelper;

    public SkinSearchView(Context context) {
        this(context, null);
    }

    public SkinSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.searchViewStyle);
    }

    public SkinSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinSearchViewHelper = new SkinSearchViewHelper(this);
        skinSearchViewHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinSearchViewHelper != null) {
            skinSearchViewHelper.updateSkin();
        }
    }
}