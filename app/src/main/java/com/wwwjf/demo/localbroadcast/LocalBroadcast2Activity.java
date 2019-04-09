package com.wwwjf.demo.localbroadcast;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wwwjf.demo.R;

public class LocalBroadcast2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast2);

        Intent intent = new Intent(LocalBroadcast1Activity.ACTION_LOCAL_SEND);
        intent.putExtra(LocalBroadcast1Activity.MSG_KEY,"来自第二页的广播消息");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
