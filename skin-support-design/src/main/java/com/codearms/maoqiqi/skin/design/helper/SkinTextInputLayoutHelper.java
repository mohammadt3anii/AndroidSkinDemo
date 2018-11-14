package com.codearms.maoqiqi.skin.design.helper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import com.codearms.maoqiqi.skin.design.R;
import com.codearms.maoqiqi.skin.helper.SkinHelper;

import java.lang.reflect.Field;

/**
 * TextInputLayout更新皮肤帮助类,TextInputLayout及子类都可以使用该帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/10 10:10
 */
public class SkinTextInputLayoutHelper extends SkinHelper<TextInputLayout> {

    private boolean isApplyHintTextAppearance = true;
    private boolean isApplyErrorTextAppearance = true;

    private int textColorHintResId = INVALID_RESOURCES;
    private int hintTextAppearanceResId = INVALID_RESOURCES;
    private int errorTextAppearanceResId = INVALID_RESOURCES;
    private int counterTextAppearanceResId = INVALID_RESOURCES;
    private int counterOverflowTextAppearanceResId = INVALID_RESOURCES;
    private int passwordToggleDrawableResId = INVALID_RESOURCES;
    private int passwordToggleTintResId = INVALID_RESOURCES;

    public SkinTextInputLayoutHelper(TextInputLayout view) {
        super(view);
    }

    @Override
    public void loadFromAttribute(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.SkinTextInputLayoutHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_android_textColorHint)) {
                textColorHintResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_android_textColorHint, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_hintTextAppearance)) {
                hintTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_hintTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_errorTextAppearance)) {
                errorTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_errorTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_counterTextAppearance)) {
                counterTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_counterTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_counterOverflowTextAppearance)) {
                counterOverflowTextAppearanceResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_counterOverflowTextAppearance, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_passwordToggleDrawable)) {
                passwordToggleDrawableResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_passwordToggleDrawable, INVALID_RESOURCES);
            }
            if (a.hasValue(R.styleable.SkinTextInputLayoutHelper_passwordToggleTint)) {
                passwordToggleTintResId = a.getResourceId(R.styleable.SkinTextInputLayoutHelper_passwordToggleTint, INVALID_RESOURCES);
            }
        } finally {
            a.recycle();
        }
        updateSkin();
    }

    /**
     * 设置字体样式
     *
     * @param resId resource id
     */
    public void setSupportHintTextAppearance(int resId) {
        if (isApplyHintTextAppearance) {
            hintTextAppearanceResId = resId;
            applySupportHintTextAppearance();
        } else {
            isApplyHintTextAppearance = true;
        }
    }

    /**
     * 设置字体样式
     *
     * @param resId resource id
     */
    public void setSupportErrorTextAppearance(int resId) {
        if (isApplyErrorTextAppearance) {
            errorTextAppearanceResId = resId;
            applySupportErrorTextAppearance();
        } else {
            isApplyErrorTextAppearance = true;
        }
    }

    /**
     * 设置密码开关资源
     *
     * @param resId resource id
     */
    public void setSupportPasswordVisibilityToggleDrawable(int resId) {
        passwordToggleDrawableResId = resId;
        applySupportPasswordVisibilityToggleDrawable();
    }

    /**
     * 设置提示颜色
     *
     * @param textInputLayout 视图
     * @param colorStateList  颜色
     */
    private void setTextColorHint(TextInputLayout textInputLayout, ColorStateList colorStateList) {
        try {
            String name = "mDefaultTextColor";
            Field fDefaultTextColor = TextInputLayout.class.getDeclaredField(name);
            fDefaultTextColor.setAccessible(true);
            fDefaultTextColor.set(textInputLayout, colorStateList);

            name = "mFocusedTextColor";
            Field fFocusedTextColor = TextInputLayout.class.getDeclaredField(name);
            fFocusedTextColor.setAccessible(true);
            fFocusedTextColor.set(textInputLayout, colorStateList);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用提示颜色
     */
    private void applySupportTextColorHint() {
        if (isNotNeedSkin(textColorHintResId)) return;
        String typeName = getTypeName(textColorHintResId);
        if (isColor(typeName) || isDrawable(typeName)) {
            ColorStateList colorStateList = getColorStateList(textColorHintResId);
            if (colorStateList == null) return;
            setTextColorHint(view, colorStateList);
        }
    }

    // TODO: 18/10/28 对比一下
    private void applySupportTextColorHint2() {
        if (textColorHintResId == INVALID_RESOURCES) return;
        String typeName = getTypeName(textColorHintResId);
        if (isColor(typeName)) {
            int color = getColor(textColorHintResId);
            if (color == 0) return;
            if (view.getEditText() != null)
                view.getEditText().setHintTextColor(color);
        } else if (isDrawable(typeName)) {
            ColorStateList colorStateList = getColorStateList(textColorHintResId);
            if (colorStateList == null) return;
            if (view.getEditText() != null)
                view.getEditText().setHintTextColor(colorStateList);
        }
        if (view.getEditText() != null)
            view.getEditText().setTextColor(Color.BLACK);
    }

    /**
     * 应用字体样式
     */
    private void applySupportHintTextAppearance() {
        if (isNotNeedSkin(hintTextAppearanceResId)) return;
        int id = getTargetResId(hintTextAppearanceResId);
        if (id == 0) id = hintTextAppearanceResId;
        isApplyHintTextAppearance = false;
        view.setHintTextAppearance(id);
    }

    /**
     * 应用字体样式
     */
    private void applySupportErrorTextAppearance() {
        if (!view.isErrorEnabled()) return;
        if (isNotNeedSkin(errorTextAppearanceResId)) return;
        int id = getTargetResId(errorTextAppearanceResId);
        if (id == 0) id = errorTextAppearanceResId;
        isApplyErrorTextAppearance = false;
        view.setErrorTextAppearance(id);
    }

    /**
     * 设置Counter字体样式
     *
     * @param textInputLayout 视图
     * @param resId           资源
     */
    private void setCounterTextAppearance(TextInputLayout textInputLayout, int resId) {
        try {
            String name = "mCounterTextAppearance";
            Field fCounterTextAppearance = TextInputLayout.class.getDeclaredField(name);
            fCounterTextAppearance.setAccessible(true);
            fCounterTextAppearance.set(textInputLayout, resId);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用Counter字体样式
     */
    private void applySupportCounterTextAppearance() {
        if (isNotNeedSkin(counterTextAppearanceResId)) return;
        int id = getTargetResId(counterTextAppearanceResId);
        if (id == 0) id = counterTextAppearanceResId;
        setCounterTextAppearance(view, id);
    }

    // TODO: 18/10/28 对比一下
    private TextView getCounterView() {
        try {
            Field counterView = TextInputLayout.class.getDeclaredField("mCounterView");
            counterView.setAccessible(true);
            return (TextView) counterView.get(view);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void applySupportCounterTextAppearance2() {
        if (counterTextAppearanceResId == INVALID_RESOURCES) return;
        TextView counterView = getCounterView();
        if (counterView == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            counterView.setTextAppearance(getTargetResId(counterTextAppearanceResId));
        }
    }

    /**
     * 设置CounterOverflow字体样式
     *
     * @param textInputLayout 视图
     * @param resId           资源
     */
    private void setCounterOverflowTextAppearance(TextInputLayout textInputLayout, int resId) {
        try {
            String name = "mCounterOverflowTextAppearance";
            Field fCounterOverflowTextAppearance = TextInputLayout.class.getDeclaredField(name);
            fCounterOverflowTextAppearance.setAccessible(true);
            fCounterOverflowTextAppearance.set(textInputLayout, resId);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用CounterOverflow字体样式
     */
    private void applySupportCounterOverflowTextAppearance() {
        if (isNotNeedSkin(counterOverflowTextAppearanceResId)) return;
        int id = getTargetResId(counterOverflowTextAppearanceResId);
        if (id == 0) id = counterOverflowTextAppearanceResId;
        setCounterOverflowTextAppearance(view, id);
    }

    /**
     * 如果Counter显示,更新Counter
     */
    private void applySupportCounterTextAppearanceIfNeed() {
        if (view.isCounterEnabled()) {
            applySupportCounterTextAppearance();
            applySupportCounterOverflowTextAppearance();
            // 用于更新Counter
            view.setCounterEnabled(false);
            view.setCounterEnabled(true);
        }
    }

    /**
     * 应用密码开关资源
     */
    private void applySupportPasswordVisibilityToggleDrawable() {
        if (!view.isPasswordVisibilityToggleEnabled()) return;
        if (isNotNeedSkin(passwordToggleDrawableResId)) return;
        String typeName = getTypeName(passwordToggleDrawableResId);
        Drawable drawable = null;
        if (isColor(typeName)) {
            int color = getColor(passwordToggleDrawableResId);
            if (color == 0) return;
            drawable = new ColorDrawable(color);
        } else if (isDrawable(typeName)) {
            drawable = getDrawable(passwordToggleDrawableResId);
        }
        if (drawable == null) return;
        view.setPasswordVisibilityToggleDrawable(drawable);
    }

    /**
     * 应用密码开关着色
     */
    private void applySupportPasswordVisibilityToggleTintList() {
        if (!view.isPasswordVisibilityToggleEnabled()) return;
        if (isNotNeedSkin(passwordToggleTintResId)) return;
        String typeName = getTypeName(passwordToggleTintResId);
        if (isColor(typeName)) {
            ColorStateList colorStateList = getColorStateList(passwordToggleTintResId);
            if (colorStateList == null) return;
            view.setPasswordVisibilityToggleTintList(colorStateList);
        }
    }

    @Override
    public void updateSkin() {
        applySupportTextColorHint();
        applySupportHintTextAppearance();
        applySupportErrorTextAppearance();
        applySupportCounterTextAppearanceIfNeed();
        applySupportPasswordVisibilityToggleDrawable();
        applySupportPasswordVisibilityToggleTintList();
    }
}