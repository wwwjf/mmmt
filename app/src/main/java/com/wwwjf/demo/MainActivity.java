package com.wwwjf.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.elestickheader.EleStickHeaderActivity;
import com.wwwjf.demo.rxandroid.RxAndroidActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonTabLayoutDemo).setOnClickListener(this);
        findViewById(R.id.buttonQQLoginDemo).setOnClickListener(this);
        findViewById(R.id.buttonWechatDemo).setOnClickListener(this);
        findViewById(R.id.buttonBaiduAIDemo).setOnClickListener(this);
        findViewById(R.id.buttonOkHttpDemo).setOnClickListener(this);
        findViewById(R.id.buttonRxAndroidDemo).setOnClickListener(this);
        findViewById(R.id.buttonEleStickHeaderDemo).setOnClickListener(this);
        findViewById(R.id.buttonFilePickerDemo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTabLayoutDemo:
                Intent intentTabLayout = new Intent(this,TabLayoutDemoActivity.class);
                startActivity(intentTabLayout);
                break;
            case R.id.buttonQQLoginDemo:
                Intent intentQQLogin = new Intent(this,LoginQQDemoActivity.class);
                startActivity(intentQQLogin);
                break;
            case R.id.buttonWechatDemo:
                Intent intentWechatLogin = new Intent(this,LoginWechatDemoActivity.class);
                startActivity(intentWechatLogin);
                break;
            case R.id.buttonBaiduAIDemo:
                Intent intentBaiduAI = new Intent(this,BaiduAIDemoActivity.class);
                startActivity(intentBaiduAI);
                break;
            case R.id.buttonOkHttpDemo:
                Intent intentOkHttp = new Intent(this,OkHttpDemoActivity.class);
                startActivity(intentOkHttp);
                break;
            case R.id.buttonRxAndroidDemo:
                Intent intentRxAndroid = new Intent(this,RxAndroidActivity.class);
                startActivity(intentRxAndroid);
                break;
            case R.id.buttonEleStickHeaderDemo:
                Intent intentEleStickHeader = new Intent(this, EleStickHeaderActivity.class);
                startActivity(intentEleStickHeader);
                break;
            case R.id.buttonFilePickerDemo:
                Intent intentFilePicker = new Intent(this,FileActivity.class);
                startActivity(intentFilePicker);
                break;
            default:
                break;
        }
    }
}
