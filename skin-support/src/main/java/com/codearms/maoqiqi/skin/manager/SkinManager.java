package com.codearms.maoqiqi.skin.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.codearms.maoqiqi.skin.app.SkinActivityLifecycleCallbacks;
import com.codearms.maoqiqi.skin.app.SkinLayoutInflater;
import com.codearms.maoqiqi.skin.loader.LoadPlugInSkinTask;
import com.codearms.maoqiqi.skin.observe.SkinObservable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * 皮肤管理类,设置换肤参数,加载皮肤
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 21:32
 */
public class SkinManager extends SkinObservable {

    /**
     * 日志标签
     */
    private static final String TAG = SkinManager.class.getSimpleName();

    /**
     * 缓存当前应用Context
     */
    private final WeakReference<Context> contextWR;

    /**
     * 所有Activity都支持换肤
     */
    private boolean skinAllActivityEnable = true;

    /**
     * 所有Activity的状态栏都支持换肤
     */
    private boolean skinAllStatusBarColorEnable = true;

    /**
     * 所有Activity的状态栏都支持换肤,设置Activity的状态栏支持换肤
     */
    private WeakHashMap<Activity, Boolean> skinStatusBarColorEnables = new WeakHashMap<>();

    /**
     * 所有Activity的状态栏都支持换肤,设置Activity的状态栏不支持换肤
     */
    private WeakHashMap<Activity, Boolean> skinStatusBarColorDisEnables = new WeakHashMap<>();

    /**
     * 保存所有实现{@link SkinLayoutInflater}接口的实例
     */
    private List<SkinLayoutInflater> skinLayoutInflaters = new ArrayList<>();

    /**
     * 当前实例对象
     */
    private static SkinManager instance;

    /**
     * 返回是否所有Activity都支持换肤
     *
     * @return true:支持;false:不支持
     */
    public boolean isSkinAllActivityEnable() {
        return skinAllActivityEnable;
    }

    /**
     * 设置是否所有Activity都支持换肤
     *
     * @param skinAllActivityEnable true:支持;false:不支持
     * @return {@link SkinManager}实例对象
     */
    public SkinManager setSkinAllActivityEnable(boolean skinAllActivityEnable) {
        this.skinAllActivityEnable = skinAllActivityEnable;
        return this;
    }

    /**
     * 返回是否所有Activity的状态栏都支持换肤
     *
     * @return true:支持;false:不支持
     */
    public boolean isSkinAllStatusBarColorEnable() {
        return skinAllStatusBarColorEnable;
    }

    /**
     * 设置是否所有Activity的状态栏都支持换肤(5.0以上有效)
     *
     * @param skinAllStatusBarColorEnable true:支持;false:不支持
     * @return {@link SkinManager}实例对象
     */
    public SkinManager setSkinAllStatusBarColorEnable(boolean skinAllStatusBarColorEnable) {
        this.skinAllStatusBarColorEnable = skinAllStatusBarColorEnable;
        return this;
    }

    /**
     * 返回Activity的状态栏支持换肤的集合
     *
     * @return 集合
     */
    public WeakHashMap<Activity, Boolean> getSkinStatusBarColorEnables() {
        return skinStatusBarColorEnables;
    }

    /**
     * 设置当前Activity支持状态栏换肤
     *
     * @param activity the activity
     */
    public void setSkinStatusBarColorEnable(Activity activity) {
        this.skinStatusBarColorEnables.put(activity, true);
    }

    /**
     * 返回Activity的状态栏不支持换肤的集合
     *
     * @return 集合
     */
    public WeakHashMap<Activity, Boolean> getSkinStatusBarColorDisEnables() {
        return skinStatusBarColorDisEnables;
    }

    /**
     * 设置当前Activity不支持状态栏换肤
     *
     * @param activity the activity
     */
    public void setSkinStatusBarColorDisEnable(Activity activity) {
        this.skinStatusBarColorDisEnables.put(activity, true);
    }

    /**
     * 返回所有实现SkinLayoutInflater接口的实例
     *
     * @return 集合
     */
    public List<SkinLayoutInflater> getSkinLayoutInflaters() {
        return skinLayoutInflaters;
    }

    /**
     * 添加自定义layoutInflater实例
     *
     * @param layoutInflater 自定义的layoutInflater实例
     * @return {@link SkinManager}实例对象
     */
    public SkinManager addLayoutInflater(SkinLayoutInflater layoutInflater) {
        // 新元素放置在首位,优先在后面添加的实例中匹配
        skinLayoutInflaters.add(0, layoutInflater);
        return this;
    }

    /**
     * 私有化构造函数
     *
     * @param application the application
     */
    private SkinManager(Application application) {
        super();
        this.contextWR = new WeakReference<>(application.getApplicationContext());
        SkinActivityLifecycleCallbacks.init(application);
        SkinPreferencesManager.init(application);
        SkinResourcesManager.init(application);
    }

    /**
     * 初始化,单例模式,只需要初始化一次,应该在Application的onCreate()方法中调用
     *
     * @param application the application
     * @return {@link SkinManager}实例对象
     */
    public static SkinManager init(Application application) {
        if (instance == null) {
            synchronized (SkinManager.class) {
                if (instance == null) {
                    instance = new SkinManager(application);
                }
            }
        }
        return instance;
    }

    /**
     * 得到当前实例对象,必须先调用初始化函数{@link SkinManager#init(Application)}
     *
     * @return {@link SkinManager}实例对象
     */
    public static SkinManager getInstance() {
        if (instance == null)
            throw new NullPointerException("SkinManager must first call the init(Application application)");

        return instance;
    }

    /**
     * 加载上次选择的皮肤,在Application中初始化换肤框架后调用。e:SkinManager.init(this).loadSkin();
     */
    public void loadSkin() {
        // 如果是内置皮肤
        if (SkinPreferencesManager.getInstance().isBuiltInSkin()) {
            // 获取皮肤后缀名
            String skinSuffixName = SkinPreferencesManager.getInstance().getSkinSuffixName();
            // 设置内置皮肤信息
            SkinResourcesManager.getInstance().setBuiltInSkinInfo(skinSuffixName);
            // 通知更新皮肤
            notifyUpdateSkin();
            return;
        }

        // 如果是assets文件夹中插件皮肤
        if (SkinPreferencesManager.getInstance().isAssetsSkin()) {
            // 获取外部插件皮肤路径
            String skinFilePath = SkinPreferencesManager.getInstance().getSkinFilePath();
            // 获取assets文件夹中插件皮肤路径
            String skinAssetsFilePath = SkinPreferencesManager.getInstance().getSkinAssetsFilePath();
            // 获取皮肤后缀名
            String skinSuffixName = SkinPreferencesManager.getInstance().getSkinSuffixName();
            loadSkin(skinFilePath, skinAssetsFilePath, skinSuffixName, true, null);
            return;
        }

        // 如果是外部插件皮肤
        if (SkinPreferencesManager.getInstance().isExternalSkin()) {
            // 获取外部插件皮肤路径
            String skinFilePath = SkinPreferencesManager.getInstance().getSkinFilePath();
            // 获取皮肤后缀名
            String skinSuffixName = SkinPreferencesManager.getInstance().getSkinSuffixName();
            loadSkin(skinFilePath, null, skinSuffixName, false, null);
            return;
        }

        // 如果是是自定义颜色
        if (SkinPreferencesManager.getInstance().isCustomSkin()) {
            // 设置自定义颜色信息
            SkinResourcesManager.getInstance().setCustomSkinInfo();
            // 通知更新皮肤
            notifyUpdateSkin();
            return;
        }

        // 如果都不是,说明没有使用皮肤,设置默认皮肤信息
        SkinResourcesManager.getInstance().setDefaultSkinInfo();
    }

    /**
     * 恢复默认
     */
    public void restoreDefault() {
        // 清除数据
        SkinPreferencesManager.getInstance().clearData();
        // 设置默认皮肤信息
        SkinResourcesManager.getInstance().setDefaultSkinInfo();
        // 通知更新皮肤
        notifyUpdateSkin();
    }

    /**
     * 加载内置皮肤
     *
     * @param skinSuffixName 皮肤后缀名
     */
    public void loadBuiltInSkin(String skinSuffixName) {
        // 保存为内置皮肤模式
        SkinPreferencesManager.getInstance().saveSkinModeBuiltIn();
        // 保存皮肤后缀名
        SkinPreferencesManager.getInstance().saveSkinSuffixName(skinSuffixName);
        // 设置内置皮肤信息
        SkinResourcesManager.getInstance().setBuiltInSkinInfo(skinSuffixName);
        // 通知更新皮肤
        notifyUpdateSkin();
    }

    /**
     * 加载assets文件夹中插件皮肤
     *
     * @param skinAssetsFilePath assets文件夹中插件皮肤路径
     */
    public void loadAssetsSkin(String skinAssetsFilePath) {
        loadAssetsSkin(skinAssetsFilePath, null);
    }

    /**
     * 加载assets文件夹中插件皮肤
     *
     * @param skinAssetsFilePath assets文件夹中插件皮肤路径
     * @param skinSuffixName     皮肤后缀名
     */
    public void loadAssetsSkin(String skinAssetsFilePath, String skinSuffixName) {
        loadAssetsSkin(skinAssetsFilePath, skinSuffixName, null);
    }

    /**
     * 加载assets文件夹中插件皮肤
     *
     * @param skinAssetsFilePath assets文件夹中插件皮肤路径
     * @param skinSuffixName     皮肤后缀名
     * @param loadPlugInSkin     加载插件皮肤任务监听
     */
    public void loadAssetsSkin(String skinAssetsFilePath, String skinSuffixName,
                               LoadPlugInSkinTask.ILoadPlugInSkin loadPlugInSkin) {
        loadSkin(null, skinAssetsFilePath, skinSuffixName, true, loadPlugInSkin);
    }

    /**
     * 加载外部插件皮肤
     *
     * @param skinFilePath 外部插件皮肤路径
     */
    public void loadExternalSkin(String skinFilePath) {
        loadExternalSkin(skinFilePath, null);
    }

    /**
     * 加载外部插件皮肤
     *
     * @param skinFilePath   外部插件皮肤路径
     * @param skinSuffixName 皮肤后缀名
     */
    public void loadExternalSkin(String skinFilePath, String skinSuffixName) {
        loadExternalSkin(skinFilePath, skinSuffixName, null);
    }

    /**
     * 加载外部插件皮肤
     *
     * @param skinFilePath   外部插件皮肤路径
     * @param skinSuffixName 皮肤后缀名
     * @param loadPlugInSkin 加载插件皮肤任务监听
     */
    public void loadExternalSkin(String skinFilePath, String skinSuffixName,
                                 LoadPlugInSkinTask.ILoadPlugInSkin loadPlugInSkin) {
        loadSkin(skinFilePath, null, skinSuffixName, false, loadPlugInSkin);
    }

    /**
     * 加载插件皮肤
     *
     * @param skinFilePath       外部插件皮肤路径
     * @param skinAssetsFilePath assets文件夹中插件皮肤路径
     * @param skinSuffixName     皮肤后缀名
     * @param isAssetsFile       是否是来自assets文件夹中插件皮肤
     * @param loadPlugInSkin     加载插件皮肤任务监听
     */
    private void loadSkin(String skinFilePath, String skinAssetsFilePath, String skinSuffixName,
                          boolean isAssetsFile, LoadPlugInSkinTask.ILoadPlugInSkin loadPlugInSkin) {
        if (contextWR.get() == null) {
            Log.e(TAG, "contextWR.get() == null");
            return;
        }
        new LoadPlugInSkinTask(contextWR.get(), skinFilePath, skinAssetsFilePath, skinSuffixName,
                isAssetsFile, loadPlugInSkin).execute();
    }

    /**
     * 记载定义颜色皮肤
     */
    public void loadCustomSkin() {
        // 保存为使用自定义颜色模式
        SkinPreferencesManager.getInstance().saveSkinModeCustom();
        // 设置自定义颜色信息
        SkinResourcesManager.getInstance().setCustomSkinInfo();
        // 通知更新皮肤
        notifyUpdateSkin();
    }
}