package com.example.manage.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.aigestudio.wheelpicker.WheelPicker;
import com.example.manage.R;

import java.util.ArrayList;
import java.util.List;

public class ChooseTimeDialog extends Dialog {
    private Context context;
    private WheelPicker wheel_hour, wheel_min;
    private Button btnChoose;
    private ImageView image_back;

    private List<String> hourList = new ArrayList<>();
    private List<String> minList = new ArrayList<>();

    private String hourStr = "00";
    private String minStr = "00";

    public ChooseTimeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_time_choose);
        initViews();
        inits();
    }

    private void initViews() {
        wheel_hour = findViewById(R.id.wheel_hour);
        wheel_min = findViewById(R.id.wheel_min);
        btnChoose = findViewById(R.id.btn_choose);
        image_back = findViewById(R.id.image_back);
    }

    private void inits() {

        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                hourList.add("0" + i);
            } else {
                hourList.add(i + "");
            }
        }


        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                minList.add("0" + i);
            } else {
                minList.add("" + i);
            }
        }

        wheel_hour.setData(hourList);
        wheel_min.setData(minList);

        wheel_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                hourStr = data.toString();
            }
        });
        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                minStr = data.toString();
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
