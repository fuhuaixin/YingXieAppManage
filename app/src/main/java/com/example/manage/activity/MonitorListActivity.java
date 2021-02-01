package com.example.manage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.MonitorListAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.base.BaseActivity;
import com.example.manage.bean.MonitorListBean;
import com.example.manage.bean.YingshiTokenBean;
import com.example.manage.utils.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;


public class MonitorListActivity extends BaseActivity {
    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_monitor;
    private MonitorListAdapter monitorListAdapter;
    private List<MonitorListBean> monitorListBeans = new ArrayList<>();
    MonitorListBean monitorListBean;
    private List<MonitorListBean.DataBean.AllVideoUrlBean> allVideoUrl = new ArrayList<>();
    private String token;

    @Override
    protected void onResume() {
        super.onResume();
        getToken();
        getMonitorList();//获取视频列表
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_list);
        dialog();
        zLoadingDialog.show();
        initViews();
        init();
    }

    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        recycle_monitor = findViewById(R.id.recycle_monitor);

    }

    private void init() {
        tvTitle.setText("监控");
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recycle_monitor.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void getMonitorList() {
        EasyHttp.get(AppUrl.VideoVideos)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        zLoadingDialog.dismiss();
                        ToastUtils.show("请求失败");
                    }

                    @Override
                    public void onSuccess(String s) {
                        monitorListBean = JSON.parseObject(s, MonitorListBean.class);
                        if (monitorListBean.isStatus()) {
                            allVideoUrl = monitorListBean.getData().getAllVideoUrl();

                            monitorListAdapter = new MonitorListAdapter(R.layout.item_monitor_list, allVideoUrl, MonitorListActivity.this);
                            recycle_monitor.setAdapter(monitorListAdapter);
                            monitorListAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                            monitorListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    switch (view.getId()) {
                                        case R.id.ll_item:
                                            String videourl = allVideoUrl.get(position).getVideourl();
                                            String videotype = allVideoUrl.get(position).getVideotype();
                                            if (videotype.equals("hknvr")) {
                                                if (videourl != null && !videourl.equals("")) {
                                                    Intent intent = new Intent(MonitorListActivity.this, MonitorActivity.class);
                                                    intent.putExtra("videoname", allVideoUrl.get(position).getVideoname());
                                                    intent.putExtra("videourl", videourl);
                                                    intent.putExtra("videoid", allVideoUrl.get(position).getVideoid());
                                                    intent.putExtra("historyurl", allVideoUrl.get(position).getHistoryurl());
                                                    startActivity(intent);
                                                } else {
                                                    ToastUtils.show("未获取到摄像头状态");
                                                }
                                            } else {
                                                Intent intent = new Intent(MonitorListActivity.this, EzOpenActivity.class);
                                                intent.putExtra("accesstoken", allVideoUrl.get(position).getAccesstoken());
//                                                intent.putExtra("accesstoken", token);
                                                intent.putExtra("videourl", allVideoUrl.get(position).getVideourl());
                                                startActivity(intent);

                                            }
                                            break;
                                    }
                                }
                            });
                            zLoadingDialog.dismiss();
                        }
                    }
                });
    }

    private void getToken(){
        EasyHttp.post("https://open.ys7.com/api/lapp/token/get")
                .params("appKey","2d34a04176844e5c986842dc6a8d5572")
                .params("appSecret","d7484b9b91b66b2ea5bada1ba07cbc97")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        YingshiTokenBean yingshiTokenBean = JSON.parseObject(s, YingshiTokenBean.class);
                        Log.e("yingshiToken",yingshiTokenBean.getCode()+ "---"+yingshiTokenBean.getData().getAccessToken());
                        token=yingshiTokenBean.getData().getAccessToken();
                    }
                });
    }
}
