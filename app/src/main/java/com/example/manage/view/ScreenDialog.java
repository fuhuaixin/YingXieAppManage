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
import com.aigestudio.wheelpicker.widgets.WheelDatePicker;
import com.example.manage.R;

import java.util.ArrayList;
import java.util.List;

public class ScreenDialog  extends Dialog {

    private ImageView image_close;
    private WheelPicker wheel_hour,wheel_min;
    private WheelDatePicker wheel_date;

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
        wheel_date =findViewById(R.id.wheel_date);
    }


    private void listener() {
/*
                app:wheel_item_align="center"
                app:wheel_item_text_color="@color/tv9B"
                app:wheel_item_text_size="16sp"
                app:wheel_selected_item_text_color="@color/tv21"
                app:wheel_visible_item_count="3"*/
        wheel_date.setVisibleItemCount(3);
        wheel_date.setItemTextSize(25);
        wheel_hour.setItemTextSize(25);
        wheel_min.setItemTextSize(25);
        wheel_date.setItemTextColor(getContext().getResources().getColor(R.color.tv9B));
        wheel_date.setSelectedItemTextColor(getContext().getResources().getColor(R.color.tv21));
        wheel_date.setYearStart(2020);

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
