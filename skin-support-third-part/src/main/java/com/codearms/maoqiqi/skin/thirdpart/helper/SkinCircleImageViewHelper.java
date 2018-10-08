package com.codearms.maoqiqi.skin.thirdpart.helper;

import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinHelper;
import com.codearms.maoqiqi.skin.thirdpart.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * CircleImageView更新皮肤帮助类,CircleImageView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 14:40
 */
public class SkinCircleImageViewHelper extends SkinHelper<CircleImageView> {

    private int circleBackgroundColorResId = INVALID_RESOURCES;
    private int borderColorResId = INVALID_RESOURCES;

    public SkinCircleImageViewHelper(CircleImageView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinCircleImageViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinCircleImageViewHelper_civ_circle_background_color)) {
                circleBackgroundColorResId = a.getResourceId(R.styleable.SkinCircleImageViewHelper_civ_circle_background_color, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCircleImageViewHelper_civ_border_color)) {
                borderColorResId = a.getResourceId(R.styleable.SkinCircleImageViewHelper_civ_border_color, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置背景颜色
     *
     * @param resId resource id
     */
    public void setSupportCircleBackgroundColorResource(int resId) {
        circleBackgroundColorResId = resId;
        applySupportCircleBackgroundColor();
    }

    /**
     * 应用背景颜色
     */
    private void applySupportCircleBackgroundColor() {
        if (circleBackgroundColorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(circleBackgroundColorResId);
        if (isColor(typeName)) {
            int color = getColor(circleBackgroundColorResId);
            if (color == 0) return;
            view.setCircleBackgroundColor(color);
        }
    }

    /**
     * 应用边框颜色
     */
    private void applySupportBorderColor() {
        if (borderColorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(borderColorResId);
        if (isColor(typeName)) {
            int color = getColor(borderColorResId);
            if (color == 0) return;
            view.setBorderColor(color);
        }
    }

    @Override
    public void updateSkin() {
        applySupportCircleBackgroundColor();
        applySupportBorderColor();
    }
}