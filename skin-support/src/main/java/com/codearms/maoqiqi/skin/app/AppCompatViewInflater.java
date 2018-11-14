package com.codearms.maoqiqi.skin.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.codearms.maoqiqi.skin.manager.SkinManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 创建视图
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/3 20:02
 */
public final class AppCompatViewInflater {

    // 创建view包名
    private static final String[] classPrefixList = {"android.widget.", "android.view.", "android.webkit."};

    private static final Class<?>[] constructorSignature = new Class[]{Context.class, AttributeSet.class};
    private final Object[] constructorArgs = new Object[2];
    private static final Map<String, Constructor<? extends View>> constructorMap = new ArrayMap<>();
    private static final int[] onClickAttrs = new int[]{android.R.attr.onClick};

    final View createView(View parent, final String name, Context context, AttributeSet attrs) {
        // 优先使用自定义LayoutInflater创建视图
        View view = createViewByLayoutInflater(parent, name, context, attrs);

        if (view == null) {
            view = createViewFromTag(context, name, attrs);
        }

        if (view != null) {
            // If we have created a view, check its android:onClick
            checkOnClickListener(view, attrs);
        }

        return view;
    }

    /**
     * 根据自定义LayoutInflater创建视图
     */
    private View createViewByLayoutInflater(View parent, final String name, Context context, AttributeSet attrs) {
        View view;
        List<SkinLayoutInflater> skinLayoutInflaters = SkinManager.getInstance().getSkinLayoutInflaters();
        if (!skinLayoutInflaters.isEmpty()) {
            for (SkinLayoutInflater layoutInflater : skinLayoutInflaters) {
                view = layoutInflater.createView(parent, name, context, attrs);
                if (view != null) return view;
            }
        }
        return null;
    }

    /**
     * 根据标签名创建视图
     */
    private View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }

        try {
            constructorArgs[0] = context;
            constructorArgs[1] = attrs;

            if (-1 == name.indexOf('.')) {
                // 系统内部控件,通过补全包名,反射创建View
                for (String classPrefix : classPrefixList) {
                    final View view = createViewByPrefix(context, name, classPrefix);
                    if (view != null) return view;
                }
                return null;
            } else {
                // 全类名通过反射创建View
                return createViewByPrefix(context, name, null);
            }
        } catch (Exception e) {
            return null;
        } finally {
            constructorArgs[0] = null;
            constructorArgs[1] = null;
        }
    }

    private View createViewByPrefix(Context context, String name, String prefix) {
        Constructor<? extends View> constructor = constructorMap.get(name);

        try {
            if (constructor == null) {
                // 没有在缓存中找到,试图创建
                String className = prefix != null ? (prefix + name) : name;
                Class<? extends View> clazz = context.getClassLoader().loadClass(className).asSubclass(View.class);

                constructor = clazz.getConstructor(constructorSignature);
                constructorMap.put(name, constructor);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(constructorArgs);
        } catch (Exception e) {
            // We do not want to catch these, lets return null and let the actual LayoutInflater try
            return null;
        }
    }

    /**
     * android:onClick doesn't handle views with a ContextWrapper context. This method
     * backports new framework functionality to traverse the Context wrappers to find a
     * suitable target.
     */
    private void checkOnClickListener(View view, AttributeSet attrs) {
        final Context context = view.getContext();

        if (!(context instanceof ContextWrapper) ||
                (Build.VERSION.SDK_INT >= 15 && !ViewCompat.hasOnClickListeners(view))) {
            // Skip our compat functionality if: the Context isn't a ContextWrapper, or
            // the view doesn't have an OnClickListener (we can only rely on this on API 15+ so
            // always use our compat code on older devices)
            return;
        }

        final TypedArray a = context.obtainStyledAttributes(attrs, onClickAttrs);
        final String handlerName = a.getString(0);
        if (handlerName != null) {
            view.setOnClickListener(new DeclaredOnClickListener(view, handlerName));
        }
        a.recycle();
    }

    /**
     * An implementation of OnClickListener that attempts to lazily load a
     * named click handling method from a parent or ancestor context.
     */
    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;

        private Method mResolvedMethod;
        private Context mResolvedContext;

        DeclaredOnClickListener(@NonNull View hostView, @NonNull String methodName) {
            mHostView = hostView;
            mMethodName = methodName;
        }

        @Override
        public void onClick(@NonNull View v) {
            if (mResolvedMethod == null) {
                resolveMethod(mHostView.getContext(), mMethodName);
            }

            try {
                mResolvedMethod.invoke(mResolvedContext, v);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(
                        "Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(
                        "Could not execute method for android:onClick", e);
            }
        }

        private void resolveMethod(@Nullable Context context, @NonNull String name) {
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        final Method method = context.getClass().getMethod(mMethodName, View.class);
                        if (method != null) {
                            mResolvedMethod = method;
                            mResolvedContext = context;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                    // Failed to find method, keep searching up the hierarchy.
                }

                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    // Can't search up the hierarchy, null out and fail.
                    context = null;
                }
            }

            final int id = mHostView.getId();
            final String idText = id == View.NO_ID ? "" : " with id '"
                    + mHostView.getContext().getResources().getResourceEntryName(id) + "'";
            throw new IllegalStateException("Could not find method " + mMethodName
                    + "(View) in a parent or ancestor Context for android:onClick "
                    + "attribute defined on view " + mHostView.getClass() + idText);
        }
    }
}