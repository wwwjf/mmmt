package com.wwwjf.demo.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wwwjf.demo.R;
import com.wwwjf.demo.dagger.car3.Man3;

public class DaggerDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_demo);
        TextView textView = findViewById(R.id.tv_dagger);
        String info=null;
        Man man = new Man(new Car());
        info = man.car.go("111")+"\n";



        Man1 man1 = new Man1();
        man1.setCar(new Car());
        info += man1.car.go("222")+"\n";

        Man2 man2 = new Man2();
        man2.injectCar(new Car());
        info += man2.car.go("333")+"\n";


        Man3 man3 = new Man3();
        info += man3.car3.go("44444")+"\n";

        textView.setText(info);
    }
}
