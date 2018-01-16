package com.wwwjf.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class FileActivity extends Activity {

    public static final String TAG = "FileActivity";
    private ArrayList<String> filePathList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filepicker);
        filePathList = new ArrayList<>();
        findViewById(R.id.buttonFilePick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilePickerBuilder.getInstance()
                        .setMaxCount(5)
                        .setSelectedFiles(filePathList)
                        .setActivityTheme(R.style.AppTheme)
                        .pickPhoto(FileActivity.this);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case FilePickerConst.REQUEST_CODE_PHOTO:
                if (resultCode == RESULT_OK && data != null){
                    filePathList = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
                    for (int i = 0; i < filePathList.size(); i++) {
                        Log.i(TAG, "onActivityResult: path="+filePathList.get(i));
                    }
                }
                break;
            default:
                break;
        }

    }
}
