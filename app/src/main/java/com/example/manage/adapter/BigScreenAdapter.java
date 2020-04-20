package com.example.manage.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.manage.R;

import java.util.List;

public class BigScreenAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BigScreenAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView image_title = helper.getView(R.id.image_title);
        TextView tv_message = helper.getView(R.id.tv_message);
        RelativeLayout rl_item = helper.getView(R.id.rl_item);
        helper.setText(R.id.tv_message,item);
        switch (helper.getPosition()){
            case 0:
                image_title.setImageResource(R.mipmap.icon_hand_close);
                rl_item.setBackgroundResource(R.drawable.ic_screen_lan);
                break;
            case 1:
                image_title.setImageResource(R.mipmap.icon_sys_reset);
                rl_item.setBackgroundResource(R.drawable.ic_screen_huang);
                break;
            case 2:
                image_title.setImageResource(R.mipmap.icon_hand_reset);
                rl_item.setBackgroundResource(R.drawable.ic_screen_fen);
                break;
            case 3:
                image_title.setImageResource(R.mipmap.icon_hand_time);
                rl_item.setBackgroundResource(R.drawable.ic_screen_lv);
                break;
        }


        helper.addOnClickListener(R.id.ll_item);
    }
}
