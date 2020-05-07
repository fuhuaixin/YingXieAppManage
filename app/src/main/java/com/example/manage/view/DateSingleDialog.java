package com.example.manage.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.manage.R;

public class DateSingleDialog extends Dialog implements View.OnClickListener {

    private ImageView image_back;
    private Button btn_choose;

    public DateSingleDialog(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_date_single);
        image_back =findViewById(R.id.image_back);
        btn_choose =findViewById(R.id.btn_choose);

        image_back.setOnClickListener(this);
        btn_choose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_choose:
            case R.id.image_back:
                dismiss();
                break;
        }
    }
}
