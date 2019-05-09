package com.wwwjf.demo.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.wwwjf.demo.R;

public class AnimationActivity extends AppCompatActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();
    private ImageView ivFrameAnimJava;
    private ImageView ivFrameAnim;
    private ImageView ivFrameAnim3;
    private ImageView ivTweenAnim;
    private ImageView ivPropertyAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivFrameAnimJava = findViewById(R.id.iv_anim_frame_java);
        ivFrameAnim = findViewById(R.id.iv_anim_frame);
        ivTweenAnim = findViewById(R.id.iv_anim_tween);
        ivFrameAnim3 = findViewById(R.id.iv_anim_frame3);
        ivPropertyAnim = findViewById(R.id.iv_anim_property);

        //代码中设置帧动画
//        for (int i = 0; i < 2; i++) {
        //获取资源ID
//            getResources().getIdentifier("ic_anim_"+i,"drawable",getPackageName());
//        }
        Drawable pic1 = getResources().getDrawable(R.drawable.ic_add);
        Drawable pic2 = getResources().getDrawable(R.drawable.sample_footer_loading);
        AnimationDrawable anim = new AnimationDrawable();
        anim.addFrame(pic2, 2000);
        anim.addFrame(pic1, 2000);

        ivFrameAnimJava.setBackgroundDrawable(anim);

        anim.start();

        //xml中设置帧动画
        ((AnimationDrawable) ivFrameAnim.getBackground()).start();


        //xml中设置补间动画
        Animation animationTween = AnimationUtils.loadAnimation(this, R.anim.anim_tween);
        animationTween.setRepeatCount(Animation.INFINITE);
        animationTween.setRepeatMode(Animation.RESTART);
        //重复旋转的动画默认不是匀速旋转插值器
        animationTween.setInterpolator(new LinearInterpolator());
        ivTweenAnim.setAnimation(animationTween);

        animationTween.start();


        //属性动画
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f,1.0f);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: value="+value);
            }
        });
        animator.start();

        //
        ObjectAnimator rotationAnimator = new ObjectAnimator();
        rotationAnimator.setPropertyName("rotation");
        rotationAnimator.setTarget(ivPropertyAnim);
        rotationAnimator.setDuration(1000);
        rotationAnimator.setFloatValues(0,360);
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotationAnimator.setRepeatMode(ValueAnimator.RESTART);
        rotationAnimator.start();

    }
}
