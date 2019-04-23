package com.wwwjf.demo.costomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.wwwjf.demo.R;

public class TouchListenerActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private static final String TAG = TouchListenerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_listener);

        View root = findViewById(R.id.ll_touch_listener);
        TestButton testButton = findViewById(R.id.testbutton_touch_listener);
        TextView tv = findViewById(R.id.tv_touch_listener);
        testButton.setOnClickListener(this);
        testButton.setOnTouchListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.e(TAG, "onClick: ==="+v.getClass().getSimpleName());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e(TAG, "onTouch: ===action="+event.getAction()+"=="+v.getClass().getSimpleName());
        return false;
    }
}
