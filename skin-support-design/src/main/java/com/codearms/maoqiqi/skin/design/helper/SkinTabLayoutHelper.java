package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * TabLayout更新皮肤帮助类,TabLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 14:32
 */
public class SkinTabLayoutHelper extends SkinHelper<TabLayout> {

    private int tabBackgroundResId = INVALID_RESOURCES;
    private int tabIndicatorColorResId = INVALID_RESOURCES;
    private int tabTextAppearanceResId = INVALID_RESOURCES;
    private int tabTextColorResId = INVALID_RESOURCES;
    private int tabSelectedTextColorResId = INVALID_RESOURCES;

    public SkinTabLayoutHelper(TabLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinTabLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinTabLayoutHelper_tabBackground)) {
                tabBackgroundResId = a.getResourceId(R.styleable.SkinTabLayoutHelper_tabBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTabLayoutHelper_tabIndicatorColor)) {
                tabIndicatorColorResId = a.getResourceId(R.styleable.SkinTabLayoutHelper_tabIndicatorColor, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTabLayoutHelper_tabTextAppearance)) {
                tabTextAppearanceResId = a.getResourceId(R.styleable.SkinTabLayoutHelper_tabTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTabLayoutHelper_tabTextColor)) {
                tabTextColorResId = a.getResourceId(R.styleable.SkinTabLayoutHelper_tabTextColor, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTabLayoutHelper_tabSelectedTextColor)) {
                tabSelectedTextColorResId = a.getResourceId(R.styleable.SkinTabLayoutHelper_tabSelectedTextColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 应用背景资源
     */
    private void applySupportTabBackground() {
        if (isNotNeedSkin(tabBackgroundResId)) return;
        String typeName = getTypeName(tabBackgroundResId);
        if (isColor(typeName)) {
            int color = getColor(tabBackgroundResId);
            if (color == 0) return;
            view.setBackgroundColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(tabBackgroundResId);
            if (drawable == null) return;
            ViewCompat.setBackground(view, drawable);
        }
    }

    /**
     * 应用Indicator颜色
     */
    private void applySupportTabIndicatorColor() {
        if (isNotNeedSkin(tabIndicatorColorResId)) return;
        String typeName = getTypeName(tabIndicatorColorResId);
        if (isColor(typeName)) {
            int color = getColor(tabIndicatorColorResId);
            if (color == 0) return;
            view.setSelectedTabIndicatorColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(tabIndicatorColorResId);
            if (drawable == null) return;
            view.setSelectedTabIndicator(drawable);
        }
    }

    private void obtainTabTextAppearance() {
        if (tabTextAppearanceResId == INVALID_RESOURCES) return;
        TypedArray a = view.getContext().obtainStyledAttributes(tabTextAppearanceResId, R.styleable.SkinTextAppearance);
        try {
            if (a.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
                tabTextColorResId = a.getResourceId(R.styleable.SkinTextAppearance_android_textColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 应用文本颜色
     */
    private void applySupportTabTextColors() {
        ColorStateList colorStateList = null;
        // TODO: 18/10/28 重新思考逻辑
        if (!isNotNeedSkin(tabTextAppearanceResId)) {
            TypedArray a = view.getContext().obtainStyledAttributes(tabTextAppearanceResId, R.styleable.SkinTextAppearance);
            try {
                if (a.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
                    colorStateList = a.getColorStateList(R.styleable.SkinTextAppearance_android_textColor);
                }
            } finally {
                a.recycle();
            }
        }

        if (isNotNeedSkin(tabTextColorResId)) {
            String typeName = getTypeName(tabTextColorResId);
            if (isColor(typeName)) {
                colorStateList = getColorStateList(tabTextColorResId);
            } else if (isDrawable(typeName)) {
                colorStateList = getColorStateList(tabTextColorResId);
            }
        }

        if (isNotNeedSkin(tabSelectedTextColorResId)) {
            String typeName = getTypeName(tabSelectedTextColorResId);
            if (isColor(typeName)) {
                int tabSelectedTextColor = getColor(tabSelectedTextColorResId);

                final int[][] states = new int[2][];
                final int[] colors = new int[2];

                states[0] = new int[]{android.R.attr.state_selected};
                colors[0] = tabSelectedTextColor;

                states[1] = new int[]{};
                colors[1] = colorStateList == null ? 0 : colorStateList.getDefaultColor();

                colorStateList = new ColorStateList(states, colors);
            }
        }

        view.setTabTextColors(colorStateList);
    }

    @Override
    public void updateSkin() {
        applySupportTabBackground();
        applySupportTabIndicatorColor();
        applySupportTabTextColors();
    }
}