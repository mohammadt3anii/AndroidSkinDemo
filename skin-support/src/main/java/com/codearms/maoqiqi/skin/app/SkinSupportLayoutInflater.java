package com.codearms.maoqiqi.skin.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.widget.SkinView;

/**
 * 实现自定义SkinLayoutInflater接口来创建视图
 * 使用自定义SkinView替换系统对应View,而不是通过反射创建对应的视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/5 20:45
 */
public class SkinSupportLayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (name.contains(".")) return null;
        View view = null;
        switch (name) {
            case "View":
                view = new SkinView(context, attrs);
                break;
        }
        return view;
    }
}