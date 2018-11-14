package com.codearms.maoqiqi.skin.design.widget;

import android.content.Context;
import android.support.design.card.MaterialCardView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.widget.Skinable;

public class SkinMaterialCardView extends MaterialCardView implements Skinable {

    public SkinMaterialCardView(Context context) {
        super(context);
    }

    public SkinMaterialCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SkinMaterialCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void updateSkin() {

    }
}