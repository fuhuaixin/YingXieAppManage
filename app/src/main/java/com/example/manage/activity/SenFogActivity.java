package com.example.manage.activity;

import android.os.Bundle;
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
import com.example.manage.R;
import com.example.manage.view.ChooseTimeDialog;
import com.example.manage.view.ScreenDialog;

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

    private int equSwitch = 2;
    private int timeSwitch = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen_fog);
        initViews();
        inits();
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
                if (equSwitch == 1) {
                    image_equ_switch.setImageResource(R.mipmap.icon_equ_close);
                    equSwitch = 2;
                } else {
                    scDialogSetting();
                }
                break;
            case R.id.image_time_switch:
                if (timeSwitch == 1) {
                    image_time_switch.setImageResource(R.mipmap.icon_equ_close);
                    view_shadow.setVisibility(View.VISIBLE);
                    btn_commit.setVisibility(View.GONE);
                    timeSwitch = 2;
                } else {
                    image_time_switch.setImageResource(R.mipmap.icon_equ_open);
                    view_shadow.setVisibility(View.GONE);
                    btn_commit.setVisibility(View.VISIBLE);
                    timeSwitch = 1;
                }
                break;
            case R.id.ll_one_end:
                dialogSetting(2);
                break;
            case R.id.ll_one_start:
                dialogSetting(1);
                break;
            case R.id.check_one:
                if (check_one.isChecked()) {
                    ll_one_start.setClickable(true);
                    ll_one_end.setClickable(true);
                } else {
                    ll_one_start.setClickable(false);
                    ll_one_end.setClickable(false);
                }
                break;
            case R.id.checkbox_two:
                if (checkbox_two.isChecked()) {
                    ll_two_start.setClickable(true);
                    ll_two_end.setClickable(true);
                } else {
                    ll_two_start.setClickable(false);
                    ll_two_end.setClickable(false);
                }
                break;
            case R.id.ll_two_end:
                dialogSetting(4);
                break;
            case R.id.ll_two_start:
                dialogSetting(3);
                break;
            case R.id.btn_commit:
                Toast.makeText(this, "第一时间段，开始--》" + tv_one_start.getText()
                        + "结束---》" + tv_one_end.getText() + "第二时间段，开始--》"
                        + tv_two_start.getText() + "结束--》" + tv_two_end.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**
     * 时间选择器弹窗
     */
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
    private void scDialogSetting() {
        screenDialog.show();
        ImageView image_title = screenDialog.findViewById(R.id.image_title);
        TextView tv_title = screenDialog.findViewById(R.id.tv_title);
        TextView tv_message = screenDialog.findViewById(R.id.tv_message);
        Button btn_sure = screenDialog.findViewById(R.id.btn_sure);
        image_title.setImageResource(R.mipmap.icon_equ_switch);
        tv_title.setText("设备开关");
        tv_message.setVisibility(View.GONE);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_equ_switch.setImageResource(R.mipmap.icon_equ_open);
                equSwitch = 1;
                screenDialog.dismiss();
            }
        });

    }
}
