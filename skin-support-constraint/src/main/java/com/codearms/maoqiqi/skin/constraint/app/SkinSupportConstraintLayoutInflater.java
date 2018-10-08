package com.codearms.maoqiqi.skin.constraint.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.constraint.widget.SkinConstraintLayout;

/**
 * 实现自定义SkinLayoutInflater接口来创建ConstraintLayout视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 11:35
 */
public class SkinSupportConstraintLayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (name.equals("android.support.constraint.ConstraintLayout")) {
            return new SkinConstraintLayout(context, attrs);
        }
        return null;
    }
}