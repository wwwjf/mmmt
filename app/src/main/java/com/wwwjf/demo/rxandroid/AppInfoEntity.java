package com.wwwjf.demo.rxandroid;

import android.graphics.drawable.Drawable;

/**
 * Created by wwwjf on 2017/12/20.
 *
 * @author wwwjf
 */

public class AppInfoEntity implements Comparable<Object> {

    private String mName;
    private Drawable mIcon;

    public AppInfoEntity() {
    }

    public AppInfoEntity(String nName, Drawable icon) {
        mName = nName;
        mIcon = icon;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setIcon(Drawable icon) {
        mIcon = icon;
    }

    public String getmName() {
        return mName;
    }

    public Drawable getmIcon() {
        return mIcon;
    }

    @Override
    public int compareTo(Object another) {
        AppInfoEntity f = (AppInfoEntity) another;
        return getmName().compareTo(f.getmName());
    }
}
