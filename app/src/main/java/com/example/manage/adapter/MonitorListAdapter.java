package com.example.manage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.MonitorListBean;

import java.util.List;

public class MonitorListAdapter extends BaseQuickAdapter<MonitorListBean.DataBean.AllVideoUrlBean, BaseViewHolder> {

    private Context context;
    public MonitorListAdapter(int layoutResId, @Nullable List<MonitorListBean.DataBean.AllVideoUrlBean> data,Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MonitorListBean.DataBean.AllVideoUrlBean item) {
        helper.setText(R.id.tv_title,item.getVideoname());
        ImageView image_mes = helper.getView(R.id.image_mes);
//        Glide.with(context).load(item.getImage()).into(image_mes);


        helper.addOnClickListener(R.id.ll_item);
    }
}
