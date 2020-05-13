package com.example.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.NetAdapter;
import com.example.manage.bean.ApStatusBean;
import com.example.manage.bean.NetBean;
import com.example.manage.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.utils.Log;

/**
 * 网络activity
 */
public class NetActivity extends AppCompatActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private NetAdapter netAdapter;
    private RecyclerView recycle_net;

    private ApStatusBean apStatusBean;
    private List<ApStatusBean.DataBeanX.DataBean> mList =new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        apStatusBean = (ApStatusBean) getIntent().getSerializableExtra("apStatusBean");
        mList =apStatusBean.getData().getData();
        initViews();
        init();
    }


    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        recycle_net =findViewById(R.id.recycle_net);

    }

    private void init() {
        tvTitle.setText("网络");
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recycle_net.setLayoutManager(new LinearLayoutManager(this));

        netAdapter = new NetAdapter(R.layout.item_net,mList);
        netAdapter.isFirstOnly(false);
        netAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recycle_net.setAdapter(netAdapter);
    }

}
