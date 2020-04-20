package com.example.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.MonitorListAdapter;
import com.example.manage.bean.MonitorListBean;

import java.util.ArrayList;
import java.util.List;

public class MonitorListActivity extends AppCompatActivity {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_monitor;
    private MonitorListAdapter monitorListAdapter;
    private List<MonitorListBean> monitorListBeans =new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        initViews();
        init();
    }

    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        recycle_monitor =findViewById(R.id.recycle_monitor);

    }

    private void init() {
        tvTitle.setText("监控");
        for (int i = 0; i < 10; i++) {
            monitorListBeans.add(new MonitorListBean("http://img4.cache.netease.com/photo/0087/2009-10-20/5M1JB8B20P1J0087.jpg",
                    "黄焖鸡监控"+i));
        }
        recycle_monitor.setLayoutManager(new GridLayoutManager(this,2));
        monitorListAdapter =new MonitorListAdapter(R.layout.item_monitor_list,monitorListBeans,this);
        recycle_monitor.setAdapter(monitorListAdapter);
        monitorListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        Toast.makeText(MonitorListActivity.this, "点击"+position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
