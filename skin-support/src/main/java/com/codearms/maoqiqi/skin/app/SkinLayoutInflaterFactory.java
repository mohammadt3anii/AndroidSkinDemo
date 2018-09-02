package com.codearms.maoqiqi.skin.app;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.codearms.maoqiqi.skin.listener.OnSkinChangeListener;

/**
 * 实现系统提供的LayoutInflater.Factory2接口,替换系统默认的来创建视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 22:35
 */
public class SkinLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /**
     * 私有化构造函数
     *
     * @param activity the activity
     */
    private SkinLayoutInflaterFactory(Activity activity) {
        super();
    }

    /**
     * 创建对象当前实例对象
     *
     * @param activity the activity
     * @return {@link SkinLayoutInflaterFactory}实例对象
     */
    public static SkinLayoutInflaterFactory create(Activity activity) {
        return new SkinLayoutInflaterFactory(activity);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return null;
    }

    /**
     * 更新状态栏
     */
    public void updateStatusBarColor() {

    }

    /**
     * 更新皮肤
     */
    public void updateSkin() {

    }

    /**
     * 如果接口实现了OnSkinChangeListener,调用{@link OnSkinChangeListener#onSkinChanged()}回调方法
     */
    public void skinChangedCallBack() {

    }

    /**
     * 清除数据
     */
    public void clearData() {

    }
}