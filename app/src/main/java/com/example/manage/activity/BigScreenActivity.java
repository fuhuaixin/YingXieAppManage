package com.example.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.BigScreenAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备交互大屏
 */
public class BigScreenActivity extends AppCompatActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_close;
    private BigScreenAdapter screenAdapter;
    private List<String> mList =new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_screen);
        initViews();
        init();
    }

    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        recycle_close =findViewById(R.id.recycle_close);
    }

    private void init() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvTitle.setText("设备");


        mList.add("硬件关机");
        mList.add("系统重启");
        mList.add("硬件重启");
        mList.add("定时开机");

        screenAdapter =new BigScreenAdapter(R.layout.item_screen_choose,mList);
        recycle_close.setLayoutManager(new GridLayoutManager(this,2));
        recycle_close.setAdapter(screenAdapter);
        screenAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case  R.id.ll_item:
                        Toast.makeText(BigScreenActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}
