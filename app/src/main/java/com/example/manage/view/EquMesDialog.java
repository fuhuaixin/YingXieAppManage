package com.example.manage.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.activity.BigScreenActivity;
import com.example.manage.activity.LightingActivity;
import com.example.manage.activity.MonitorActivity;
import com.example.manage.activity.MonitorListActivity;
import com.example.manage.activity.SenFogActivity;
import com.example.manage.adapter.MonitorListAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.ApStatusBean;
import com.example.manage.bean.ChannlInfoBean;
import com.example.manage.bean.GMBean;
import com.example.manage.bean.LightStatusBean;
import com.example.manage.bean.MonitorListBean;
import com.example.manage.bean.ScreenStatusBean;
import com.example.manage.bean.TrushLastestBean;
import com.example.manage.utils.ToastUtils;
import com.google.gson.JsonArray;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;


public class EquMesDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private TextView tv_title;
    private TextView tv_one, tv_two, tv_three, tv_four_title, tv_four;

    private String type = "";
    private String title = "";
    private Boolean equStatus = false;

    public EquMesDialog(@NonNull Context context) {
        super(context, R.style.equDialog);
        this.mContext = context;
    }

    public void SetMessage(String type, String title) {
        this.type = type;
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_equ_message);

        initViews();
        initDate();

    }

    private void initViews() {
        tv_title = findViewById(R.id.tv_title);
        tv_one = findViewById(R.id.tv_one);
        tv_two = findViewById(R.id.tv_two);
        tv_three = findViewById(R.id.tv_three);
        tv_four = findViewById(R.id.tv_four);
        tv_four_title = findViewById(R.id.tv_four_title);

    }

    private void initDate() {
        if (type.equals("spray")) {
            tv_title.setText("智能喷灌");
            tv_one.setText("安装日期:2019年10月11日");
            sprayMessage();
            tv_three.setVisibility(View.GONE);
            tv_four.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
            tv_four.getPaint().setAntiAlias(true);//抗锯齿
            tv_four.setText("设备管控");
            tv_four_title.setText("操作:");
            tv_four.setTextColor(mContext.getResources().getColor(R.color.light_blue));
            tv_four.setOnClickListener(this);
        } else if (type.equals("garbage")) {
            getRubash();
        } else if (type.equals("wifi")) {
            ApStatus();
        }else if (type.equals("fire")){
            tv_title.setText("智能消防栓");
            tv_one.setText("安装日期:2019年10月11日");
            tv_four_title.setText("设备状态:");
            tv_four.setText("正常");
            tv_two.setVisibility(View.GONE);
            tv_three.setVisibility(View.GONE);
        }else if (type.equals("light")){
            getLightStatus();
            tv_four.setOnClickListener(this);
        }else if (type.equals("screen")){
            getScreenStatus();
            tv_four.setOnClickListener(this);
        }else if (type.equals("camera")){
            Chanelinfo();
            tv_four.setOnClickListener(this);
        }else if (type.equals("env")){
            EnvStatus();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_four:
                if (type.equals("spray")) {
                    dismiss();
                    mContext.startActivity(new Intent(mContext, SenFogActivity.class));
                }else if (type.equals("light")){
                    dismiss();
                    mContext.startActivity(new Intent(mContext, LightingActivity.class));
                }else if (type.equals("screen")){
                    dismiss();
                    mContext.startActivity(new Intent(mContext, BigScreenActivity.class));
                }else if (type.equals("camera")){
                    getMonitorList();
                }
                break;
        }
    }

    /**
     * 雾森状态查询
     */
    private void sprayMessage() {
        EasyHttp.get(AppUrl.FogStatus)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        LightStatusBean lightStatusBean = JSON.parseObject(s, LightStatusBean.class);
                        if (lightStatusBean.isStatus()) {
                            tv_two.setText("设备状态：正常");
                        } else {
                            tv_two.setText("设备状态：离线");
                        }

                    }
                });
    }

    /**
     * 垃圾桶查询
     */
    private void getRubash() {
        EasyHttp.get(AppUrl.TrushLatestData)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        TrushLastestBean trushLastestBean = JSON.parseObject(s, TrushLastestBean.class);
                        if (trushLastestBean.isStatus()) {
                            tv_title.setText("智能垃圾桶");
                            tv_one.setText("安装日期:2019年10月11日");
                            tv_two.setText("设备编号:" + title);
                            tv_four_title.setText("设备状态:");
                            tv_four.setText("正常");
                            List<TrushLastestBean.DataBean.ListBean> list = trushLastestBean.getData().getList();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getEid() == Integer.valueOf(title)) {
                                    tv_three.setText("当前回收量：" + (list.get(i).getOveralam() * 100) + "%");
                                }
                            }
                        }
                    }
                });
    }
    /**
     * 获取无线网ap列表和状态
     */
    ApStatusBean apStatusBean;
    List<ApStatusBean.DataBeanX.DataBean> data1 = new ArrayList<>();

    private void ApStatus() {
        EasyHttp.get(AppUrl.ApStatus)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        apStatusBean = JSON.parseObject(s, ApStatusBean.class);
                        tv_title.setText("共享wifi");
                        tv_one.setText("安装日期:2019年10月11日");

                        if (apStatusBean.isStatus()) {
                            data1 = apStatusBean.getData().getData();
                            for (int i = 0; i < data1.size(); i++) {
                                if (title.equals(data1.get(i).getName())){
                                    tv_two.setText("接入点名称："+data1.get(i).getName());
                                    tv_three.setText("连接人数："+data1.get(i).getConnection());
                                    tv_four_title.setText("设备状态:");
                                    if (data1.get(i).getStatus()==1){
                                        tv_four.setText("正常");
                                    }else {
                                        tv_four.setText("离线");
                                    }
                                }
                            }
                        }
                    }
                });
    }


    /**
     * 获取灯光设备状态
     */
    private void getLightStatus() {
        EasyHttp.get(AppUrl.LightStatus)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }
                    @Override
                    public void onSuccess(String s) {
                        LightStatusBean lightStatusBean = JSON.parseObject(s, LightStatusBean.class);
                        tv_title.setText("灯光互动系统");
                        tv_one.setText("安装日期:2019年10月11日");
                        tv_four.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
                        tv_four.getPaint().setAntiAlias(true);//抗锯齿
                        tv_four.setText("设备管控");
                        tv_four_title.setText("操作:");
                        tv_four.setTextColor(mContext.getResources().getColor(R.color.light_blue));

                        if (lightStatusBean.isStatus()) {
                            tv_three.setText("设备状态:正常");
                            tv_two.setText("设备名称:"+lightStatusBean.getData().getRealyName());
                        }else {
                            tv_three.setText("设备状态:离线");
                        }
                    }
                });
    }

    /**
     * 大屏状态
     */
    private void getScreenStatus() {
        EasyHttp.get(AppUrl.ScreenStatus)
                .timeStamp(true)
                .syncRequest(false)
                .params("deviceName", "1111111111")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        tv_title.setText("室外智能交互屏");
                        tv_one.setText("安装日期:2019年10月11日");
                        tv_three.setVisibility(View.GONE);
                        tv_four.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
                        tv_four.getPaint().setAntiAlias(true);//抗锯齿
                        tv_four.setText("设备管控");
                        tv_four_title.setText("操作:");
                        tv_four.setTextColor(mContext.getResources().getColor(R.color.light_blue));
                        if (screenStatusBean.isStatus()) {
                            tv_two.setText("设备状态:正常");
                        }else {
                            tv_two.setText("设备状态:离线");
                        }
                    }
                });
    }

    /**
     * 查询查询视频在线状态
     */

    private void Chanelinfo(){
        EasyHttp.get(AppUrl.Chanelinfo)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }
                    @Override
                    public void onSuccess(String s) {
                        List<ChannlInfoBean> channlInfoBeans = JSON.parseArray(s, ChannlInfoBean.class);
                        tv_title.setText("智能视频摄像头");
                        tv_one.setText("安装日期：2019年10月11日");
                        for (int i = 0; i < channlInfoBeans.size(); i++) {
                            if (title.equals(channlInfoBeans.get(i).getName())){
                                tv_two.setText("摄像头名称："+channlInfoBeans.get(i).getName());
                                tv_three.setText("设备状态："+((channlInfoBeans.get(i).getStatus()==1)?"正常":"离线"));
                                tv_four.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
                                tv_four.getPaint().setAntiAlias(true);//抗锯齿
                                tv_four.setText("查看视频");
                                tv_four_title.setText("操作:");
                                tv_four.setTextColor(mContext.getResources().getColor(R.color.light_blue));
                               
                            }
                        }
                    }
                });
    }

    private void getMonitorList() {
        EasyHttp.get(AppUrl.VideoVideos)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        MonitorListBean monitorListBean = JSON.parseObject(s, MonitorListBean.class);
                        if (monitorListBean.isStatus()){
                            List<MonitorListBean.DataBean.AllVideoUrlBean> allVideoUrl = monitorListBean.getData().getAllVideoUrl();
                            for (int i = 0; i < allVideoUrl.size(); i++) {
                                Log.e("fhxx",title+ allVideoUrl.get(i).getVideoname());
                                Log.e("fhxx",title.equals(allVideoUrl.get(i).getVideoname())+" ------ " );
                                if (title.equals(allVideoUrl.get(i).getIdname())){
                                    if (allVideoUrl.get(i).getVideourl().equals("")){
                                        ToastUtils.show("设备异常");
                                        return;
                                    }
                                    Intent intent = new Intent(mContext, MonitorActivity.class);
                                    intent.putExtra("videoname", allVideoUrl.get(i).getVideoname());
                                    intent.putExtra("videourl", allVideoUrl.get(i).getVideourl());
                                    intent.putExtra("videoid", allVideoUrl.get(i).getVideoid());
                                    mContext.startActivity(intent);
                                    dismiss();
                                }
                            }
                        }

                    }
                });
    }

    /**
     *查询环境监测设备在线状态
     */
    private void EnvStatus(){
        EasyHttp.get(AppUrl.EnvStatus)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        tv_title.setText("智能环境监测");
                        tv_one.setText("安装日期：2019年10月11日");
                        tv_three.setVisibility(View.GONE);
                        tv_four.setVisibility(View.GONE);
                        tv_four_title.setVisibility(View.GONE);
                        GMBean gmBean = JSON.parseObject(s, GMBean.class);
                        if (gmBean.getData().toString().equals("true")){
                            tv_two.setText("设备状态：正常");
                        }else {
                            tv_two.setText("设备状态：离线");
                        }

                    }
                });
    }

}
