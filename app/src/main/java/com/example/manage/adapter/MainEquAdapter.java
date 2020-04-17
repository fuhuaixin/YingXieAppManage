package com.example.manage.adapter;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.MainEquBean;

import java.util.List;

public class MainEquAdapter extends BaseQuickAdapter<MainEquBean, BaseViewHolder> {
    private Context mContext;

    public MainEquAdapter(int layoutResId, @Nullable List<MainEquBean> data, Context context) {
        super(layoutResId, data);
        this.mContext =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MainEquBean item) {
        helper.setText(R.id.tvMessage,item.getMsg());

        TextView view = helper.getView(R.id.tvMessage);
        if (item.getIsChoose()==1){
            view.setTextColor(mContext.getResources().getColor(R.color.light_blue));
            view.setBackgroundResource(R.drawable.shape_drawer_scence_sel);
        }else {
            view.setTextColor(mContext.getResources().getColor(R.color.tv66));
            view.setBackgroundResource(R.drawable.shape_drawer_scence);
        }
        helper.addOnClickListener(R.id.tvMessage);
    }
}
