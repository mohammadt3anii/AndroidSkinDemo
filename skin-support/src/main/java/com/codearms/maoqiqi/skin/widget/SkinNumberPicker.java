package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.NumberPicker;

import com.codearms.maoqiqi.skin.helper.SkinNumberPickerHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinNumberPicker继承NumberPicker,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/12 21:48
 */
public class SkinNumberPicker extends NumberPicker implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * NumberPicker更新皮肤帮助类
     */
    private SkinNumberPickerHelper skinNumberPickerHelper;

    public SkinNumberPicker(Context context) {
        this(context, null);
    }

    public SkinNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        int defStyleAttr = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            defStyleAttr = android.R.attr.numberPickerStyle;
        }
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinNumberPickerHelper = new SkinNumberPickerHelper(this);
        skinNumberPickerHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinNumberPickerHelper != null) {
            skinNumberPickerHelper.updateSkin();
        }
    }
}