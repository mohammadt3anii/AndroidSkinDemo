package com.codearms.maoqiqi.skin.listener;

/**
 * 更换皮肤之后的回调接口
 * 如果没有设置所有Activity都支持换肤,然而当前页面需要换肤功能,那么实现该接口
 * Skin注解和实现OnSkinChangeListener接口的区别:
 * 都可以让该Activity实现换肤功能,而在OnSkinChangeListener接口的回调方法中可以做其他事情
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 22:31
 */
public interface OnSkinChangeListener {

    void onSkinChanged();
}