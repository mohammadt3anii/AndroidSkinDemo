package com.codearms.maoqiqi.skin.helper;

import android.util.AttributeSet;
import android.view.View;

/**
 * 视图更新皮肤抽象帮助类,继承SkinHelper的时候传入视图类型(specific view)
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/4 20:13
 */
public abstract class SkinHelper<T extends View> {

    /**
     * 无效的资源
     */
    protected static final int INVALID_RESOURCES = 0;

    /**
     * 当前View
     */
    protected T view;

    SkinHelper(T view) {
        this.view = view;
    }

    /**
     * 抽象方法,解析属性,初始化资源
     *
     * @param attrs        属性集合
     * @param defStyleAttr 默认属性样式
     */
    public abstract void loadFromAttribute(AttributeSet attrs, int defStyleAttr);

    /**
     * 抽象方法,对外提供更新皮肤的方法
     */
    public abstract void updateSkin();
}