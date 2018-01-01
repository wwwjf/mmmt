package com.wwwjf.demo.rxandroid;

import android.app.Activity;
import android.os.Bundle;

import com.wwwjf.demo.R;

import io.reactivex.Observable;

public class RxAndroidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid);
    }

    private Observable<AppInfo> getApps() {
        return null;
    }
}
