package com.example.manage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.MainSceneBean;

import java.util.List;

public class MainSecneAdapter extends BaseQuickAdapter<MainSceneBean, BaseViewHolder> {

    private Context context;

    public MainSecneAdapter(int layoutResId, @Nullable List<MainSceneBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MainSceneBean item) {
        helper.setText(R.id.tvMessage, item.getMsg());
        TextView view = helper.getView(R.id.tvMessage);
        if (item.getIsTrue() == 1) {
            view.setTextColor(context.getResources().getColor(R.color.light_blue));
            view.setBackgroundResource(R.drawable.shape_drawer_scence_sel);
        } else {
            view.setTextColor(context.getResources().getColor(R.color.tv66));
            view.setBackgroundResource(R.drawable.shape_drawer_scence);
        }
        helper.addOnClickListener(R.id.tvMessage);
    }
}
