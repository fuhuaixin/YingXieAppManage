package com.example.manage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.manage.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle;
    private LinearLayout ll_equ_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        inits();
    }


    private void initViews() {
        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        ll_equ_list =findViewById(R.id.ll_equ_list);

        imageBack.setOnClickListener(this);
        ll_equ_list.setOnClickListener(this);
    }


    private void inits() {
        tvTitle.setText("设置");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.ll_equ_list:
                startActivity(new Intent(SettingActivity.this,EquipmentListActivity.class));
                break;
        }
    }
}
