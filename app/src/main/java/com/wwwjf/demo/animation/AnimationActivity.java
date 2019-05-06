package com.wwwjf.demo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.wwwjf.demo.R;

public class AnimationActivity extends AppCompatActivity {

    private ImageView ivFrameAnimJava;
    private ImageView ivFrameAnim;
    private ImageView ivFrameAnim3;
    private ImageView ivTweenAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivFrameAnimJava = findViewById(R.id.iv_anim_frame_java);
        ivFrameAnim = findViewById(R.id.iv_anim_frame);
        ivTweenAnim = findViewById(R.id.iv_anim_tween);
        ivFrameAnim3 = findViewById(R.id.iv_anim_frame3);

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


    }
}
