package com.example.manage.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.MonitorBean;

import java.util.List;

public class MonitorAdapter extends BaseQuickAdapter<MonitorBean, BaseViewHolder> {

    public MonitorAdapter(int layoutResId, @Nullable List<MonitorBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MonitorBean item) {

        helper.setText(R.id.tv_time, item.getTime());

        ImageView imageStart = helper.getView(R.id.image_start);

        if (item.getChoose()) {
            imageStart.setImageResource(R.mipmap.icon_monitor_ing);
        } else {
            imageStart.setImageResource(R.mipmap.icon_monitor_start);
        }

        helper.addOnClickListener(R.id.ll_item);

    }
}
