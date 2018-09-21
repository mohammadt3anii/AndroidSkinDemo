package com.codearms.maoqiqi.skin.v7.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.v7.widget.SkinRecyclerView;

/**
 * 实现自定义SkinLayoutInflater接口来创建RecyclerView视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 11:35
 */
public class SkinSupportRecyclerLayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        if (name.equals("android.support.v7.widget.RecyclerView")) {
            return new SkinRecyclerView(context, attrs);
        }
        return null;
    }
}