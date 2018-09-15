package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListView;

import com.codearms.maoqiqi.skin.R;

/**
 * ListView更新皮肤帮助类,ListView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/15 23:12
 */
public class SkinListViewHelper extends SkinHelper<ListView> {

    private int dividerResId = INVALID_RESOURCES;

    public SkinListViewHelper(ListView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinListViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinListViewHelper_android_divider)) {
                dividerResId = a.getResourceId(R.styleable.SkinListViewHelper_android_divider, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 应用Divider
     */
    private void applySupportDivider() {
        if (dividerResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(dividerResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(dividerResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(dividerResId);
        }
        if (drawable == null) return;
        view.setDivider(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportDivider();
    }
}