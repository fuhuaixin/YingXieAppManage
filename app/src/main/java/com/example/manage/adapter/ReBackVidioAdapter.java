package com.example.manage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.ReBackVidioListBean;

import java.util.List;

public class ReBackVidioAdapter extends BaseQuickAdapter<ReBackVidioListBean.DataBean, BaseViewHolder> {

    public ReBackVidioAdapter(int layoutResId, @Nullable List<ReBackVidioListBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReBackVidioListBean.DataBean item) {
        helper.setText(R.id.tv_name, item.getStartTime() + "-" + item.getEndTime());
        helper.addOnClickListener(R.id.ll_item);
    }
}
