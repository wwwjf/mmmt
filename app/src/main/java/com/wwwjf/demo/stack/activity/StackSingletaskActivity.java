package com.wwwjf.demo.stack.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.R;

public class StackSingletaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_singletask);

        findViewById(R.id.btn_stack_activity_singletask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletaskActivity.this,StackActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singletask2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletaskActivity.this,StackSingletopActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singletask3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletaskActivity.this,StackSingletaskActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singletask4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletaskActivity.this,StackSingleinstanceActivity.class));
            }
        });
    }
}
