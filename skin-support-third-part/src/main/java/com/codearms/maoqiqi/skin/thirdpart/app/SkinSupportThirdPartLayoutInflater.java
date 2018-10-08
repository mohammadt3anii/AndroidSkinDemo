package com.codearms.maoqiqi.skin.thirdpart.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.thirdpart.widget.SkinCircleImageView;

/**
 * 实现自定义SkinLayoutInflater接口来创建视图
 * 使用自定义SkinView替换系统对应View,而不是通过反射创建对应的视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 14:47
 */
public class SkinSupportThirdPartLayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (name.equals("de.hdodenhof.circleimageview.CircleImageView")) {
            return new SkinCircleImageView(context, attrs);
        }
        return null;
    }
}