package com.wwwjf.demo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wengjianfeng on 2018/8/21.
 */

public class ConstraintAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ConstraintAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_constraint, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView_constraint,item);
    }
}
