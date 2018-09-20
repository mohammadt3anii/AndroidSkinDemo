package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.SearchView;

import com.codearms.maoqiqi.skin.helper.SkinSearchViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinSearchView继承SearchView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/17 13:45
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
        super(context, attrs);
        int defStyleAttr = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            defStyleAttr = android.R.attr.searchViewStyle;
        }
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