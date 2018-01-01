package com.wwwjf.demo.elestickheader;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wwwjf.demo.R;

import java.util.List;

/**
 * Created by wwwjf on 2017/12/24.
 *
 * @author wwwjf
 */

public class CommonAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public CommonAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView,item);
    }
}
