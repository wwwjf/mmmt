package com.wwwjf.demo.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wengjianfeng on 2018/12/4.
 */

public class DBManager {

    private static final String dbName = "GreenDao_demo.db";
    private static DBManager mDBManager;
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private Context mContext;

    private DBManager(Context context){
        mContext = context;
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context,dbName,null);
    }

    public static DBManager getInstance(Context context) {
        if (mDBManager == null){
            synchronized (DBManager.class){
                if (mDBManager == null){
                    mDBManager = new DBManager(context);
                }
            }
        }
        return mDBManager;
    }

    /**
     * 获取可读数据库
     */
    public SQLiteDatabase getReadableDatabase() {
        if (mDevOpenHelper == null) {
            mDevOpenHelper = new DaoMaster.DevOpenHelper(mContext, dbName, null);
        }
        SQLiteDatabase db = mDevOpenHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    public SQLiteDatabase getWritableDatabase() {
        if (mDevOpenHelper == null) {
            mDevOpenHelper = new DaoMaster.DevOpenHelper(mContext, dbName, null);
        }
        SQLiteDatabase db = mDevOpenHelper.getWritableDatabase();
        return db;
    }
}
