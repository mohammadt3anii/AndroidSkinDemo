package com.codearms.maoqiqi.skin.v7.helper;

import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.codearms.maoqiqi.skin.helper.SkinHelper;

import java.lang.reflect.Field;

/**
 * SearchView更新皮肤帮助类,SearchView及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 10:35
 */
public class SkinSearchViewHelper extends SkinHelper<SearchView> {

    private int queryBackgroundResId = INVALID_RESOURCES;
    private int submitBackgroundResId = INVALID_RESOURCES;
    private int searchIconResId = INVALID_RESOURCES;
    private int searchHintIconResId = INVALID_RESOURCES;
    private int closeIconResId = INVALID_RESOURCES;
    private int goIconResId = INVALID_RESOURCES;
    private int voiceIconResId = INVALID_RESOURCES;
    private int commitIconResId = INVALID_RESOURCES;

    public SkinSearchViewHelper(SearchView view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_queryBackground)) {
                queryBackgroundResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_queryBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_submitBackground)) {
                submitBackgroundResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_submitBackground, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_searchIcon)) {
                searchIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_searchIcon, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_searchHintIcon)) {
                searchHintIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_searchHintIcon, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_closeIcon)) {
                closeIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_closeIcon, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_goIcon)) {
                goIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_goIcon, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_voiceIcon)) {
                voiceIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_voiceIcon, INVALID_RESOURCES);
            }
            if (a.hasValue(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_commitIcon)) {
                commitIconResId = a.getResourceId(com.codearms.maoqiqi.skin.R.styleable.SkinSearchViewHelper_commitIcon, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 设置Query背景
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setQueryBackground(SearchView searchView, Drawable drawable) {
        try {
            String name = "mSearchPlate";
            Field fSearchPlate = SearchView.class.getDeclaredField(name);
            View view = (View) fSearchPlate.get(searchView);
            ViewCompat.setBackground(view, drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用Query背景
     */
    private void applySupportQueryBackground() {
        if (isNotNeedSkin(queryBackgroundResId)) return;
        String typeName = getTypeName(queryBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(queryBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(queryBackgroundResId);
        }
        if (drawable == null) return;
        setQueryBackground(view, drawable);
    }

    /**
     * 设置Submit背景
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setSubmitBackground(SearchView searchView, Drawable drawable) {
        try {
            String name = "mSubmitArea";
            Field fSubmitArea = SearchView.class.getDeclaredField(name);
            View view = (View) fSubmitArea.get(searchView);
            ViewCompat.setBackground(view, drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用Submit背景
     */
    private void applySupportSubmitBackground() {
        if (isNotNeedSkin(submitBackgroundResId)) return;
        String typeName = getTypeName(submitBackgroundResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(submitBackgroundResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(submitBackgroundResId);
        }
        if (drawable == null) return;
        setSubmitBackground(view, drawable);
    }

    /**
     * 设置搜索Icon
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setSearchIcon(SearchView searchView, Drawable drawable) {
        try {
            String name = "mSearchButton";
            Field fSearchButton = SearchView.class.getDeclaredField(name);
            ImageView searchButton = (ImageView) fSearchButton.get(searchView);
            searchButton.setImageDrawable(drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用搜索Icon
     */
    private void applySupportSearchIcon() {
        if (isNotNeedSkin(searchIconResId)) return;
        String typeName = getTypeName(searchIconResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(searchIconResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(searchIconResId);
        }
        if (drawable == null) return;
        setSearchIcon(view, drawable);
    }

    /**
     * 设置搜索提示Icon
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setSearchHintIcon(SearchView searchView, Drawable drawable) {
        try {
            String name = "mSearchHintIcon";
            Field fSearchHintIcon = SearchView.class.getDeclaredField(name);
            fSearchHintIcon.set(searchView, drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用搜索提示Icon
     */
    private void applySupportSearchHintIcon() {
        if (isNotNeedSkin(searchHintIconResId)) return;
        String typeName = getTypeName(searchHintIconResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(searchHintIconResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(searchHintIconResId);
        }
        if (drawable == null) return;
        setSearchHintIcon(view, drawable);
    }

    /**
     * 设置CloseIcon
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setCloseIcon(SearchView searchView, Drawable drawable) {
        try {
            String name = "mCloseButton";
            Field fCloseButton = SearchView.class.getDeclaredField(name);
            ImageView closeButton = (ImageView) fCloseButton.get(searchView);
            closeButton.setImageDrawable(drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用CloseIcon
     */
    private void applySupportCloseIcon() {
        if (isNotNeedSkin(closeIconResId)) return;
        String typeName = getTypeName(closeIconResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(closeIconResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(closeIconResId);
        }
        if (drawable == null) return;
        setCloseIcon(view, drawable);
    }

    /**
     * 设置GoIcon
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setGoIcon(SearchView searchView, Drawable drawable) {
        try {
            String name = "mGoButton";
            Field fGoButton = SearchView.class.getDeclaredField(name);
            ImageView goButton = (ImageView) fGoButton.get(searchView);
            goButton.setImageDrawable(drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用GoIcon
     */
    private void applySupportGoIcon() {
        if (isNotNeedSkin(goIconResId)) return;
        String typeName = getTypeName(goIconResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(goIconResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(goIconResId);
        }
        if (drawable == null) return;
        setGoIcon(view, drawable);
    }

    /**
     * 设置VoiceIcon
     *
     * @param searchView 视图
     * @param drawable   drawable资源
     */
    private void setVoiceIcon(SearchView searchView, Drawable drawable) {
        try {
            String name = "mVoiceButton";
            Field fVoiceButton = SearchView.class.getDeclaredField(name);
            ImageView voiceButton = (ImageView) fVoiceButton.get(searchView);
            voiceButton.setImageDrawable(drawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用VoiceIcon
     */
    private void applySupportVoiceIcon() {
        if (isNotNeedSkin(voiceIconResId)) return;
        String typeName = getTypeName(voiceIconResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(voiceIconResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(voiceIconResId);
        }
        if (drawable == null) return;
        setVoiceIcon(view, drawable);
    }

    /**
     * 设置CommitIcon
     *
     * @param searchView 视图
     * @param resId      resource id
     */
    private void setCommitIcon(SearchView searchView, int resId) {

        try {
            String name = "mSuggestionCommitIconResId";
            Field fSuggestionCommitIconResId = SearchView.class.getDeclaredField(name);
            fSuggestionCommitIconResId.set(searchView, resId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用CommitIcon
     */
    private void applySupportCommitIcon() {
        if (isNotNeedSkin(commitIconResId)) return;
        int id = getTargetResId(commitIconResId);
        if (id == 0) id = commitIconResId;
        setCommitIcon(view, id);
    }

    @Override
    public void updateSkin() {
        applySupportQueryBackground();
        applySupportSubmitBackground();
        applySupportSearchIcon();
        applySupportSearchHintIcon();
        applySupportCloseIcon();
        applySupportGoIcon();
        applySupportVoiceIcon();
        applySupportCommitIcon();
    }
}