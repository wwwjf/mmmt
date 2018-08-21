package com.wwwjf.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConstraintActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView_constraint)
    RecyclerView mRecyclerView;
    private List<String> mList;
    private ConstraintAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add(i + "_" + i);
        }
        mAdapter = new ConstraintAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

    }
}