package com.wwwjf.demo.rxandroid;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wwwjf.demo.R;

import java.util.List;

/**
 * Created by wengjianfeng on 2018/9/4.
 */

public class AppInfoAdapter extends BaseQuickAdapter<AppInfoEntity,BaseViewHolder> {
    public AppInfoAdapter(@Nullable List<AppInfoEntity> data) {
        super(R.layout.item_appinfo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfoEntity item) {
        helper.setText(R.id.textView_rxAndroid,item.getmName());
        helper.setImageDrawable(R.id.imageView_rxAndroid,item.getmIcon());
    }
}
