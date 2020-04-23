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
import com.example.manage.adapter.MonitorAdapter;
import com.example.manage.bean.MonitorBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 监控直播界面
 */
public class MonitorActivity extends AppCompatActivity {

    private ImageView imageBack;
    private TextView tvTitle,tv_monitor_title;
    private RecyclerView recycle_monitor;

    private MonitorAdapter monitorAdapter;
    private List<MonitorBean> monitorBeanList =new ArrayList<>();

    private String strTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        initViews();
        inits();
    }

    private void initViews() {
        strTitle =getIntent().getStringExtra("title");
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        tv_monitor_title =findViewById(R.id.tv_monitor_title);
        recycle_monitor =findViewById(R.id.recycle_monitor);

    }

    private void inits(){
        tvTitle.setText("监控播放");
        tv_monitor_title.setText(strTitle);


        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i = 0; i < 8; i++) {
            monitorBeanList.add(new MonitorBean("time"+i,false));
        }

        recycle_monitor.setLayoutManager(new LinearLayoutManager(this));
        monitorAdapter=new MonitorAdapter(R.layout.item_monitor,monitorBeanList);
        recycle_monitor.setAdapter(monitorAdapter);

        monitorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        for (int i = 0; i < monitorBeanList.size(); i++) {
                            monitorBeanList.get(i).setChoose(false);
                        }
                        monitorBeanList.get(position).setChoose(true);
                        monitorAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

    }

}
