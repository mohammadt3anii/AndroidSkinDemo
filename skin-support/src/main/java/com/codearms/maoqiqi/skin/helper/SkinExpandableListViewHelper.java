package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

import com.codearms.maoqiqi.skin.R;

/**
 * ExpandableListView更新皮肤帮助类,ExpandableListView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/16 22:00
 */
public class SkinExpandableListViewHelper extends SkinHelper<ExpandableListView> {

    private int groupIndicatorResId = INVALID_RESOURCES;
    private int childIndicatorResId = INVALID_RESOURCES;
    private int childDividerResId = INVALID_RESOURCES;

    public SkinExpandableListViewHelper(ExpandableListView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinExpandableListViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinExpandableListViewHelper_android_groupIndicator)) {
                groupIndicatorResId = a.getResourceId(R.styleable.SkinExpandableListViewHelper_android_groupIndicator, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinExpandableListViewHelper_android_childIndicator)) {
                childIndicatorResId = a.getResourceId(R.styleable.SkinExpandableListViewHelper_android_childIndicator, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinExpandableListViewHelper_android_childDivider)) {
                childDividerResId = a.getResourceId(R.styleable.SkinExpandableListViewHelper_android_childDivider, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 应用GroupIndicatorGroupIndicator
     */
    private void applySupportGroupIndicator() {
        if (isNotNeedSkin(groupIndicatorResId)) return;
        String typeName = getTypeName(groupIndicatorResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(groupIndicatorResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(groupIndicatorResId);
        }
        if (drawable == null) return;
        view.setGroupIndicator(drawable);
    }

    /**
     * 应用ChildIndicator
     */
    private void applySupportChildIndicator() {
        if (isNotNeedSkin(childIndicatorResId)) return;
        String typeName = getTypeName(childIndicatorResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(childIndicatorResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(childIndicatorResId);
        }
        if (drawable == null) return;
        view.setChildIndicator(drawable);
    }

    /**
     * 应用ChildDivider
     */
    private void applySupportChildDivider() {
        if (isNotNeedSkin(childDividerResId)) return;
        String typeName = getTypeName(childDividerResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(childDividerResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(childDividerResId);
        }
        if (drawable == null) return;
        view.setChildDivider(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportGroupIndicator();
        applySupportChildIndicator();
        applySupportChildDivider();
    }
}