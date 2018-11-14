package com.codearms.maoqiqi.skin.v7.helper;

import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * RecyclerView更新皮肤帮助类,RecyclerView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/27 23:52
 */
public class SkinRecyclerViewHelper extends SkinHelper<RecyclerView> {

    private int fastScrollVerticalThumbDrawableResId = INVALID_RESOURCES;
    private int fastScrollVerticalTrackDrawableResId = INVALID_RESOURCES;
    private int fastScrollHorizontalThumbDrawableResId = INVALID_RESOURCES;
    private int fastScrollHorizontalTrackDrawableResId = INVALID_RESOURCES;

    public SkinRecyclerViewHelper(RecyclerView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {

    }

    @Override
    public void updateSkin() {

    }
}