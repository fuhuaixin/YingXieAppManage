package com.example.manage.base;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

public class BaseActivity extends AppCompatActivity {

    public ZLoadingDialog zLoadingDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    /**
     * dialog相关
     */
    public void dialog() {
        zLoadingDialog =new  ZLoadingDialog(this);
        zLoadingDialog.setLoadingBuilder(Z_TYPE.CIRCLE_CLOCK)
                .setLoadingColor(Color.parseColor("#eeeeee"))
                .setHintText("加载中...")
                .setHintTextSize(14F)
                .setHintTextColor(Color.parseColor("#eeeeee"))
                .setDialogBackgroundColor(Color.parseColor("#CC111111"))
                .setDurationTime(1.3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (zLoadingDialog != null) {
            zLoadingDialog.dismiss();
        }
    }
}
