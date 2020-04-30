package com.example.manage.activity;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aigestudio.wheelpicker.WheelPicker;
import com.alibaba.fastjson.JSON;
import com.example.manage.R;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.LightSettingBean;
import com.example.manage.bean.LightStatusBean;
import com.example.manage.bean.ScreenStatusBean;
import com.example.manage.utils.ToastUtils;
import com.example.manage.view.ChooseDateDialog;
import com.example.manage.view.ChooseTimeDialog;
import com.example.manage.view.ScreenDialog;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.GetRequest;
import com.zhouyou.http.request.PostRequest;
import com.zhouyou.http.subsciber.BaseSubscriber;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


/**
 * 灯光设备 设置
 */
public class LightingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle;
    private ImageView image_equ_switch, image_time_switch;
    private Button btn_commit;
    private TextView tv_start, tv_end;
    private TextView tv_start_time, tv_end_time, tv_date_list;

    private ChooseTimeDialog chooseTimeDialog;
    private ScreenDialog screenDialog;
    private int equSwitch = 0; //0是关 1 是开
    private int timeSwitch = 0;
    private WheelPicker wheel_light_min;
    private CalendarView calendarView;
    private ChooseDateDialog chooseDateDialog; //

    private List<String> daysList = new ArrayList<>(); //用来存储选中的日期
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighting);
        initViews();
        init();
        getLightStatus();//获取设备状态
        LightSetting();//获取定时状态
    }

    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        image_equ_switch = findViewById(R.id.image_equ_switch);
        image_time_switch = findViewById(R.id.image_time_switch);
        btn_commit = findViewById(R.id.btn_commit);
        tv_start = findViewById(R.id.tv_start);
        tv_end = findViewById(R.id.tv_end);
        tv_start_time = findViewById(R.id.tv_start_time);
        tv_end_time = findViewById(R.id.tv_end_time);
        tv_date_list = findViewById(R.id.tv_date_list);
        calendarView = findViewById(R.id.calendarView);


        imageBack.setOnClickListener(this);
        image_equ_switch.setOnClickListener(this);
        image_time_switch.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        tv_start_time.setOnClickListener(this);
        tv_end_time.setOnClickListener(this);
        tv_date_list.setOnClickListener(this);
    }

    private void init() {
        tvTitle.setText("设备");
        chooseTimeDialog = new ChooseTimeDialog(this, R.style.dialog);
        screenDialog = new ScreenDialog(this, R.style.dialog);
        chooseDateDialog = new ChooseDateDialog(this, R.style.dialog);
        calendarView.setOnCalendarMultiSelectListener(new CalendarView.OnCalendarMultiSelectListener() {
            @Override
            public void onCalendarMultiSelectOutOfRange(Calendar calendar) {
                Log.e("Calendar", calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.getDay());
            }

            @Override
            public void onMultiSelectOutOfSize(Calendar calendar, int maxSize) {

            }

            @Override
            public void onCalendarMultiSelect(Calendar calendar, int curSize, int maxSize) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.image_equ_switch:
                if (equSwitch == 0) {
                    scDialogSetting(0);
                } else {
                    scDialogSetting(1);
                }
                break;
            case R.id.image_time_switch:
                if (timeSwitch == 0) {
                    image_time_switch.setImageResource(R.mipmap.icon_equ_open);
                    timeSwitch = 1;
                } else if (timeSwitch == 1) {
                    image_time_switch.setImageResource(R.mipmap.icon_equ_close);
                    timeSwitch = 0;
                }
                break;
            case R.id.btn_commit:
                saveSetting();
                break;
            case R.id.tv_end_time:
                dialogSetting(2);

                break;
            case R.id.tv_start_time:
                dialogSetting(1);

                break;
            case R.id.tv_date_list:
                dateDialogSet();
                break;

        }
    }

    private String hourStr = "00", minStr = "00";

    private void dialogSetting(final int type) {
        chooseTimeDialog.show();

        Window window = chooseTimeDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        chooseTimeDialog.getWindow().setAttributes(lp);

        WheelPicker wheel_hour = chooseTimeDialog.findViewById(R.id.wheel_hour);
        WheelPicker wheel_min = chooseTimeDialog.findViewById(R.id.wheel_min);
        wheel_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                hourStr = data.toString();
                if (type == 1) {
                    tv_start_time.setText(hourStr + ":" + minStr);
                } else if (type == 2) {
                    tv_end_time.setText(hourStr + ":" + minStr);
                }

            }
        });
        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                minStr = data.toString();
                if (type == 1) {
                    tv_start_time.setText(hourStr + ":" + minStr);
                } else if (type == 2) {
                    tv_end_time.setText(hourStr + ":" + minStr);
                }

            }
        });

    }

    private List<String> closeMin = new ArrayList<>();
    private String chooseMin = "0";

    private void scDialogSetting(final int type) {
        closeMin.add("0");
        closeMin.add("10");
        closeMin.add("30");
        closeMin.add("60");
        closeMin.add("90");
        closeMin.add("120");
        closeMin.add("180");
        closeMin.add("240");
        closeMin.add("300");

        screenDialog.show();
        ImageView image_title = screenDialog.findViewById(R.id.image_title);
        TextView tv_title = screenDialog.findViewById(R.id.tv_title);
        TextView tv_message = screenDialog.findViewById(R.id.tv_message);
        Button btn_sure = screenDialog.findViewById(R.id.btn_sure);
        wheel_light_min = screenDialog.findViewById(R.id.wheel_light_min);
        image_title.setImageResource(R.mipmap.icon_equ_switch);

        wheel_light_min.setItemTextSize(25);

        wheel_light_min.setData(closeMin);
        tv_message.setVisibility(View.VISIBLE);
        if (type == 0) {
            wheel_light_min.setVisibility(View.VISIBLE);

            tv_message.setText("设置多少分钟后关闭");
        } else {
            wheel_light_min.setVisibility(View.GONE);
            tv_message.setText("确定关闭设备？");
        }
        tv_title.setText("设备开关");

        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LightControl(type, chooseMin);
            }
        });
        wheel_light_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                chooseMin = data.toString();
            }
        });
    }

    private void dateDialogSet() {
        chooseDateDialog.show();
        Window window = chooseDateDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        chooseDateDialog.getWindow().setAttributes(lp);

        final CalendarView mCalendarView = chooseDateDialog.findViewById(R.id.calendarView);
        for (int i = 0; i < daysList.size(); i++) {
            mCalendarView.putMultiSelect(getSchemeCalendar(daysList.get(i)));
        }

        mCalendarView.setOnCalendarMultiSelectListener(new CalendarView.OnCalendarMultiSelectListener() {
            @Override
            public void onCalendarMultiSelectOutOfRange(Calendar calendar) {

            }

            @Override
            public void onMultiSelectOutOfSize(Calendar calendar, int maxSize) {

            }

            @Override
            public void onCalendarMultiSelect(Calendar calendar, int curSize, int maxSize) {
                if (daysList.contains(calendar.getYear() +
                        "-" + calendar.getMonth() +
                        "-" + calendar.getDay())) {
                    daysList.remove(calendar.getYear() +
                            "-" + calendar.getMonth() +
                            "-" + calendar.getDay());
                } else {
                    daysList.add(calendar.getYear() +
                            "-" + calendar.getMonth() +
                            "-" + calendar.getDay());
                }
                tv_date_list.setText(daysList.toString());
                Log.e("fhxx", daysList.toString());
            }
        });

        mCalendarView.setOnCalendarInterceptListener(new CalendarView.OnCalendarInterceptListener() {
            @Override
            public boolean onCalendarIntercept(Calendar calendar) {
                return calendar.getYear() <= mCalendarView.getCurYear() &&
                        calendar.getMonth() <= mCalendarView.getCurMonth() &&
                        calendar.getDay() < mCalendarView.getCurDay();
            }

            @Override
            public void onCalendarInterceptClick(Calendar calendar, boolean isClick) {
                Toast.makeText(LightingActivity.this,
                        calendar.toString() + (isClick ? "拦截不可点击" : "拦截设定为无效日期"),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private Calendar getSchemeCalendar(String data) {
        Log.e("fhxx -->data", data);
        String[] strs = data.split("-");
        Calendar calendar = new Calendar();
        calendar.setYear(Integer.valueOf(strs[0]));
        calendar.setMonth(Integer.valueOf(strs[1]));
        calendar.setDay(Integer.valueOf(strs[2]));
//        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
//        calendar.setScheme(text);
//        calendar.addScheme(new Calendar.Scheme());
//        calendar.addScheme(0xFF008800, "假");
//        calendar.addScheme(0xFF008800, "节");
        return calendar;
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
                        if (lightStatusBean.isStatus()) {
                            if (lightStatusBean.getData().getStatus() == 0) {
                                image_equ_switch.setImageResource(R.mipmap.icon_equ_open);
                                equSwitch = 1;
                            } else if (lightStatusBean.getData().getStatus() == 1) {
                                image_equ_switch.setImageResource(R.mipmap.icon_equ_close);
                                equSwitch = 0;
                            }
                        }
                    }
                });
    }

    /**
     * 控制灯光开关
     */

    private void LightControl(int type, String min) {
        PostRequest post = EasyHttp.post(AppUrl.LightControl);
        if (type == 0) {
            post.params("opt", "0");
            if (!min.equals("0")) {
                post.params("expireTime", min);
            }
        } else if (type == 1) {
            post.params("opt", "1");
        }
        post.timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ScreenStatusBean screenStatusBean = JSON.parseObject(s, ScreenStatusBean.class);
                        if (screenStatusBean.isStatus()) {
                            screenDialog.dismiss();
                            if (equSwitch == 0) {
                                image_equ_switch.setImageResource(R.mipmap.icon_equ_open);
                                equSwitch = 1;
                            } else {
                                image_equ_switch.setImageResource(R.mipmap.icon_equ_close);
                                equSwitch = 0;
                            }
                        }

                    }
                });
    }

    /**
     * 互动灯光设备定时配置
     * LightSetting
     */
    private void LightSetting() {
        EasyHttp.get(AppUrl.LightSetting)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        LightSettingBean lightSettingBean = JSON.parseObject(s, LightSettingBean.class);
                        if (lightSettingBean.isStatus()) {
                            if (lightSettingBean.getData().isTimingon()) {
                                timeSwitch = 1;
                                daysList.clear();
                                for (int i = 0; i < lightSettingBean.getData().getDays().size(); i++) {
                                    daysList.add(lightSettingBean.getData().getDays().get(i));
                                }

                                image_time_switch.setImageResource(R.mipmap.icon_equ_open);
                                tv_date_list.setText(lightSettingBean.getData().getDays().toString());
                                tv_start_time.setText(lightSettingBean.getData().getOpenTime());
                                tv_end_time.setText(lightSettingBean.getData().getEndTime());
                            } else {
                                timeSwitch = 0;
                                image_time_switch.setImageResource(R.mipmap.icon_equ_close);
                            }
                        }
                    }
                });
    }

    /**
     * 设置互动灯光定时任务
     */



    private void saveSetting() {
        String dayLsit = "";
        for (int i = 0; i < daysList.size(); i++) {
            if (i != daysList.size() - 1) {
                dayLsit = dayLsit + "'" + daysList.get(i) + "',";
            } else {
                dayLsit = dayLsit + "'" + daysList.get(i) + "'";
            }
        }

        Log.e("fhxx", dayLsit);
        EasyHttp.post(AppUrl.LightSaveSetting)
                .syncRequest(false)
                .timeStamp(true)
                .params("setting",
                        "{timingon:" + (timeSwitch == 0 ? false : true)
                                + ",days:[" + dayLsit + "],openTime:'" + tv_start_time.getText().toString()
                                + "',endTime:'" +
                                tv_end_time.getText().toString() +
                                "'}")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("fhxx error", e.toString());
                        ToastUtils.show("提交失败");
                    }

                    @Override
                    public void onSuccess(String s) {
                        ToastUtils.show("提交成功");
                        finish();
                    }
                });
    }

}
