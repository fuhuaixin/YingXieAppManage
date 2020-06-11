package com.example.manage.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.widgets.WheelDatePicker;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.BigScreenAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.ScreenStatusBean;
import com.example.manage.utils.DateUtil;
import com.example.manage.utils.ToastUtils;
import com.example.manage.view.ScreenDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 设备交互大屏
 */
public class BigScreenActivity extends AppCompatActivity {

    private ImageView imageBack;
    private TextView tvTitle;
    private RecyclerView recycle_close;
    private BigScreenAdapter screenAdapter;
    private List<String> mList = new ArrayList<>();
    private ScreenDialog screenDialog;
    private TextView tv_equ_open, tv_equ_close;

    private WheelPicker wheel_hour, wheel_min;
    private WheelDatePicker wheel_date;
    private LinearLayout ll_wheel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_screen);
        initViews();
        init();

        getScreenStatus();//获取大屏状态
    }

    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        recycle_close = findViewById(R.id.recycle_close);
        tv_equ_open = findViewById(R.id.tv_equ_open);
        tv_equ_close = findViewById(R.id.tv_equ_close);
    }

    private void init() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvTitle.setText("设备");
        screenDialog = new ScreenDialog(this, R.style.dialog);

        mList.add("硬件关机");
        mList.add("系统重启");
        mList.add("硬件重启");
        mList.add("定时开机");

        screenAdapter = new BigScreenAdapter(R.layout.item_screen_choose, mList);
        recycle_close.setLayoutManager(new GridLayoutManager(this, 2));
        recycle_close.setAdapter(screenAdapter);
        screenAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {


            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                switch (view.getId()) {
                    case R.id.ll_item:
                        screenDialog.show();
                        ImageView imageTitle = screenDialog.findViewById(R.id.image_title);
                        TextView tvTitle = screenDialog.findViewById(R.id.tv_title);
                        TextView tvMessage = screenDialog.findViewById(R.id.tv_message);
                        Button btnSure = screenDialog.findViewById(R.id.btn_sure);
                        wheel_hour = screenDialog.findViewById(R.id.wheel_hour);
                        wheel_min = screenDialog.findViewById(R.id.wheel_min);
                        wheel_date = screenDialog.findViewById(R.id.wheel_date);
                        ll_wheel = screenDialog.findViewById(R.id.ll_wheel);
                        ll_wheel.setVisibility(View.GONE);
                        wheel_date.setItemTextSize(40);
                        wheel_hour.setItemTextSize(40);
                        wheel_min.setItemTextSize(40);
                        dataLiean();
                        if (position == 0) {
                            imageTitle.setImageResource(R.mipmap.icon_hand_dia_close);
                            tvTitle.setText("硬件关机");
                            tvMessage.setText("关机后只能通过重新插拔电源/开机按键等方式开机");
                        } else if (position == 1) {
                            imageTitle.setImageResource(R.mipmap.icon_dia_sys_reset);
                            tvTitle.setText("系统重启");
                            tvMessage.setText("系统热复位重启");
                        } else if (position == 2) {
                            imageTitle.setImageResource(R.mipmap.icon_dia_hand_reset);
                            tvTitle.setText("硬件重启");
                            tvMessage.setText("断电约一分钟后重新上电开机");
                        } else if (position == 3) {
                            imageTitle.setImageResource(R.mipmap.icon_dia_close_time);
                            tvTitle.setText("定时开机");
                            tvMessage.setText("关机之后自动开机");
                            ll_wheel.setVisibility(View.VISIBLE);
                        }

                        btnSure.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (position == 0) {
                                    ScreenShutDown("1111111111");
                                } else if (position == 1) {
                                    ScreenReBoot("1111111111");
                                } else if (position == 2) {
                                    HardReBoot("1111111111");
                                } else if (position == 3) {
                                    ScreenAlarm("1111111111", strDate + " " + strHour + ":" + strMin + ":" + "00");
                                    Log.e("fhxx", strDate + strHour + strMin);
                                    Log.e("fhxx", strDate + strHour + strMin);
//                                    Toast.makeText(BigScreenActivity.this, strDate+strHour+strMin, Toast.LENGTH_SHORT).show();
                                }
                                screenDialog.dismiss();

                            }
                        });
                        break;
                }
            }
        });

    }

    /**
     * 时间选择器监听
     */
    private String strHour = "00", strMin = "00", strDate = "2000";

    private void dataLiean() {
        wheel_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                strHour = data.toString();
            }
        });
        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                strMin = data.toString();
            }
        });
        wheel_date.setOnDateSelectedListener(new WheelDatePicker.OnDateSelectedListener() {
            @Override
            public void onDateSelected(WheelDatePicker picker, Date date) {
                strDate = DateUtil.getDateToString(date.getTime(), "yyyy-MM-dd");
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
                        if (screenStatusBean.isStatus()) {
                            if (screenStatusBean.getData().equals("true")) {
                                tv_equ_open.setVisibility(View.VISIBLE);
                                tv_equ_close.setVisibility(View.GONE);
                            } else {
                                tv_equ_open.setVisibility(View.GONE);
                                tv_equ_close.setVisibility(View.VISIBLE);
                            }

                        }
                    }
                });
    }

    /**
     * 硬件关机
     */
    private void ScreenShutDown(String deviceName) {
        EasyHttp.get(AppUrl.ScreenHardShutdown)
                .timeStamp(true)
                .syncRequest(false)
                .params("deviceName", deviceName)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        if (screenStatusBean.isStatus()) {
                            ToastUtils.show(screenStatusBean.getMessage());
                        }
                    }
                });
    }


    /**
     * 系统重启
     */
    private void ScreenReBoot(String deviceName) {
        EasyHttp.get(AppUrl.ScreenSoftReBoot)
                .timeStamp(true)
                .syncRequest(false)
                .params("deviceName", deviceName)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        if (screenStatusBean.isStatus()) {
                            ToastUtils.show(screenStatusBean.getMessage());
                        }
                    }
                });
    }

    /**
     * 硬件重启
     */
    private void HardReBoot(String deviceName) {
        EasyHttp.get(AppUrl.ScreenHardReBoot)
                .timeStamp(true)
                .syncRequest(false)
                .params("deviceName", deviceName)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        if (screenStatusBean.isStatus()) {
                            ToastUtils.show(screenStatusBean.getMessage());
                        }
                    }
                });
    }

    /**
     * 关机并定时开机
     */

    private void ScreenAlarm(String deviceName, String dateTime) {
        EasyHttp.get(AppUrl.ScreenAlarm)
                .timeStamp(true)
                .syncRequest(false)
                .params("deviceName", deviceName)
                .params("dateTime", dateTime)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        if (screenStatusBean.isStatus()) {
                            ToastUtils.show(screenStatusBean.getMessage());
                        }
                    }
                });
    }

}
