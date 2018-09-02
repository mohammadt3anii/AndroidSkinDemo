package com.codearms.maoqiqi.skin.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * 文件帮助类
 * Author: fengqi.mao.march@gmail.com
 * Date: 2018/9/2 20:59
 */
public class FileUtils {

    /**
     * 得到缓存目录
     *
     * @param context the context
     * @return 缓存目录
     */
    private static String getCacheDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File cacheDir = context.getExternalCacheDir();
            if (cacheDir != null && (cacheDir.exists() || cacheDir.mkdirs())) {
                return cacheDir.getAbsolutePath();
            }
        }
        return context.getCacheDir().getAbsolutePath();
    }

    /**
     * 从Assets复制文件到缓存目录
     *
     * @param context        the context
     * @param assetsFilePath Assets文件夹下文件路径
     * @return 复制文件路径
     */
    public static String copyFileFromAssets(Context context, String assetsFilePath) {
        String cacheDir = getCacheDir(context);
        String cachePath = new File(cacheDir, File.separator + assetsFilePath).getAbsolutePath();

        // 判断Assets文件夹下文件路径是否包含文件夹,如果包含文件夹并且该文件夹不存在,则创建
        int index = assetsFilePath.lastIndexOf(File.separator);
        if (index != -1) {
            String dir = cacheDir + File.separator + assetsFilePath.substring(0, index);
            File file = new File(dir);
            if (!file.exists()) {
                boolean flag = file.mkdirs();
                if (!flag) return null;
            }
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = context.getAssets().open(assetsFilePath);
            os = new FileOutputStream(cachePath);
            byte[] buff = new byte[1024];
            int len;
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cachePath;
    }

    /**
     * 获取apk的包名
     *
     * @param context  the context
     * @param filePath apk文件路径
     * @return apk包名
     */
    public static String getPackageName(Context context, String filePath) {
        // 初始化包管理器
        PackageManager packageManager = context.getPackageManager();
        // 得到安装包信息
        PackageInfo info = packageManager.getPackageArchiveInfo(filePath, PackageManager.GET_ACTIVITIES);
        // 得到包名
        return info.packageName;
    }

    /**
     * 从apk文件中获取Resources对象
     *
     * @param context  the context
     * @param filePath apk文件路径
     * @return Resources对象
     * @throws Exception err
     */
    public static Resources getResources(Context context, String filePath) throws Exception {
        // 创建AssetManager实例
        AssetManager assetManager = AssetManager.class.newInstance();
        // 通过反射调用addAssetPath方法
        Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
        // assetManager对象中带有参数path的addAssetPath方法。
        addAssetPath.invoke(assetManager, filePath);

        // 得到系统当前的资源对象
        Resources resources = context.getResources();
        // 创建新的的资源对象
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }
}