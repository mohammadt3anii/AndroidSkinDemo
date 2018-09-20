package com.codearms.maoqiqi.skin.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;

import com.codearms.maoqiqi.skin.helper.SkinTimePickerHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;

/**
 * 定义SkinSkinTimePicker继承SkinTimePicker,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/12 22:09
 */
public class SkinTimePicker extends TimePicker implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * TimePicker更新皮肤帮助类
     */
    private SkinTimePickerHelper skinTimePickerHelper;

    public SkinTimePicker(Context context) {
        this(context, null);
    }

    public SkinTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        int defStyleAttr = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            defStyleAttr = android.R.attr.timePickerStyle;
        }
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinTimePickerHelper = new SkinTimePickerHelper(this);
        skinTimePickerHelper.loadFromAttribute(attrs, defStyleAttr);
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
        if (skinTimePickerHelper != null) {
            skinTimePickerHelper.updateSkin();
        }
    }
}