package com.wwwjf.demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wwwjf.demo.greendao.DBManager;
import com.wwwjf.demo.greendao.DaoMaster;
import com.wwwjf.demo.greendao.DaoSession;
import com.wwwjf.demo.objectbox.ObjectBoxManager;

/**
 * Created by wwwjf on 2017/10/21.
 * @author wwwjf
 */

public class BaseApplication extends Application {
    public IWXAPI mWxApi;
    /**
     * WEIXIN_APP_ID是指你应用在微信开放平台上的AppID
     */
    public static final String WECHAT_APP_ID = "wx1a96f474546b832d";

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        registToWX();

        //配置数据库
        DBManager.getInstance(this).getWritableDatabase();

        //ObjectBox
        ObjectBoxManager.init(this);
    }
    private void registToWX() {

        mWxApi = WXAPIFactory.createWXAPI(this, WECHAT_APP_ID, false);
        // 将该app注册到微信
        mWxApi.registerApp(WECHAT_APP_ID);
    }



}
