package com.codearms.maoqiqi.skin.v7.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.cardview.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * CardView更新皮肤帮助类,CardView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 11:45
 */
public class SkinCardViewHelper extends SkinHelper<CardView> {

    private int cardBackgroundColorResId = INVALID_RESOURCES;

    public SkinCardViewHelper(CardView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinCardViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinCardViewHelper_cardBackgroundColor)) {
                cardBackgroundColorResId = a.getResourceId(R.styleable.SkinCardViewHelper_cardBackgroundColor, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    private void applySupportBackground() {
        if (cardBackgroundColorResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(cardBackgroundColorResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(cardBackgroundColorResId);
            if (colorStateList == null) return;
            view.setCardBackgroundColor(colorStateList);
        }
    }

    @Override
    public void updateSkin() {
        applySupportBackground();
    }
}