package com.wwwjf.demo;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelmsg.SendAuth;

public class LoginWechatDemoActivity extends AppCompatActivity {

    private BaseApplication mBaseApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_wechat_demo);
        mBaseApplication = (BaseApplication) getApplication();
        findViewById(R.id.buttonWechatLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wxLogin();
            }
        });
    }

    public void wxLogin() {
        if (!mBaseApplication.mWxApi.isWXAppInstalled()) {
            Toast.makeText(this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
            return;
        }
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wwwjf_wx_login";
        mBaseApplication.mWxApi.sendReq(req);
    }
}
