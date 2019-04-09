package com.wwwjf.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.costomView.LabelViewActivity;
import com.wwwjf.demo.elestickheader.EleStickHeaderActivity;
import com.wwwjf.demo.eventbus.EventBus1Activity;
import com.wwwjf.demo.greendao.GreendaoActivity;
import com.wwwjf.demo.localbroadcast.LocalBroadcast1Activity;
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
        findViewById(R.id.buttonLottieDemo).setOnClickListener(this);
        findViewById(R.id.buttonEventBusDemo).setOnClickListener(this);
        findViewById(R.id.buttonBottomNavigationDemo).setOnClickListener(this);
        findViewById(R.id.CircleDialogDemo).setOnClickListener(this);
        findViewById(R.id.ConstraintDemo).setOnClickListener(this);
        findViewById(R.id.LabelViewDemo).setOnClickListener(this);
        findViewById(R.id.greenDaoDemo).setOnClickListener(this);
        findViewById(R.id.localBroadcastDemo).setOnClickListener(this);

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
            case R.id.buttonLottieDemo:
                Intent intentLottie = new Intent(this,LottieDemoActivity.class);
                startActivity(intentLottie);
                break;
            case R.id.buttonEventBusDemo:
                Intent intentEventBus = new Intent(this, EventBus1Activity.class);
                startActivity(intentEventBus);
                break;
            case R.id.buttonBottomNavigationDemo:
                Intent intentBottomNavigation = new Intent(this, BottomNavigationActivity.class);
                startActivity(intentBottomNavigation);
                break;
                case R.id.CircleDialogDemo:
                Intent intentCircleDialog = new Intent(this, CircleDialogActivity.class);
                startActivity(intentCircleDialog);
                break;
            case R.id.ConstraintDemo:
                startActivity(new Intent(this,ConstraintActivity.class));
                break;
            case R.id.LabelViewDemo:
                startActivity(new Intent(this, LabelViewActivity.class));
                break;
            case R.id.greenDaoDemo:
                startActivity(new Intent(this, GreendaoActivity.class));
                break;
            case R.id.localBroadcastDemo:
                startActivity(new Intent(this, LocalBroadcast1Activity.class));
                break;
            default:
                break;
        }
    }
}
