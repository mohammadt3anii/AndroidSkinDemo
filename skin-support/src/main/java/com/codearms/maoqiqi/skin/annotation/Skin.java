package com.codearms.maoqiqi.skin.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 如果没有设置所有Activity都支持换肤,然而当前页面需要换肤功能,那么可以添加该注解
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 22:30
 */
@Retention(RUNTIME)
@Target({TYPE})
public @interface Skin {
}