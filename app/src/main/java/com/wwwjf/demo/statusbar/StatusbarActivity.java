package com.wwwjf.demo.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;
import com.wwwjf.demo.R;

public class StatusbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            int statusbarColor = Color.parseColor("#ffffff");
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            setstatusBarTextColor(statusbarColor == Color.WHITE);

            //设置全屏页面
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            StatusBarUtil.setColorNoTranslucent(this,Color.parseColor("#282834"));
        }
    }


    private void setstatusBarTextColor(boolean isGray) {
        if (isGray) {
            //灰色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            //白色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }
}
