package com.example.manage.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.EquListAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.base.BaseActivity;
import com.example.manage.bean.DeviceStatusBean;
import com.example.manage.bean.EquListBean;
import com.example.manage.utils.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备列表
 */
public class EquipmentListActivity extends BaseActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_equ_list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);
        initViews();
        inits();
        getState();//获取设备状态
        dialog();
        zLoadingDialog.show();
    }

    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        recycle_equ_list = findViewById(R.id.recycle_equ_list);
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
    private List<EquListBean.ResultBean.ListBean> listBean1 = new ArrayList<>();
    private List<EquListBean.ResultBean.ListBean> listBean2 = new ArrayList<>();
    private List<EquListBean.ResultBean.ListBean> listBean4 = new ArrayList<>();
    private List<EquListBean.ResultBean.ListBean> listBean5 = new ArrayList<>();
    private EquListAdapter adapter;
    private List<Boolean> stateList = new ArrayList<>();

    private void initData() {

        adapter = new EquListAdapter(R.layout.item_equ_list_header, resultBeans, this);
        recycle_equ_list.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_item:
                        if (stateList.get(position)) {
                            stateList.set(position, false);
                        } else {
                            stateList.set(position, true);
                        }
                        resultBeans.set(position,
                                new EquListBean.ResultBean(
                                        stateList.get(position),
                                        resultBeans.get(position).getTitle(),
                                        resultBeans.get(position).getTitleStatus(),
                                        resultBeans.get(position).getList()));
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
    }

    /**
     * 获取设备列表状态
     */

    private void getState() {
        EasyHttp.get(AppUrl.DeviceStatus)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        zLoadingDialog.dismiss();
                        ToastUtils.show("网络请求错误");
                    }

                    @Override
                    public void onSuccess(String s) {
                        DeviceStatusBean deviceStatusBean = JSON.parseObject(s, DeviceStatusBean.class);
                        if (deviceStatusBean.isStatus()) {
                            DeviceStatusBean.DataBeanX data = deviceStatusBean.getData();
                            DeviceStatusBean.DataBeanX.ApInfoBean apInfo = deviceStatusBean.getData().getApInfo();
                            for (int i = 0; i < apInfo.getData().size(); i++) {
                                listBean1.add(new EquListBean.ResultBean.ListBean(apInfo.getData().get(i).getName(), apInfo.getData().get(i).getStatus()));
                            }
                            List<DeviceStatusBean.DataBeanX.CameraListBean> cameraList = deviceStatusBean.getData().getCameraList();
                            for (int i = 0; i < cameraList.size(); i++) {
                                listBean2.add(new EquListBean.ResultBean.ListBean(cameraList.get(i).getName(), cameraList.get(i).getStatus()));
                            }
                            DeviceStatusBean.DataBeanX.FogStatusBean fogStatus = deviceStatusBean.getData().getFogStatus();
                            listBean4.add(new EquListBean.ResultBean.ListBean(fogStatus.getRealyName(), fogStatus.getStatus()));
                            DeviceStatusBean.DataBeanX.LightStatusBean lightStatus = deviceStatusBean.getData().getLightStatus();
                            listBean5.add(new EquListBean.ResultBean.ListBean(lightStatus.getRealyName(), lightStatus.getStatus()));
                            resultBeans.add(new EquListBean.ResultBean(true, "警报",data.isAlarmStatus(), null));
                            resultBeans.add(new EquListBean.ResultBean(true, "无线网络",null, listBean1));
                            resultBeans.add(new EquListBean.ResultBean(true, "安防监控",null, listBean2));
                            resultBeans.add(new EquListBean.ResultBean(true, "环境监测", data.isEnvMonitor(),null));
                            resultBeans.add(new EquListBean.ResultBean(true, "智能雾森", null,listBean4));
                            resultBeans.add(new EquListBean.ResultBean(true, "灯光互动", null,listBean5));
                            resultBeans.add(new EquListBean.ResultBean(true, "广告大屏", data.isScreenStatus(),null));
                            for (int i = 0; i < 7; i++) {
                                stateList.add(true);
                            }
                            /*stateList.add(0,deviceStatusBean.getData().isAlarmStatus());
                            stateList.add(3,deviceStatusBean.getData().isEnvMonitor());
                            stateList.add(6,deviceStatusBean.getData().isScreenStatus());*/

                            zLoadingDialog.dismiss();
                            initData();
                        }
                    }
                });

    }

}
