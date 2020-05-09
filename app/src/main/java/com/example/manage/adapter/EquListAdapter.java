package com.example.manage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;
import com.example.manage.bean.EquListBean;

import java.util.List;

/**
 * 设备列表，可展开界面
 */
public class EquListAdapter extends BaseQuickAdapter<EquListBean.ResultBean, BaseViewHolder> {


    private Context context;

    public EquListAdapter(int layoutResId, @Nullable List<EquListBean.ResultBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final EquListBean.ResultBean item) {
        helper.setText(R.id.tv_header, item.getTitle());
        ImageView tvState = helper.getView(R.id.tv_state);
        LinearLayout ll_item_item = helper.getView(R.id.ll_item_item);
        RecyclerView recycle_item = helper.getView(R.id.recycle_item);

        recycle_item.setLayoutManager(new LinearLayoutManager(context));
        EquListItemAdapter equListItemAdapter = new EquListItemAdapter(R.layout.item_equ_list_item, item.getList());
        recycle_item.setAdapter(equListItemAdapter);
        if (item.getState()) {
            tvState.setImageResource(R.mipmap.icon_item_down);
            ll_item_item.setVisibility(View.GONE);
        } else {
            tvState.setImageResource(R.mipmap.icon_item_up);
            ll_item_item.setVisibility(View.VISIBLE);
        }
        helper.addOnClickListener(R.id.ll_item);

        equListItemAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_item_item:
                        break;
                }

            }
        });
    }
}
