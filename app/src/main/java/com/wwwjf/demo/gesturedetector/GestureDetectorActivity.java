package com.wwwjf.demo.gesturedetector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import com.wwwjf.demo.R;

public class GestureDetectorActivity extends AppCompatActivity implements ScaleGestureDetector.OnScaleGestureListener {

    private static final String TAG = GestureDetectorActivity.class.getSimpleName();
    private ScaleGestureDetector sgd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);
        sgd = new ScaleGestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return sgd.onTouchEvent(event);
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        Log.e(TAG, "onScale: x="+detector.getFocusX());
        Log.e(TAG, "onScale: y="+detector.getFocusY());
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Log.e(TAG, "onScaleBegin: x="+detector.getFocusX());
        Log.e(TAG, "onScaleBegin: y="+detector.getFocusY());
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

        Log.e(TAG, "onScaleEnd: x="+detector.getFocusX());
        Log.e(TAG, "onScaleEnd: y="+detector.getFocusY());
    }
}
