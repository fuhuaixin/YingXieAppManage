package com.example.manage.adapter;

import android.widget.TextView;

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
        TextView tv_statue = helper.getView(R.id.tv_statue);
        if (item.getStatus()==1){
            tv_statue.setText("正常");
        }else {
            tv_statue.setText("异常");
        }
        helper.addOnClickListener(R.id.ll_item_item);
    }
}
