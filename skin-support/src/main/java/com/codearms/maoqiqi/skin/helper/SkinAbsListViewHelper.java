package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AbsListView;

import com.codearms.maoqiqi.skin.R;

/**
 * AbsListView更新皮肤帮助类,AbsListView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/15 23:05
 */
public class SkinAbsListViewHelper extends SkinHelper<AbsListView> {

    private int listSelectorResId = INVALID_RESOURCES;

    public SkinAbsListViewHelper(AbsListView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinAbsListViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinAbsListViewHelper_android_listSelector)) {
                listSelectorResId = a.getResourceId(R.styleable.SkinAbsListViewHelper_android_listSelector, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置Selector
     *
     * @param resId resource id
     */
    public void setSupportSelector(int resId) {
        listSelectorResId = resId;
        applySupportSelector();
    }

    /**
     * 应用Selector
     */
    private void applySupportSelector() {
        if (listSelectorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(listSelectorResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(listSelectorResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(listSelectorResId);
        }
        if (drawable == null) return;
        view.setSelector(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportSelector();
    }
}