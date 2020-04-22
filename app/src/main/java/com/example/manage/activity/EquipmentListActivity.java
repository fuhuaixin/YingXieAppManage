package com.example.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.EquListAdapter;
import com.example.manage.bean.EquListBean;

import java.util.ArrayList;
import java.util.List;

public class EquipmentListActivity extends AppCompatActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_equ_list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);
        initViews();
        inits();
        initData();
    }

    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        recycle_equ_list =findViewById(R.id.recycle_equ_list);
        recycle_equ_list.setLayoutManager(new LinearLayoutManager(this));

    }


    private void inits() {
        tvTitle.setText("设备列表");
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private List<EquListBean.ResultBean> resultBeans = new ArrayList<>();
    private List<EquListBean.ResultBean.ListBean> listBeans = new ArrayList<>();
    private List<EquListBean.ResultBean.ListBean> listBeanLast = new ArrayList<>();
    private EquListAdapter adapter ;
    private List<Boolean> stateList =new ArrayList<>();
    private void initData(){
        for (int i = 0; i < 5; i++) {
            listBeans.add(new EquListBean.ResultBean.ListBean("展开条目"+i));
        }
        listBeanLast.add(new EquListBean.ResultBean.ListBean("展开条目最后一条"));

        for (int i = 0; i < 10; i++) {
            resultBeans.add(new EquListBean.ResultBean(true,"title"+i,listBeans));
            stateList.add(true);
        }
        resultBeans.add(new EquListBean.ResultBean(true,"最后一条",listBeanLast));
        stateList.add(true);

        adapter=new EquListAdapter(R.layout.item_equ_list_header,resultBeans,this);
        recycle_equ_list.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        if (stateList.get(position)){
                            stateList.set(position,false);
                        }else {
                            stateList.set(position,true);
                        }
                        resultBeans.set(position,
                                new EquListBean.ResultBean(
                                        stateList.get(position),
                                        resultBeans.get(position).getTitle(),
                                        resultBeans.get(position).getList()));
                        adapter.notifyDataSetChanged();
                        Toast.makeText(EquipmentListActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
