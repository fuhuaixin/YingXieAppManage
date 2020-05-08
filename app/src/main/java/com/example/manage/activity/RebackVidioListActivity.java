package com.example.manage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.ReBackVidioAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.base.BaseActivity;
import com.example.manage.bean.ReBackVidioListBean;
import com.example.manage.utils.DateUtil;
import com.example.manage.utils.ToastUtils;
import com.example.manage.view.DateSingleDialog;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

/**
 * 回放列表
 */
public class RebackVidioListActivity  extends BaseActivity implements View.OnClickListener{

    private TextView tvTitle,tv_today,tv_choose_data;
    private ImageView imageBack;
    private RecyclerView recycle_reback;
    private ReBackVidioAdapter reBackVidioAdapter;
    private String backId;
    private DateSingleDialog singleDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidio_reback);
        dialog();
        zLoadingDialog.show();
        backId =getIntent().getStringExtra("backId");
        initViews();
        initData();
        getVidio(backId, DateUtil.getCurDate("yyyy-MM-dd"));
    }

    private void initViews() {
        tvTitle =findViewById(R.id.tv_title);
        imageBack =findViewById(R.id.image_back);
        recycle_reback =findViewById(R.id.recycle_reback);
        tv_today =findViewById(R.id.tv_today);
        tv_choose_data =findViewById(R.id.tv_choose_data);

        imageBack.setOnClickListener(this);
        tv_today.setOnClickListener(this);
        tv_choose_data.setOnClickListener(this);
    }

    private void initData(){
        tvTitle.setText("回放列表");

        recycle_reback.setLayoutManager(new LinearLayoutManager(this));
        singleDialog =new DateSingleDialog(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_today:
                getVidio(backId, DateUtil.getCurDate("yyyy-MM-dd"));
                break;
            case R.id.image_back:
                finish();
                break;
            case R.id.tv_choose_data:
                singleDialog.show();
                Window window = singleDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.CENTER;
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                singleDialog.getWindow().setAttributes(lp);

                CalendarView calendarView =singleDialog.findViewById(R.id.calendarView);
                calendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
                    @Override
                    public void onCalendarOutOfRange(Calendar calendar) {

                    }

                    @Override
                    public void onCalendarSelect(Calendar calendar, boolean isClick) {
                        getVidio(backId,calendar.getYear()+"-"+calendar.getMonth()+"-"+calendar.getDay());
                    }
                });

                break;

        }
    }

    /**
     * 获取回放列表
     * @param id
     * @param data
     */
    private void getVidio(final String id, String data){
        EasyHttp.get(AppUrl.HistoryDatesDetial)
                .params("videoId",id)
                .params("time",data)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        zLoadingDialog.dismiss();
                        ToastUtils.show("请求失败");
                    }

                    @Override
                    public void onSuccess(String s) {
                        final ReBackVidioListBean reBackVidioListBean = JSON.parseObject(s, ReBackVidioListBean.class);
                        zLoadingDialog.dismiss();
                        if (reBackVidioListBean.isStatus()&&reBackVidioListBean.getData()!=null){
                            final List<ReBackVidioListBean.DataBean> data1 = reBackVidioListBean.getData();
                            reBackVidioAdapter =new ReBackVidioAdapter(R.layout.item_reback_vidio, data1);
                            recycle_reback.setAdapter(reBackVidioAdapter);
                            reBackVidioAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    switch (view.getId()){
                                        case R.id.ll_item:
                                            Intent intent = new Intent(RebackVidioListActivity.this,ReBackVidioActivity.class);
                                            intent.putExtra("videoId",backId);
                                            intent.putExtra("startTime",data1.get(position).getStartTime());
                                            intent.putExtra("endTime",data1.get(position).getEndTime());
                                            startActivity(intent);
                                            break;
                                    }
                                }
                            });
                        }else {
                            ToastUtils.show("列表请求失败，请稍后再试");
                        }
                    }
                });
    }

}
