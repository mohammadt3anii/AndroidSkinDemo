package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

/**
 * CollapsingToolbarLayout更新皮肤帮助类,CollapsingToolbarLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/09 10:20
 */
public class SkinCollapsingToolbarLayoutHelper extends SkinHelper<CollapsingToolbarLayout> {

    private boolean isApplyExpandedTitleTextAppearance = true;
    private boolean isApplyCollapsedTitleTextAppearance = true;

    private int expandedTitleTextAppearanceResId = INVALID_RESOURCES;
    private int collapsedTitleTextAppearanceResId = INVALID_RESOURCES;
    private int contentScrimResId = INVALID_RESOURCES;
    private int statusBarScrimResId = INVALID_RESOURCES;

    public SkinCollapsingToolbarLayoutHelper(CollapsingToolbarLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinCollapsingToolbarLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinCollapsingToolbarLayoutHelper_expandedTitleTextAppearance)) {
                expandedTitleTextAppearanceResId = a.getResourceId(R.styleable.SkinCollapsingToolbarLayoutHelper_expandedTitleTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCollapsingToolbarLayoutHelper_collapsedTitleTextAppearance)) {
                collapsedTitleTextAppearanceResId = a.getResourceId(R.styleable.SkinCollapsingToolbarLayoutHelper_collapsedTitleTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCollapsingToolbarLayoutHelper_contentScrim)) {
                contentScrimResId = a.getResourceId(R.styleable.SkinCollapsingToolbarLayoutHelper_contentScrim, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinCollapsingToolbarLayoutHelper_statusBarScrim)) {
                statusBarScrimResId = a.getResourceId(R.styleable.SkinCollapsingToolbarLayoutHelper_statusBarScrim, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置展开文本样式
     *
     * @param resId resource id
     */
    public void setSupportExpandedTitleTextAppearance(int resId) {
        if (isApplyExpandedTitleTextAppearance) {
            expandedTitleTextAppearanceResId = resId;
            applySupportExpandedTitleTextAppearance();
        } else {
            isApplyExpandedTitleTextAppearance = true;
        }
    }

    /**
     * 设置折叠文本样式
     *
     * @param resId resource id
     */
    public void setSupportCollapsedTitleTextAppearance(int resId) {
        if (isApplyCollapsedTitleTextAppearance) {
            collapsedTitleTextAppearanceResId = resId;
            applySupportCollapsedTitleTextAppearance();
        } else {
            isApplyCollapsedTitleTextAppearance = true;
        }
    }

    /**
     * 设置内容背景资源
     *
     * @param resId resource id
     */
    public void setSupportContentScrimResource(int resId) {
        contentScrimResId = resId;
        applySupportContentScrim();
    }

    /**
     * 设置StatusBar背景资源
     *
     * @param resId resource id
     */
    public void setSupportStatusBarScrimResource(int resId) {
        statusBarScrimResId = resId;
        applySupportStatusBarScrim();
    }

    /**
     * 应用展开文本样式
     */
    private void applySupportExpandedTitleTextAppearance() {
        if (expandedTitleTextAppearanceResId == INVALID_RESOURCES) return;
        int id = getTargetResId(expandedTitleTextAppearanceResId);
        if (id == 0) id = expandedTitleTextAppearanceResId;
        isApplyExpandedTitleTextAppearance = false;
        view.setExpandedTitleTextAppearance(id);
    }

    /**
     * 应用折叠文本样式
     */
    private void applySupportCollapsedTitleTextAppearance() {
        if (collapsedTitleTextAppearanceResId == INVALID_RESOURCES) return;
        int id = getTargetResId(collapsedTitleTextAppearanceResId);
        if (id == 0) id = collapsedTitleTextAppearanceResId;
        isApplyCollapsedTitleTextAppearance = false;
        view.setCollapsedTitleTextAppearance(id);
    }

    /**
     * 设置内容背景资源
     */
    private void applySupportContentScrim() {
        if (contentScrimResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(contentScrimResId);
        if (isColor(typeName)) {
            int color = getColor(contentScrimResId);
            if (color == 0) return;
            view.setContentScrimColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(contentScrimResId);
            if (drawable == null) return;
            view.setContentScrim(drawable);
        }
    }

    /**
     * 设置StatusBar背景资源
     */
    private void applySupportStatusBarScrim() {
        if (statusBarScrimResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(statusBarScrimResId);
        if (isColor(typeName)) {
            int color = getColor(statusBarScrimResId);
            if (color == 0) return;
            view.setStatusBarScrimColor(color);
        } else if (isDrawable(typeName)) {
            Drawable drawable = getDrawable(statusBarScrimResId);
            if (drawable == null) return;
            view.setStatusBarScrim(drawable);
        }
    }

    @Override
    public void updateSkin() {
        applySupportExpandedTitleTextAppearance();
        applySupportCollapsedTitleTextAppearance();
        applySupportContentScrim();
        applySupportStatusBarScrim();
    }
}