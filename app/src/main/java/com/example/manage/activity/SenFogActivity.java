package com.example.manage.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aigestudio.wheelpicker.WheelPicker;
import com.alibaba.fastjson.JSON;
import com.example.manage.R;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.FogSettingBean;
import com.example.manage.bean.LightStatusBean;
import com.example.manage.bean.ScreenStatusBean;
import com.example.manage.utils.DateUtil;
import com.example.manage.utils.ToastUtils;
import com.example.manage.view.ChooseTimeDialog;
import com.example.manage.view.ScreenDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.PostRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * 森雾设备控制
 */
public class SenFogActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;
    private ImageView image_equ_switch, image_time_switch;
    private View view_shadow;
    private Button btn_commit;
    private CheckBox check_one, checkbox_two;
    private LinearLayout ll_one_start, ll_one_end;
    private LinearLayout ll_two_start, ll_two_end;
    private TextView tv_one_start, tv_one_end;
    private TextView tv_two_start, tv_two_end;


    private ScreenDialog screenDialog;
    private ChooseTimeDialog chooseTimeDialog;

    private int equSwitch = 0;
    private int timeSwitch = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen_fog);
        initViews();
        inits();
        getFogStatus(); //获取雾森状态
        FogSetting();//获取定时信息

    }

    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        image_equ_switch = findViewById(R.id.image_equ_switch);
        image_time_switch = findViewById(R.id.image_time_switch);
        view_shadow = findViewById(R.id.view_shadow);
        btn_commit = findViewById(R.id.btn_commit);
        check_one = findViewById(R.id.check_one);
        checkbox_two = findViewById(R.id.checkbox_two);
        ll_one_start = findViewById(R.id.ll_one_start);
        ll_one_end = findViewById(R.id.ll_one_end);
        tv_one_start = findViewById(R.id.tv_one_start);
        tv_one_end = findViewById(R.id.tv_one_end);
        ll_two_start = findViewById(R.id.ll_two_start);
        ll_two_end = findViewById(R.id.ll_two_end);
        tv_two_start = findViewById(R.id.tv_two_start);
        tv_two_end = findViewById(R.id.tv_two_end);


        imageBack.setOnClickListener(this);
        image_equ_switch.setOnClickListener(this);
        image_time_switch.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        ll_one_start.setOnClickListener(this);
        ll_one_end.setOnClickListener(this);
        check_one.setOnClickListener(this);
        checkbox_two.setOnClickListener(this);
        ll_two_start.setOnClickListener(this);
        ll_two_end.setOnClickListener(this);

    }

    private void inits() {
        tvTitle.setText("设备");
        screenDialog = new ScreenDialog(this, R.style.dialog);
        chooseTimeDialog = new ChooseTimeDialog(this, R.style.dialog);

        if (check_one.isChecked()) {
            ll_one_start.setClickable(true);
            ll_one_end.setClickable(true);
        } else {
            ll_one_start.setClickable(false);
            ll_one_end.setClickable(false);
        }
        if (checkbox_two.isChecked()) {
            ll_two_start.setClickable(true);
            ll_two_end.setClickable(true);
        } else {
            ll_two_start.setClickable(false);
            ll_two_end.setClickable(false);
        }
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
                timeSwitch();
                break;
            case R.id.ll_one_end:
                dialogSetting(2);
                break;
            case R.id.ll_one_start:
                dialogSetting(1);
                break;
            case R.id.check_one:
                firstCheck();
                break;
            case R.id.checkbox_two:
                secondCheck();
                break;
            case R.id.ll_two_end:
                dialogSetting(4);
                break;
            case R.id.ll_two_start:
                dialogSetting(3);
                break;
            case R.id.btn_commit:
                strNowHm= DateUtil.getCurDate("HH:mm");
                long stringToDate = DateUtil.getStringToDate(strNowHm, "HH:mm");//当前时间
                long oneStart = DateUtil.getStringToDate(tv_one_start.getText().toString(), "HH:mm");//第一开始
                long oneEnd = DateUtil.getStringToDate(tv_one_end.getText().toString(), "HH:mm");//第一end
                long twoStart = DateUtil.getStringToDate(tv_two_start.getText().toString(), "HH:mm");//第二开始
                long twoEnd = DateUtil.getStringToDate(tv_two_end.getText().toString(), "HH:mm");//第二end
                Log.e("fhxx",stringToDate+"--"+oneStart+"--"+oneEnd);

                if (timeSwitch == 1) {
                    isTimeSwitch = true;
                    if (check_one.isChecked()){
                        if (oneEnd<oneStart){
                            ToastUtils.show("第一时段：结束时间请大于开始时间");
                            break;
                        }
                    }
                   if (checkbox_two.isChecked()){
                       if (twoEnd<twoStart){
                           ToastUtils.show("第二时段：结束时间请大于开始时间");
                           break;
                       }
                   }

                } else if (timeSwitch == 2) {
                    isTimeSwitch = false;
                }
                SaveFogSetting(
                        "{ \"timingon\":" +
                                isTimeSwitch +
                                ", \"enableFirstSeg\":" +
                                check_one.isChecked() +
                                ", \"enableSecondSeg\":" +
                                checkbox_two.isChecked() +
                                ", \"firstSegOpenTime\":\"" +
                                tv_one_start.getText().toString() +
                                "\", \"firstSegEndTime\":\"" +
                                tv_one_end.getText().toString() +
                                "\", \"secondSegOpenTime\":\"" +
                                tv_two_start.getText().toString() +
                                "\", \"secondSegEndTime\":\"" +
                                tv_two_end.getText().toString() +
                                "\"}"
                );

                break;
        }
    }

    private Boolean isTimeSwitch;

    private void timeSwitch() {
        if (timeSwitch == 1) {
            image_time_switch.setImageResource(R.mipmap.icon_equ_close);
            view_shadow.setVisibility(View.VISIBLE);
            timeSwitch = 2;
        } else {
            image_time_switch.setImageResource(R.mipmap.icon_equ_open);
            view_shadow.setVisibility(View.GONE);
            timeSwitch = 1;
        }
    }

    private void firstCheck() {
        if (check_one.isChecked()) {
            ll_one_start.setClickable(true);
            ll_one_end.setClickable(true);
        } else {
            ll_one_start.setClickable(false);
            ll_one_end.setClickable(false);
        }
    }

    private void secondCheck() {
        if (checkbox_two.isChecked()) {
            ll_two_start.setClickable(true);
            ll_two_end.setClickable(true);
        } else {
            ll_two_start.setClickable(false);
            ll_two_end.setClickable(false);
        }
    }

    /**
     * 时间选择器弹窗
     */
    private String hourStr = "00", minStr = "00";
    String strNowHm;
    private void dialogSetting(final int type) {

        String hh = DateUtil.getCurDate("HH");



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
                    tv_one_start.setText(hourStr + ":" + minStr);
                } else if (type == 2) {
                    tv_one_end.setText(hourStr + ":" + minStr);
                } else if (type == 3) {
                    tv_two_start.setText(hourStr + ":" + minStr);
                } else if (type == 4) {
                    tv_two_end.setText(hourStr + ":" + minStr);
                }

            }
        });
        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                minStr = data.toString();
                if (type == 1) {
                    tv_one_start.setText(hourStr + ":" + minStr);
                } else if (type == 2) {
                    tv_one_end.setText(hourStr + ":" + minStr);
                } else if (type == 3) {
                    tv_two_start.setText(hourStr + ":" + minStr);
                } else if (type == 4) {
                    tv_two_end.setText(hourStr + ":" + minStr);
                }

            }
        });

    }


    /**
     * 确定按钮弹窗
     */
    private List<String> closeMin = new ArrayList<>();
    private String chooseMin = "0";
    private WheelPicker wheel_light_min;

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
        wheel_light_min.setItemTextSize(25);

        wheel_light_min.setData(closeMin);
        image_title.setImageResource(R.mipmap.icon_equ_switch);
        tv_title.setText("设备开关");
        tv_message.setVisibility(View.VISIBLE);
        if (type == 0) {
            wheel_light_min.setVisibility(View.VISIBLE);
            tv_message.setText("设置多少分钟后关闭");
        } else {
            wheel_light_min.setVisibility(View.GONE);
            tv_message.setText("确定关闭设备？");
        }
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FogControl(type, chooseMin);
            }
        });
        wheel_light_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                chooseMin = data.toString();
            }
        });
    }

    /**
     * 获取雾森设备状态
     */
    private void getFogStatus() {
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
     * 控制雾森关
     */

    private void FogControl(int type, String min) {
        PostRequest post = EasyHttp.post(AppUrl.FogsonControl);
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
     * 获取雾森定时配置
     */
    private void FogSetting() {
        EasyHttp.get(AppUrl.FogSetting)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        FogSettingBean fogSettingBean = JSON.parseObject(s, FogSettingBean.class);
                        if (fogSettingBean.isStatus()) {
                            FogSettingBean.DataBean data = fogSettingBean.getData();

                            if (data.isTimingon()) {
                                timeSwitch = 2;
                            } else {
                                timeSwitch = 1;
                            }
                            timeSwitch();

                            if (data.isEnableFirstSeg()) {
                                check_one.setChecked(true);
                            } else {
                                check_one.setChecked(false);
                            }
                            firstCheck();
                            if (data.isEnableSecondSeg()) {
                                checkbox_two.setChecked(true);
                            } else {
                                checkbox_two.setChecked(false);
                            }
                            secondCheck();
                            tv_one_start.setText(data.getFirstSegOpenTime());
                            tv_one_end.setText(data.getFirstSegEndTime());
                            tv_two_start.setText(data.getSecondSegOpenTime());
                            tv_two_end.setText(data.getSecondSegEndTime());

                        }

                    }
                });
    }


    /**
     * 发送雾森定时信息
     */
    private void SaveFogSetting(String setting) {
        EasyHttp.post(AppUrl.SaveFogSetting)
                .syncRequest(false)
                .timeStamp(true)
                .params("setting", setting)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        FogSettingBean fogSettingBean = JSON.parseObject(s, FogSettingBean.class);
                        if (fogSettingBean.isStatus()){
                            finish();
                        }else {
                            ToastUtils.show(fogSettingBean.getMessage());
                        }
                    }
                });
    }

}
