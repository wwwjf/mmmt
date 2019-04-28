package com.wwwjf.demo.stack.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wwwjf.demo.R;

public class StackSingletopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_singletop);
        findViewById(R.id.btn_stack_activity_singleTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletopActivity.this,StackActivity.class));
            }
        });

        findViewById(R.id.btn_stack_activity_singleTop2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletopActivity.this,StackSingletopActivity.class));
            }
        });
        findViewById(R.id.btn_stack_activity_singleTop3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StackSingletopActivity.this, StackSingletaskActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_stack_activity_singleTop4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StackSingletopActivity.this,StackSingleinstanceActivity.class));
            }
        });
    }
}
