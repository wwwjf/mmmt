package com.wwwjf.demo.rxandroid;

/**
 * Created by wwwjf on 2017/12/20.
 *
 * @author wwwjf
 */

public class AppInfo implements Comparable<Object> {

    long mLastUpdateTime;
    String mName;
    String mIcon;

    public AppInfo(String nName, long lastUpdateTime, String icon) {
        mName = nName;
        mIcon = icon;
        mLastUpdateTime = lastUpdateTime;
    }

    public long getmLastUpdateTime() {
        return mLastUpdateTime;
    }

    public String getmName() {
        return mName;
    }

    public String getmIcon() {
        return mIcon;
    }

    @Override
    public int compareTo(Object another) {
        AppInfo f = (AppInfo)another;
        return getmName().compareTo(f.getmName());
    }
}
