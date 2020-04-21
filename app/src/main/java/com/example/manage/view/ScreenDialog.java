package com.example.manage.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.aigestudio.wheelpicker.WheelPicker;
import com.example.manage.R;

import java.util.ArrayList;
import java.util.List;

public class ScreenDialog  extends Dialog {

    private ImageView image_close;
    private WheelPicker wheel_hour,wheel_min;

    private List<String> hourList =new ArrayList<>();//时间list
    private List<String> minList =new ArrayList<>();//分钟list
    public ScreenDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_screen);
        initViews();
        listener();
    }

    private void initViews() {
        image_close =findViewById(R.id.image_close);
        wheel_hour =findViewById(R.id.wheel_hour);
        wheel_min =findViewById(R.id.wheel_min);
    }


    private void listener() {

        for (int i = 0; i < 24; i++) {
            if (i<10){
                hourList.add("0"+i);
            }else {
                hourList.add(""+i);
            }

        }
        for (int i = 0; i < 60; i++) {
            if (i<10){
                minList.add("0"+i);
            }else {
                minList.add(""+i);
            }
        }
        wheel_hour.setData(hourList);
        wheel_min.setData(minList);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        wheel_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                Log.e("fhxx --->hour",data.toString()+"----"+position);
            }
        });

        wheel_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                Log.e("fhxx --->min",data.toString()+"----"+position);
            }
        });
    }

}
