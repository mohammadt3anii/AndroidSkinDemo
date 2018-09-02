package com.codearms.maoqiqi.skin.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.codearms.maoqiqi.skin.manager.SkinManager;
import com.codearms.maoqiqi.skin.manager.SkinPreferencesManager;
import com.codearms.maoqiqi.skin.manager.SkinResourcesManager;
import com.codearms.maoqiqi.skin.utils.FileUtils;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * 加载插件皮肤的异步任务
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 21:21
 */
public class LoadPlugInSkinTask extends AsyncTask<LoadPlugInSkinTask.ILoadPlugInSkin, Void, Resources> {

    private WeakReference<Context> contextWR;
    private String skinFilePath;
    private String skinAssetsFilePath;
    private String skinSuffixName;
    private boolean isAssetsFile;
    private ILoadPlugInSkin loadPlugInSkin;

    // 皮肤包名
    private String skinPackageName;
    // 错误码
    private int code;
    // 错误信息
    private String message;

    public LoadPlugInSkinTask(Context context, String skinFilePath, String skinAssetsFilePath, String skinSuffixName,
                              boolean isAssetsFile, ILoadPlugInSkin loadPlugInSkin) {
        this.contextWR = new WeakReference<>(context);
        this.skinFilePath = skinFilePath;
        this.skinAssetsFilePath = skinAssetsFilePath;
        this.skinSuffixName = skinSuffixName;
        this.isAssetsFile = isAssetsFile;
        this.loadPlugInSkin = loadPlugInSkin;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (loadPlugInSkin != null) loadPlugInSkin.onLoadSkinStart();
    }

    @Override
    protected Resources doInBackground(ILoadPlugInSkin... iLoadPlugInSkins) {
        if (skinFilePath == null || skinFilePath.equals("") || !new File(skinFilePath).exists()) {
            if (!isAssetsFile || skinAssetsFilePath == null || skinAssetsFilePath.equals("")) {
                code = 10001;
                message = "File does not exist.";
                return null;
            } else {
                // 复制assets下的文件到缓存目录
                skinFilePath = FileUtils.copyFileFromAssets(contextWR.get(), skinAssetsFilePath);
                if (skinFilePath == null) {
                    code = 10002;
                    message = "Failed to copy files.";
                    return null;
                }
            }
        }

        try {
            skinPackageName = FileUtils.getPackageName(contextWR.get(), skinFilePath);
            return FileUtils.getResources(contextWR.get(), skinFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            code = 10003;
            message = e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Resources resources) {
        super.onPostExecute(resources);
        if (resources != null) { // 加载成功
            if (isAssetsFile) {
                // 保存为使用assets文件夹中插件皮肤模式
                SkinPreferencesManager.getInstance().saveSkinModeAssets();
                // 保存assets文件夹中插件皮肤路径
                SkinPreferencesManager.getInstance().saveSkinAssetsFilePath(skinAssetsFilePath);
            } else {
                // 保存为使用外部插件皮肤模式
                SkinPreferencesManager.getInstance().saveSkinModeExternal();
            }
            // 保存外部插件皮肤路径
            SkinPreferencesManager.getInstance().saveSkinFilePath(skinFilePath);
            if (skinSuffixName == null) skinSuffixName = "";
            // 保存皮肤后缀名
            SkinPreferencesManager.getInstance().saveSkinSuffixName(skinSuffixName);
            // 设置插件皮肤信息
            SkinResourcesManager.getInstance().setPlugInSkinInfo(skinSuffixName, skinPackageName, resources);
            // 通知更新皮肤
            SkinManager.getInstance().notifyUpdateSkin();

            if (loadPlugInSkin != null) loadPlugInSkin.onLoadSkinSuccess();
        } else {
            // 加载失败,当前使用什么皮肤就使用什么皮肤,不用任何操作
            if (loadPlugInSkin != null) loadPlugInSkin.onLoadSkinFailed(code, message);
        }
    }

    /**
     * 加载插件皮肤任务监听
     */
    public interface ILoadPlugInSkin {

        /**
         * 开始加载时调用
         */
        void onLoadSkinStart();

        /**
         * 加载成功时调用
         */
        void onLoadSkinSuccess();

        /**
         * 加载失败时调用
         *
         * @param code    错误码
         * @param message 错误信息
         */
        void onLoadSkinFailed(int code, String message);
    }
}