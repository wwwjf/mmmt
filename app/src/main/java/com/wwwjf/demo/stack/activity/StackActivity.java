package com.wwwjf.demo.stack.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.R;

public class StackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        findViewById(R.id.btn_stack_activity_standard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackActivity.this,StackActivity.class));
            }
        });

        findViewById(R.id.btn_stack_activity_standard2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackActivity.this,StackSingletopActivity.class));
            }
        });

        findViewById(R.id.btn_stack_activity_standard3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackActivity.this,StackSingletaskActivity.class));
            }
        });

        findViewById(R.id.btn_stack_activity_standard4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackActivity.this,StackSingleinstanceActivity.class));
            }
        });
    }
}
