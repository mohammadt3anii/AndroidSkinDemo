package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.codearms.maoqiqi.skin.helper.SkinAbsListViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinListViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinListView继承ListView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/15 23:17
 */
public class SkinListView extends ListView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * AbsListView更新皮肤帮助类
     */
    private SkinAbsListViewHelper skinAbsListViewHelper;

    /**
     * ListView更新皮肤帮助类
     */
    private SkinListViewHelper skinListViewHelper;

    public SkinListView(Context context) {
        this(context, null);
    }

    public SkinListView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.listViewStyle);
    }

    public SkinListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinAbsListViewHelper = new SkinAbsListViewHelper(this);
        skinAbsListViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinListViewHelper = new SkinListViewHelper(this);
        skinListViewHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setSelector(int resId) {
        super.setSelector(resId);
        if (skinAbsListViewHelper != null) {
            skinAbsListViewHelper.setSupportSelector(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinAbsListViewHelper != null) {
            skinAbsListViewHelper.updateSkin();
        }
        if (skinListViewHelper != null) {
            skinListViewHelper.updateSkin();
        }
    }
}