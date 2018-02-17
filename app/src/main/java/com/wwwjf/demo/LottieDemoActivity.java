package com.wwwjf.demo;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

public class LottieDemoActivity extends AppCompatActivity {
    public static final String TAG = LottieDemoActivity.class.getSimpleName();

    private LottieAnimationView mLottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottiedemo);
        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lottieAnimationView);
//        mLottieAnimationView.setImageAssetsFolder("Images/WeAccept");
        mLottieAnimationView.setAnimation("LottieLogo.json");
        mLottieAnimationView.playAnimation();
        mLottieAnimationView.loop(true);
        mLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i(TAG, "onAnimationStart: 开始");

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i(TAG, "onAnimationEnd: 结束");

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i(TAG, "onAnimationCancel: 取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(TAG, "onAnimationRepeat: 重复");
                animation.start();
            }
        });
    }
}
