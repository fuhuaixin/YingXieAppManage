package com.example.manage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.ApStatusBean;
import com.example.manage.bean.NetBean;

import java.util.List;

public class NetAdapter extends BaseQuickAdapter<ApStatusBean.DataBeanX.DataBean, BaseViewHolder> {

    public NetAdapter(int layoutResId, @Nullable List<ApStatusBean.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ApStatusBean.DataBeanX.DataBean item) {
        helper.setText(R.id.tv_state,"状态  "+(item.getStatus()==2?"离线":"在线"))
                .setText(R.id.tv_name,"名称  "+item.getName())
                .setText(R.id.tv_sn,"SN码  "+item.getSn())
                .setText(R.id.tv_ip,"IP码  "+item.getIp())
                .setText(R.id.tv_reception,"接收  "+item.getRecv())
                .setText(R.id.tv_join_time,"加入时间  "+item.getJoinTime())
                .setText(R.id.tv_send,"发送  "+item.getSend())
                .setText(R.id.tv_people,"连接人数  "+item.getUsercount());
    }
}
