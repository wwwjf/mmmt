package com.wwwjf.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDemoActivity extends Activity {
    public static final String TAG = "OkHttpDemoActivity";
    private TextView mTextViewResult;

    private Handler messageHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTextViewResult.setText(msg.obj.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_demo);
        mTextViewResult = findViewById(R.id.textView_requestResult);
    }

    public void okHttpGet(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(AppConstants.url)
                            .build();
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    Log.i(TAG, "run: result="+result);
                    Message msg = Message.obtain();
                    msg.obj = result;
                    messageHandler.sendMessage(msg);
//                    mTextViewResult.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
