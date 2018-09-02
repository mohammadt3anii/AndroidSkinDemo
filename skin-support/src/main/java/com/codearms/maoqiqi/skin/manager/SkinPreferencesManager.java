package com.codearms.maoqiqi.skin.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * 保存当前使用的皮肤信息,使下次打开程序还是使用的上次选择的皮肤
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 18:13
 */
public class SkinPreferencesManager {

    private static final String TAG = SkinPreferencesManager.class.getSimpleName();

    /**
     * SharedPreferences文件名称
     */
    private static final String PREFERENCE_NAME = "skin_preferences";

    // ---------------------------------------------------------------------------------------------

    /**
     * 皮肤模式的名称(0:默认皮肤;1:内置皮肤;2:使用assets文件夹中插件皮肤;3:使用外部插件皮肤;4:自定义颜色)
     * 自选颜色(选择colorPrimary、colorPrimaryDark、colorAccent)
     */
    private static final String SKIN_MODE = "skin_mode";

    /**
     * 默认皮肤模式
     */
    private static final int SKIN_MODE_DEFAULT = 0;

    /**
     * 内置皮肤模式
     */
    private static final int SKIN_MODE_BUILT_IN = 1;

    /**
     * 使用assets文件夹中插件皮肤模式
     */
    private static final int SKIN_MODE_ASSETS = 2;

    /**
     * 使用外部插件皮肤模式
     */
    private static final int SKIN_MODE_EXTERNAL = 3;

    /**
     * 使用自定义颜色模式
     */
    private static final int SKIN_MODE_CUSTOM = 4;

    // ---------------------------------------------------------------------------------------------

    /**
     * 存储 皮肤后缀名 的名称
     */
    private static final String SKIN_SUFFIX_NAME = "skin_suffix_name";

    /**
     * 默认 皮肤后缀名
     */
    private static final String SKIN_SUFFIX_NAME_DEFAULT = "";

    /**
     * 存储 assets文件夹中插件皮肤路径 的名称
     */
    private static final String SKIN_ASSETS_FILE_PATH = "skin_assets_file_path";

    /**
     * 默认 assets文件夹中插件皮肤路径
     */
    private static final String SKIN_ASSETS_FILE_PATH_DEFAULT = "";

    /**
     * 存储 外部插件皮肤 的名称
     */
    private static final String SKIN_FILE_PATH = "skin_file_path";

    /**
     * 默认 外部插件皮肤路径
     */
    private static final String SKIN_FILE_PATH_DEFAULT = "";

    // ---------------------------------------------------------------------------------------------

    /**
     * 存储 colorPrimary entry name 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY_NAME = "color_primary_name";

    /**
     * 默认 colorPrimary entry name
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY_NAME_DEFAULT = "colorPrimary";

    /**
     * 存储 colorPrimaryDark entry name 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY_DARK_NAME = "color_primary_dark_name";

    /**
     * 默认 colorPrimaryDark entry name
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY_DARK_NAME_DEFAULT = "colorPrimaryDark";

    /**
     * 存储 colorAccent entry name 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_ACCENT_NAME = "color_accent_name";

    /**
     * 默认 colorAccent entry name
     */
    private static final String SKIN_CUSTOM_COLOR_ACCENT_NAME_DEFAULT = "colorAccent";

    // ---------------------------------------------------------------------------------------------

    /**
     * 存储 colorPrimary value 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY = "color_primary";

    /**
     * 存储 colorPrimaryDark value 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_PRIMARY_DARK = "color_primary_dark";

    /**
     * 存储 colorAccent value 的名称
     */
    private static final String SKIN_CUSTOM_COLOR_ACCENT = "color_accent";

    /**
     * 默认 color value
     */
    private static final String SKIN_CUSTOM_COLOR_DEFAULT = "";

    // ---------------------------------------------------------------------------------------------

    /**
     * SharedPreferences文件存储对象
     */
    private final SharedPreferences sharedPreferences;

    /**
     * 当前实例
     */
    private static SkinPreferencesManager instance;

    /**
     * 私有化构造函数
     *
     * @param context the context
     */
    private SkinPreferencesManager(Context context) {
        // 实例化SharedPreferences文件存储对象
        this.sharedPreferences = context.getApplicationContext()
                .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 初始化,单例模式,只需要初始化一次
     *
     * @param context the context
     */
    public static void init(Context context) {
        if (instance == null) {
            synchronized (SkinPreferencesManager.class) {
                if (instance == null) {
                    instance = new SkinPreferencesManager(context);
                }
            }
        }
    }

    /**
     * 得到当前实例对象,必须先调用初始化函数{@link SkinPreferencesManager#init(Context)}
     *
     * @return {@link SkinPreferencesManager}实例对象
     */
    public static SkinPreferencesManager getInstance() {
        if (instance == null)
            throw new NullPointerException("SkinPreferencesManager must first call the init(Context context)");

        return instance;
    }

    private void commit(SharedPreferences.Editor editor) {
        boolean flag = editor.commit();
        if (!flag) Log.e(TAG, "SkinPreferencesManager commit fail");
    }

    /**
     * 保存皮肤模式(私有化,提供三个方法,防止传入坏数据)
     *
     * @param skinMode 皮肤模式
     */
    private void saveSkinMode(int skinMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SKIN_MODE, skinMode);
        commit(editor);
    }

    /**
     * 保存为内置皮肤模式
     */
    public void saveSkinModeBuiltIn() {
        saveSkinMode(SKIN_MODE_BUILT_IN);
    }

    /**
     * 保存为使用assets文件夹中插件皮肤模式
     */
    public void saveSkinModeAssets() {
        saveSkinMode(SKIN_MODE_ASSETS);
    }

    /**
     * 保存为使用外部插件皮肤模式
     */
    public void saveSkinModeExternal() {
        saveSkinMode(SKIN_MODE_EXTERNAL);
    }

    /**
     * 保存为使用自定义颜色模式
     */
    public void saveSkinModeCustom() {
        saveSkinMode(SKIN_MODE_CUSTOM);
    }

    /**
     * 获取皮肤模式(私有化,提供四个方法)
     *
     * @return 皮肤模式
     */
    private int getSkinMode() {
        return sharedPreferences.getInt(SKIN_MODE, SKIN_MODE_DEFAULT);
    }

    /**
     * 是否是默认皮肤
     *
     * @return true or false
     */
    public boolean isDefaultSkin() {
        return SKIN_MODE_DEFAULT == getSkinMode();
    }

    /**
     * 是否是内置皮肤
     *
     * @return true or false
     */
    public boolean isBuiltInSkin() {
        return SKIN_MODE_BUILT_IN == getSkinMode();
    }

    /**
     * 是否是assets文件夹中插件皮肤
     *
     * @return true or false
     */
    public boolean isAssetsSkin() {
        return SKIN_MODE_ASSETS == getSkinMode();
    }

    /**
     * 是否是外部插件皮肤
     *
     * @return true or false
     */
    public boolean isExternalSkin() {
        return SKIN_MODE_EXTERNAL == getSkinMode();
    }

    /**
     * 是否是自定义颜色
     *
     * @return true or false
     */
    public boolean isCustomSkin() {
        return SKIN_MODE_CUSTOM == getSkinMode();
    }

    /**
     * 保存皮肤后缀名
     *
     * @param skinSuffixName 皮肤后缀名
     */
    public void saveSkinSuffixName(String skinSuffixName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_SUFFIX_NAME, skinSuffixName);
        commit(editor);
    }

    /**
     * 获取皮肤后缀名
     *
     * @return 皮肤后缀名
     */
    public String getSkinSuffixName() {
        return sharedPreferences.getString(SKIN_SUFFIX_NAME, SKIN_SUFFIX_NAME_DEFAULT);
    }

    /**
     * 保存assets文件夹中插件皮肤路径
     *
     * @param skinAssetsFilePath 路径
     */
    public void saveSkinAssetsFilePath(String skinAssetsFilePath) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_ASSETS_FILE_PATH, skinAssetsFilePath);
        commit(editor);
    }

    /**
     * 获取assets文件夹中插件皮肤路径
     *
     * @return 路径
     */
    public String getSkinAssetsFilePath() {
        return sharedPreferences.getString(SKIN_ASSETS_FILE_PATH, SKIN_ASSETS_FILE_PATH_DEFAULT);
    }

    /**
     * 保存外部插件皮肤路径
     *
     * @param skinFilePath 路径
     */
    public void saveSkinFilePath(String skinFilePath) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_FILE_PATH, skinFilePath);
        commit(editor);
    }

    /**
     * 获取外部插件皮肤路径
     *
     * @return 路径
     */
    public String getSkinFilePath() {
        return sharedPreferences.getString(SKIN_FILE_PATH, SKIN_FILE_PATH_DEFAULT);
    }

    /**
     * 保存 colorPrimary entry name 名称
     *
     * @param colorPrimaryName colorPrimary entry name
     */
    public void saveSkinColorPrimaryName(String colorPrimaryName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_PRIMARY_NAME, colorPrimaryName);
        commit(editor);
    }

    /**
     * 获取colorPrimary entry name
     *
     * @return colorPrimary entry name
     */
    public String getSkinColorPrimaryName() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_PRIMARY_NAME, SKIN_CUSTOM_COLOR_PRIMARY_NAME_DEFAULT);
    }

    /**
     * 保存 colorPrimaryDark entry name 名称
     *
     * @param colorPrimaryDarkName colorPrimaryDark entry name
     */
    public void saveSkinColorPrimaryDarkName(String colorPrimaryDarkName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_PRIMARY_DARK_NAME, colorPrimaryDarkName);
        commit(editor);
    }

    /**
     * 获取 colorPrimaryDark entry name
     *
     * @return colorPrimaryDark entry name
     */
    public String getSkinColorPrimaryDarkName() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_PRIMARY_DARK_NAME, SKIN_CUSTOM_COLOR_PRIMARY_DARK_NAME_DEFAULT);
    }

    /**
     * 保存 colorAccent entry name 名称
     *
     * @param colorAccentName colorAccent entry name
     */
    public void saveSkinColorAccentName(String colorAccentName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_ACCENT_NAME, colorAccentName);
        commit(editor);
    }

    /**
     * 获取 colorAccent entry name
     *
     * @return colorAccent entry name
     */
    public String getSkinColorAccentName() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_ACCENT_NAME, SKIN_CUSTOM_COLOR_ACCENT_NAME_DEFAULT);
    }

    /**
     * 保存colorPrimary颜色
     *
     * @param colorPrimary 颜色
     */
    public void saveSkinColorPrimary(String colorPrimary) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_PRIMARY, colorPrimary);
        commit(editor);
    }

    /**
     * 获取colorPrimary颜色
     *
     * @return colorPrimary
     */
    public String getSkinColorPrimary() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_PRIMARY, SKIN_CUSTOM_COLOR_DEFAULT);
    }

    /**
     * 保存colorPrimaryDark颜色
     *
     * @param colorPrimaryDark 颜色
     */
    public void saveSkinColorPrimaryDark(String colorPrimaryDark) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_PRIMARY_DARK, colorPrimaryDark);
        commit(editor);
    }

    /**
     * 获取colorPrimaryDark颜色
     *
     * @return colorPrimaryDark
     */
    public String getSkinColorPrimaryDark() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_PRIMARY_DARK, SKIN_CUSTOM_COLOR_DEFAULT);
    }

    /**
     * 保存colorAccent颜色
     *
     * @param colorAccent 颜色
     */
    public void saveSkinColorAccent(String colorAccent) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SKIN_CUSTOM_COLOR_ACCENT, colorAccent);
        commit(editor);
    }

    /**
     * 获取colorAccent颜色
     *
     * @return colorAccent
     */
    public String getSkinColorAccent() {
        return sharedPreferences.getString(SKIN_CUSTOM_COLOR_ACCENT, SKIN_CUSTOM_COLOR_DEFAULT);
    }

    /**
     * 清除数据,恢复默认皮肤
     */
    public void clearData() {
        saveSkinMode(SKIN_MODE_DEFAULT);
        saveSkinFilePath(SKIN_FILE_PATH_DEFAULT);
        saveSkinAssetsFilePath(SKIN_ASSETS_FILE_PATH_DEFAULT);
        saveSkinSuffixName(SKIN_SUFFIX_NAME_DEFAULT);
    }
}