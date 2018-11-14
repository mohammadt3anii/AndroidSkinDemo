package com.codearms.maoqiqi.skin.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatViewInflater;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatAutoCompleteTextView;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatButton;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatCheckBox;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatCheckedTextView;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatEditText;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatImageButton;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatImageView;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatMultiAutoCompleteTextView;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatRadioButton;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatRatingBar;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatSeekBar;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatSpinner;
import com.codearms.maoqiqi.skin.v7.widget.SkinAppCompatTextView;
import com.codearms.maoqiqi.skin.v7.widget.SkinLinearLayoutCompat;
import com.codearms.maoqiqi.skin.v7.widget.SkinSearchView;
import com.codearms.maoqiqi.skin.v7.widget.SkinSwitchCompat;
import com.codearms.maoqiqi.skin.v7.widget.SkinToolbar;

/**
 * 实现自定义SkinLayoutInflater接口来创建视图
 * 使用自定义SkinView替换系统对应View,而不是通过反射创建对应的视图
 * 使用自定义SkinAppCompatView替换对应的View,与系统保持一致
 * {@link AppCompatViewInflater#createView(View, String, Context, AttributeSet, boolean, boolean, boolean, boolean)}
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/21 11:00
 */
public class SkinSupportV7LayoutInflater implements SkinLayoutInflater {

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        View view = null;
        if (!name.contains(".")) {
            switch (name) {
                case "TextView":
                    view = new SkinAppCompatTextView(context, attrs);
                    break;
                case "EditText":
                    view = new SkinAppCompatEditText(context, attrs);
                    break;
                case "AutoCompleteTextView":
                    view = new SkinAppCompatAutoCompleteTextView(context, attrs);
                    break;
                case "MultiAutoCompleteTextView":
                    view = new SkinAppCompatMultiAutoCompleteTextView(context, attrs);
                    break;
                case "Button":
                    view = new SkinAppCompatButton(context, attrs);
                    break;
                case "RadioButton":
                    view = new SkinAppCompatRadioButton(context, attrs);
                    break;
                case "CheckBox":
                    view = new SkinAppCompatCheckBox(context, attrs);
                    break;
                case "CheckedTextView":
                    view = new SkinAppCompatCheckedTextView(context, attrs);
                    break;
                case "RatingBar":
                    view = new SkinAppCompatRatingBar(context, attrs);
                    break;
                case "SeekBar":
                    view = new SkinAppCompatSeekBar(context, attrs);
                    break;
                case "ImageView":
                    view = new SkinAppCompatImageView(context, attrs);
                    break;
                case "ImageButton":
                    view = new SkinAppCompatImageButton(context, attrs);
                    break;
                case "Spinner":
                    view = new SkinAppCompatSpinner(context, attrs);
                    break;
            }
            return view;
        } else if (name.startsWith("android.support.v7.widget.")) {
            switch (name) {
                case "android.support.v7.widget.AppCompatTextView":
                    view = new SkinAppCompatTextView(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatEditText":
                    view = new SkinAppCompatEditText(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatAutoCompleteTextView":
                    view = new SkinAppCompatAutoCompleteTextView(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatMultiAutoCompleteTextView":
                    view = new SkinAppCompatMultiAutoCompleteTextView(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatButton":
                    view = new SkinAppCompatButton(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatRadioButton":
                    view = new SkinAppCompatRadioButton(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatCheckBox":
                    view = new SkinAppCompatCheckBox(context, attrs);
                    break;
                case "android.support.v7.widget.SwitchCompat":
                    view = new SkinSwitchCompat(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatCheckedTextView":
                    view = new SkinAppCompatCheckedTextView(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatImageView":
                    view = new SkinAppCompatImageView(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatImageButton":
                    view = new SkinAppCompatImageButton(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatRatingBar":
                    view = new SkinAppCompatRatingBar(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatSeekBar":
                    view = new SkinAppCompatSeekBar(context, attrs);
                    break;
                case "android.support.v7.widget.AppCompatSpinner":
                    view = new SkinAppCompatSpinner(context, attrs);
                    break;
                case "android.support.v7.widget.Toolbar":
                    view = new SkinToolbar(context, attrs);
                    break;
                case "android.support.v7.widget.SearchView":
                    view = new SkinSearchView(context, attrs);
                    break;
                case "android.support.v7.widget.LinearLayoutCompat":
                    view = new SkinLinearLayoutCompat(context, attrs);
                    break;
            }
        }
        return view;
    }
}