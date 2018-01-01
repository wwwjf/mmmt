package com.wwwjf.demo.elestickheader;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.wwwjf.demo.R;

import java.util.ArrayList;
import java.util.List;

public class EleStickHeaderActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private RecyclerView mRecyclerView;
    private CommonAdapter mCommonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elestickheader);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("饿了嘛");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab3"));
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mCommonAdapter = new CommonAdapter(R.layout.item_common_text);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("item" + i);
        }
        mCommonAdapter.addData(data);
        mRecyclerView.setAdapter(mCommonAdapter);

    }
}
