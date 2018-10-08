package com.codearms.maoqiqi.skin.thirdpart.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.codearms.maoqiqi.skin.helper.SkinImageViewHelper;
import com.codearms.maoqiqi.skin.helper.SkinViewHelper;
import com.codearms.maoqiqi.skin.thirdpart.helper.SkinCircleImageViewHelper;
import com.codearms.maoqiqi.skin.widget.Skinable;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 定义SkinCircleImageView继承CircleImageView,实现Skinable接口,实现更新皮肤功能
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/10/08 14:45
 */
public class SkinCircleImageView extends CircleImageView implements Skinable {

    /**
     * View更新皮肤帮助类
     */
    private SkinViewHelper skinViewHelper;

    /**
     * ImageView更新皮肤帮助类
     */
    private SkinImageViewHelper skinImageViewHelper;

    /**
     * CircleImageView更新皮肤帮助类
     */
    private SkinCircleImageViewHelper skinCircleImageViewHelper;

    public SkinCircleImageView(Context context) {
        super(context);
        init(null, 0);
    }

    public SkinCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public SkinCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        skinViewHelper = new SkinViewHelper(this);
        skinViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinImageViewHelper = new SkinImageViewHelper(this);
        skinImageViewHelper.loadFromAttribute(attrs, defStyleAttr);
        skinCircleImageViewHelper = new SkinCircleImageViewHelper(this);
        skinCircleImageViewHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (skinViewHelper != null) {
            skinViewHelper.setSupportBackgroundResource(resId);
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (skinImageViewHelper != null) {
            skinImageViewHelper.setSupportImageResource(resId);
        }
    }

    @Override
    public void setCircleBackgroundColorResource(int circleBackgroundRes) {
        super.setCircleBackgroundColorResource(circleBackgroundRes);
        if (skinCircleImageViewHelper != null) {
            skinCircleImageViewHelper.setSupportCircleBackgroundColorResource(circleBackgroundRes);
        }
    }

    @Override
    public void updateSkin() {
        if (skinViewHelper != null) {
            skinViewHelper.updateSkin();
        }
        if (skinImageViewHelper != null) {
            skinImageViewHelper.updateSkin();
        }
    }
}