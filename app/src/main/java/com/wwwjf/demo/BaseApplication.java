package com.wwwjf.demo;

import android.app.Application;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

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

    @Override
    public void onCreate() {
        super.onCreate();
        registToWX();
    }
    private void registToWX() {

        mWxApi = WXAPIFactory.createWXAPI(this, WECHAT_APP_ID, false);
        // 将该app注册到微信
        mWxApi.registerApp(WECHAT_APP_ID);
    }
}
