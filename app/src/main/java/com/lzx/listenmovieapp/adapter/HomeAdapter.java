package com.lzx.listenmovieapp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzx.listenmovieapp.R;
import com.lzx.listenmovieapp.bean.HomeItem;

import java.util.List;

/**
 * Author：Road
 * Date  ：2018/4/26
 */

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    public HomeAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.tv_item, item.getTitle());
        helper.setImageResource(R.id.iv_item, item.getResId());
    }
}
