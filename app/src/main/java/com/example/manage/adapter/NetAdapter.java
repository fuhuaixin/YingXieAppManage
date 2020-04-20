package com.example.manage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.NetBean;

import java.util.List;

public class NetAdapter extends BaseQuickAdapter<NetBean, BaseViewHolder> {

    public NetAdapter(int layoutResId, @Nullable List<NetBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NetBean item) {
        helper.setText(R.id.tv_state,item.getState())
                .setText(R.id.tv_name,item.getName())
                .setText(R.id.tv_sn,item.getSn())
                .setText(R.id.tv_ip,item.getIp())
                .setText(R.id.tv_reception,item.getReception())
                .setText(R.id.tv_join_time,item.getJoinTime())
                .setText(R.id.tv_send,item.getSend())
                .setText(R.id.tv_people,item.getPeople());
    }
}
