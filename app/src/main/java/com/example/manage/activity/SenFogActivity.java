package com.example.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.manage.R;
import com.example.manage.view.ScreenDialog;

/**
 * 森雾设备控制
 */
public class SenFogActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageBack;
    private TextView tvTitle;

    private ImageView image_equ_switch, image_time_switch;
    private ScreenDialog screenDialog;

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


        imageBack.setOnClickListener(this);
        image_equ_switch.setOnClickListener(this);
        image_time_switch.setOnClickListener(this);
    }

    private void inits() {
        tvTitle.setText("设备");
        screenDialog = new ScreenDialog(this, R.style.dialog);
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
                    timeSwitch = 2;
                } else {
                    image_time_switch.setImageResource(R.mipmap.icon_equ_open);
                    timeSwitch = 1;
                }


                break;
        }
    }

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
