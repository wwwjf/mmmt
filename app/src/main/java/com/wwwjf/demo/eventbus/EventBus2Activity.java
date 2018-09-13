package com.wwwjf.demo.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wwwjf.demo.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBus2Activity extends AppCompatActivity {

    @BindView(R.id.button_eventBus2)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        ButterKnife.bind(this);
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setMessage("EventBus2Activity 发送消息");
        EventBus.getDefault().post(messageEvent);
    }

    @OnClick(R.id.button_eventBus2)
    public void onViewClicked(View view){
        EventBus.getDefault().postSticky(new MessageStickEvent("来自eventBus2Activity消息"));
        startActivity(new Intent(this,EventBus3Activity.class));
    }
}
