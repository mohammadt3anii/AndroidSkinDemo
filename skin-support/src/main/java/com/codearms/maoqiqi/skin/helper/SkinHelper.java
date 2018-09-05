package com.codearms.maoqiqi.skin.helper;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.manager.SkinResourcesManager;

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
     * 资源类型名称color
     */
    protected static final String RES_TYPE_NAME_COLOR = "color";

    /**
     * 资源类型名称drawable
     */
    protected static final String RES_TYPE_NAME_DRAWABLE = "drawable";

    /**
     * 资源类型名称mipmap
     */
    protected static final String RES_TYPE_NAME_MIPMAP = "mipmap";

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

    /**
     * 得到资源id的typeName
     *
     * @param resId resource id
     * @return typeName
     */
    protected String getTypeName(int resId) {
        return SkinResourcesManager.getInstance().getTypeName(resId);
    }

    /**
     * 资源类型是否是color
     *
     * @param resTypeName typeName
     * @return true or false
     */
    protected boolean isColor(String resTypeName) {
        return RES_TYPE_NAME_COLOR.equals(resTypeName);
    }

    /**
     * 资源类型是否是Drawable
     *
     * @param resTypeName typeName
     * @return true or false
     */
    protected boolean isDrawable(String resTypeName) {
        return RES_TYPE_NAME_DRAWABLE.equals(resTypeName) || RES_TYPE_NAME_MIPMAP.equals(resTypeName);
    }

    /**
     * 获取目标资源Id
     *
     * @param resId resource id
     * @return resource id
     */
    protected int getTargetResId(int resId) {
        return SkinResourcesManager.getInstance().getTargetResId(resId);
    }

    /**
     * 根据resId加载对应的color
     *
     * @param resId resource id
     * @return color
     */
    protected int getColor(int resId) {
        return SkinResourcesManager.getInstance().getColor(resId);
    }

    /**
     * 根据resId加载对应的Drawable
     *
     * @param resId resource id
     * @return Drawable
     */
    protected Drawable getDrawable(int resId) {
        return SkinResourcesManager.getInstance().getDrawable(resId);
    }

    /**
     * 根据resId加载对应的ColorStateList
     *
     * @param resId resource id
     * @return ColorStateList
     */
    protected ColorStateList getColorStateList(int resId) {
        return SkinResourcesManager.getInstance().getColorStateList(resId);
    }
}