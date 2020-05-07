package com.example.manage.adapter;

import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.EquListBean;
import com.example.manage.bean.ReBackVidioBean;

import java.util.List;

public class ReBackVidioAdapter extends BaseQuickAdapter<ReBackVidioBean.DataBean, BaseViewHolder> {

    public ReBackVidioAdapter(int layoutResId, @Nullable List<ReBackVidioBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReBackVidioBean.DataBean item) {
        helper.setText(R.id.tv_name,item.getStartTime()+"-"+item.getEndTime());
    }
}
