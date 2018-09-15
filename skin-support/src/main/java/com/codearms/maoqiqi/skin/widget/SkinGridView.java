package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.codearms.maoqiqi.skin.helper.SkinAbsListViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinGridView继承GridView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/15 23:24
 */
public class SkinGridView extends GridView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * AbsListView更新皮肤帮助类
     */
    private SkinAbsListViewHelper skinAbsListViewHelper;

    public SkinGridView(Context context) {
        this(context, null);
    }

    public SkinGridView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.gridViewStyle);
    }

    public SkinGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SkinGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinAbsListViewHelper = new SkinAbsListViewHelper(this);
        skinAbsListViewHelper.loadFromAttribute(attrs, defStyleAttr);
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
    }
}