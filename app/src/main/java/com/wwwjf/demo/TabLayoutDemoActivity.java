package com.wwwjf.demo;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TabLayoutDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout mTabLayout1, mTabLayout2, mTabLayout3;
    private boolean flag1,flag2,flag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_demo);
        mTabLayout1 = (TabLayout) findViewById(R.id.tabLayout1);
        mTabLayout1.addTab(mTabLayout1.newTab().setText("Tab0"));
        mTabLayout1.addTab(mTabLayout1.newTab().setText("Tab1"));
        mTabLayout1.addTab(mTabLayout1.newTab().setText("Tab2"));
        mTabLayout1.addTab(mTabLayout1.newTab().setText("Tab3"));
        mTabLayout1.addTab(mTabLayout1.newTab().setText("Tab4"));

        mTabLayout2 = (TabLayout) findViewById(R.id.tabLayout2);

        mTabLayout3 = (TabLayout) findViewById(R.id.tabLayout3);
        mTabLayout3.addTab(mTabLayout3.newTab().setCustomView(R.layout.tabitem_tab_layout));
        mTabLayout3.addTab(mTabLayout3.newTab().setCustomView(R.layout.tabitem_tab_layout));
        mTabLayout3.addTab(mTabLayout3.newTab().setCustomView(R.layout.tabitem_tab_layout));
        String[] text = {"text1", "text2", "text3"};
        for (int i = 0; i < 3; i++) {
            View customView = mTabLayout3.getTabAt(i).getCustomView();
            TextView textViewItem = (TextView) customView.findViewById(R.id.textView_tabItem);
            ImageView imageViewItem = (ImageView) customView.findViewById(R.id.imageView_tabItem);
            textViewItem.setText(text[i]);
            imageViewItem.setVisibility(View.INVISIBLE);
        }
        findViewById(R.id.button_tabItem1).setOnClickListener(this);
        findViewById(R.id.button_tabItem2).setOnClickListener(this);
        findViewById(R.id.button_tabItem3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_tabItem1:
                flag1 = !flag1;
                mTabLayout3.getTabAt(0).getCustomView().findViewById(R.id.imageView_tabItem).setVisibility(flag1?View.VISIBLE:View.INVISIBLE);
                break;
            case R.id.button_tabItem2:
                flag2 = !flag2;
                mTabLayout3.getTabAt(1).getCustomView().findViewById(R.id.imageView_tabItem).setVisibility(flag2?View.VISIBLE:View.INVISIBLE);
                break;
            case R.id.button_tabItem3:
                flag3 = !flag3;
                mTabLayout3.getTabAt(2).getCustomView().findViewById(R.id.imageView_tabItem).setVisibility(flag3?View.VISIBLE:View.INVISIBLE);
                break;
            default:
                break;
        }
    }
}
