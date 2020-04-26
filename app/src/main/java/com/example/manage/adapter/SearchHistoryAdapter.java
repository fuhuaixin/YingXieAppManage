package com.example.manage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;

import java.util.List;

public class SearchHistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public SearchHistoryAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_hot,item);

        helper.addOnClickListener(R.id.ll_item);
        helper.addOnLongClickListener(R.id.ll_item);
    }
}