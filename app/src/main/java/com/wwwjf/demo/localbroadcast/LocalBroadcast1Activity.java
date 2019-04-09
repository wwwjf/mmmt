package com.wwwjf.demo.localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wwwjf.demo.R;

public class LocalBroadcast1Activity extends AppCompatActivity {
    private TextView localMsg;
    public static final String MSG_KEY = "Broadcast_key";
    public static final String ACTION_LOCAL_SEND = "com.wwwjf.localbroadcast";
    private LocalBroadcast1Activity.LocalBroadcastReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast1);
        localMsg = findViewById(R.id.tv_localBroadcastMsg);

        localReceiver = new LocalBroadcastReceiver();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(localReceiver, new IntentFilter(ACTION_LOCAL_SEND));

        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocalBroadcast1Activity.this,LocalBroadcast2Activity.class));
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);

    }

    public class LocalBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            localMsg.setText(intent.getStringExtra(MSG_KEY));
        }
    }
}



