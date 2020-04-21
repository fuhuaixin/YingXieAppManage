package com.example.manage.activity;

import android.os.Bundle;
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
import com.example.manage.R;
import com.example.manage.view.ChooseTimeDialog;
import com.example.manage.view.ScreenDialog;

/**
 * 灯光设备 设置
 */
public class LightingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle;
    private ImageView image_equ_switch,image_time_switch;
    private Button btn_commit;
    private TextView tv_start,tv_end;
    private TextView tv_start_time,tv_end_time;

    private ChooseTimeDialog chooseTimeDialog;
    private ScreenDialog screenDialog;
    private int equSwitch =2;
    private int timeSwitch =2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighting);
        initViews();
        init();
    }

    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        image_equ_switch =findViewById(R.id.image_equ_switch);
        image_time_switch =findViewById(R.id.image_time_switch);
        btn_commit =findViewById(R.id.btn_commit);
        tv_start =findViewById(R.id.tv_start);
        tv_end =findViewById(R.id.tv_end);
        tv_start_time =findViewById(R.id.tv_start_time);
        tv_end_time =findViewById(R.id.tv_end_time);


        imageBack.setOnClickListener(this);
        image_equ_switch.setOnClickListener(this);
        image_time_switch.setOnClickListener(this);
        btn_commit.setOnClickListener(this);
        tv_start_time.setOnClickListener(this);
        tv_end_time.setOnClickListener(this);
    }

    private void init() {
        tvTitle.setText("设备");
        chooseTimeDialog =new ChooseTimeDialog(this,R.style.dialog);
        screenDialog =new ScreenDialog(this,R.style.dialog);

        tv_start_time.setClickable(false);
        tv_end_time.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back :
                finish();
                break;
            case R.id.image_equ_switch:
                if (equSwitch==1){
                    image_equ_switch.setImageResource(R.mipmap.icon_equ_close);
                    equSwitch=2;
                }else{
                    scDialogSetting();

                }
                break;
            case R.id.image_time_switch:
                if (timeSwitch==1){
                    image_time_switch.setImageResource(R.mipmap.icon_equ_close);
                    tv_start.setTextColor(getResources().getColor(R.color.tvB2));
                    tv_end.setTextColor(getResources().getColor(R.color.tvB2));
                    tv_start_time.setTextColor(getResources().getColor(R.color.tvB2));
                    tv_end_time.setTextColor(getResources().getColor(R.color.tvB2));
                    tv_start_time.setClickable(false);
                    tv_end_time.setClickable(false);
                    btn_commit.setVisibility(View.GONE);
                    timeSwitch=2;
                }else{
                    image_time_switch.setImageResource(R.mipmap.icon_equ_open);
                    tv_start.setTextColor(getResources().getColor(R.color.tv21));
                    tv_end.setTextColor(getResources().getColor(R.color.tv21));
                    tv_start_time.setTextColor(getResources().getColor(R.color.tv21));
                    tv_end_time.setTextColor(getResources().getColor(R.color.tv21));
                    tv_start_time.setClickable(true);
                    tv_end_time.setClickable(true);
                    btn_commit.setVisibility(View.VISIBLE);
                    timeSwitch=1;
                }
                break;
            case R.id.btn_commit:
                Toast.makeText(this, tv_start_time.getText().toString()+"---"+tv_end_time.getText().toString(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_end_time:
                dialogSetting(2);
//                Toast.makeText(this, "可以点击end", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_start_time:
//                chooseTimeDialog.show();
                dialogSetting(1);
//                tv_start_time.setText(chooseTimeDialog.getHour()+":"+chooseTimeDialog.getMin()+"  >");
                break;

        }
    }

    private String hourStr="00",minStr="00";
    private void dialogSetting(final int type){
        chooseTimeDialog.show();

        Window window = chooseTimeDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        chooseTimeDialog.getWindow().setAttributes(lp);

        WheelPicker wheel_hour =chooseTimeDialog.findViewById(R.id.wheel_hour);
        WheelPicker wheel_min =chooseTimeDialog.findViewById(R.id.wheel_min);
        wheel_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                hourStr=data.toString();
                if (type==1){
                    tv_start_time.setText(hourStr+":"+minStr);
                }else if (type==2){
                    tv_end_time.setText(hourStr+":"+minStr);
                }

            }
        });
        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                minStr=data.toString();
                if (type==1){
                    tv_start_time.setText(hourStr+":"+minStr);
                }else if (type==2){
                    tv_end_time.setText(hourStr+":"+minStr);
                }

            }
        });

    }

    private void scDialogSetting(){
        screenDialog.show();
        ImageView image_title =screenDialog.findViewById(R.id.image_title);
        TextView tv_title =screenDialog.findViewById(R.id.tv_title);
        TextView tv_message =screenDialog.findViewById(R.id.tv_message);
        Button btn_sure =screenDialog.findViewById(R.id.btn_sure);
        image_title.setImageResource(R.mipmap.icon_equ_switch);
        tv_title.setText("设备开关");
        tv_message.setVisibility(View.GONE);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_equ_switch.setImageResource(R.mipmap.icon_equ_open);
                equSwitch=1;
                screenDialog.dismiss();
            }
        });

    }
}
