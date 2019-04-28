package com.wwwjf.demo.stack.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.R;

public class StackSingleinstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_singleinstance);


        findViewById(R.id.btn_stack_activity_singleinstance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingleinstanceActivity.this,StackActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singleinstance2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingleinstanceActivity.this,StackSingletopActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singleinstance3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StackSingleinstanceActivity.this, StackSingletaskActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_stack_activity_singleinstance4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingleinstanceActivity.this,StackSingleinstanceActivity.class));
            }
        });
    }
}
