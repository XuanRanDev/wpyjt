package com.XuanRan.wpyjt.model.bean;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/6/24.
 */
public class AppInfo {
    String appName;
    String packageName;
    String appIntent;
    Drawable drawable;

    public AppInfo() {
    }

    public String getAppIntent() {
        return appIntent;
    }

    public void setAppIntent(String appIntent) {
        this.appIntent = appIntent;
    }

    public AppInfo(String appName) {
        this.appName = appName;
    }

    public AppInfo(String appName, String packageName) {
        this.appName = appName;
        this.packageName = packageName;
    }

    public AppInfo(String appName, String packageName, Drawable drawable, String appIntent) {
        this.appName = appName;
        this.packageName = packageName;
        this.drawable = drawable;
        this.appIntent = appIntent;
    }


    public String getAppName() {
        if (null == appName)
            return "";
        else
            return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        if (null == packageName)
            return "";
        else
            return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
