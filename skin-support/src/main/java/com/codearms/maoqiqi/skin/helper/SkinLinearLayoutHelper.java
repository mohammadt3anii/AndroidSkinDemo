package com.codearms.maoqiqi.skin.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.codearms.maoqiqi.skin.R;

/**
 * LinearLayout更新皮肤帮助类,LinearLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/14 9:50
 */
public class SkinLinearLayoutHelper extends SkinHelper<LinearLayout> {

    private int dividerResId = INVALID_RESOURCES;

    public SkinLinearLayoutHelper(LinearLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinLinearLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinLinearLayoutHelper_android_divider)) {
                dividerResId = a.getResourceId(R.styleable.SkinLinearLayoutHelper_android_divider, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 应用divider
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
        view.setDividerDrawable(drawable);
    }

    @Override
    public void updateSkin() {
        applySupportDivider();
    }
}