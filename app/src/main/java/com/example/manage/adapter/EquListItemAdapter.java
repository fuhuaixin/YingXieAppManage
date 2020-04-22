package com.example.manage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.EquListBean;

import java.util.List;

public class EquListItemAdapter extends BaseQuickAdapter<EquListBean.ResultBean.ListBean, BaseViewHolder> {

    public EquListItemAdapter(int layoutResId, @Nullable List<EquListBean.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EquListBean.ResultBean.ListBean item) {
        helper.setText(R.id.tv_item_title,item.getMessage());
        helper.addOnClickListener(R.id.ll_item_item);
    }
}
