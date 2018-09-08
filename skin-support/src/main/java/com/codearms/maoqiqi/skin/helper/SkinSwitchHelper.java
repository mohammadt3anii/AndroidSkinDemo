package com.codearms.maoqiqi.skin.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Switch;

import com.codearms.maoqiqi.skin.R;

/**
 * Switch更新皮肤帮助类,Switch及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/8 18:00
 */
public class SkinSwitchHelper extends SkinHelper<Switch> {

    private int switchTextAppearanceResId = INVALID_RESOURCES;
    private int thumbResId = INVALID_RESOURCES;
    private int thumbTintResId = INVALID_RESOURCES;
    private int trackResId = INVALID_RESOURCES;
    private int trackTintResId = INVALID_RESOURCES;

    public SkinSwitchHelper(Switch view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinSwitchHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinSwitchHelper_android_switchTextAppearance)) {
                switchTextAppearanceResId = a.getResourceId(R.styleable.SkinSwitchHelper_android_switchTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinSwitchHelper_android_thumb)) {
                thumbResId = a.getResourceId(R.styleable.SkinSwitchHelper_android_thumb, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinSwitchHelper_android_thumbTint)) {
                thumbTintResId = a.getResourceId(R.styleable.SkinSwitchHelper_android_thumbTint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinSwitchHelper_android_track)) {
                trackResId = a.getResourceId(R.styleable.SkinSwitchHelper_android_track, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinSwitchHelper_android_trackTint)) {
                trackTintResId = a.getResourceId(R.styleable.SkinSwitchHelper_android_trackTint, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
    }

    /**
     * 设置Switch文本样式文本样式
     *
     * @param resId resource id
     */
    public void setSupportSwitchTextAppearance(int resId) {
        switchTextAppearanceResId = resId;
        applySupportSwitchTextAppearance();
    }

    /**
     * 设置Thumb资源
     *
     * @param resId resource id
     */
    public void setSupportThumbResource(int resId) {
        thumbResId = resId;
        applySupportThumb();
    }

    /**
     * 设置Track资源
     *
     * @param resId resource id
     */
    public void setSupportTrackResource(int resId) {
        trackResId = resId;
        applySupportTrack();
    }

    /**
     *
     */
    private void applySupportSwitchTextAppearance() {

    }

    /**
     * 应用Thumb
     */
    private void applySupportThumb() {
        if (thumbResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(thumbResId);
        Drawable drawable = null;
        if (isDrawable(typeName)) {
            drawable = getDrawable(thumbResId);
        }
        if (drawable == null) return;
        view.setThumbDrawable(drawable);
    }

    /**
     * 应用Track
     */
    private void applySupportTrack() {
        if (trackResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(trackResId);
        Drawable drawable = null;
        if (isDrawable(typeName)) {
            drawable = getDrawable(trackResId);
        }
        if (drawable == null) return;
        view.setTrackDrawable(drawable);
    }

    /**
     * 应用Thumb着色
     */
    private void applySupportThumbTint() {
        if (thumbTintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(thumbTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(thumbTintResId);
            if (colorStateList == null) return;
            view.setThumbTintList(colorStateList);
        }
    }

    /**
     * 应用Track着色
     */
    private void applySupportTrackTint() {
        if (trackTintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(trackTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(trackTintResId);
            if (colorStateList == null) return;
            view.setTrackTintList(colorStateList);
        }
    }

    @Override
    public void updateSkin() {
        applySupportSwitchTextAppearance();
        applySupportThumb();
        applySupportTrack();
        applySupportThumbTint();
        applySupportTrackTint();
    }
}