package com.wwwjf.demo.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wwwjf.demo.R;

import org.greenrobot.eventbus.EventBus;

public class EventBus2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setMessage("EventBus2Activity 发送消息");
        EventBus.getDefault().post(messageEvent);
    }
}
