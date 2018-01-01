package com.wwwjf.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.wwwjf.demo.baiduai.CameraActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class BaiduAIDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_ai_demo);
        findViewById(R.id.buttonOCRText).setOnClickListener(this);
        findViewById(R.id.buttonOCRIdCard).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonOCRText:
                Intent intent = new Intent(BaiduAIDemoActivity.this, CameraActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonOCRIdCard:
                break;
            default:
                break;
        }

    }
}
