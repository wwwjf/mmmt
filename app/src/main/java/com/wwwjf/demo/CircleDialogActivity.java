package com.wwwjf.demo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.mylhyl.circledialog.CircleDialog;

public class CircleDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_dialog);

    }

    public void onClick(View view) {
        new CircleDialog.Builder()
                .setTitle("标题")
                .setText("提示框")
                .setPositive("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CircleDialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegative("取消",null)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(CircleDialogActivity.this, "取消了！", Toast.LENGTH_SHORT).show();
                    }
                })
                .show(getSupportFragmentManager());
    }
}
