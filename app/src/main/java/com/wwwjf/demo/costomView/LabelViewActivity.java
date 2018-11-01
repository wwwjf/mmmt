package com.wwwjf.demo.costomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wwwjf.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LabelViewActivity extends AppCompatActivity {
    @BindView(R.id.labelView_activity)
    LabelView mLabelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_view);
        ButterKnife.bind(this);


    }
}
