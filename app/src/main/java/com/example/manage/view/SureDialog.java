package com.example.manage.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.manage.R;

public class SureDialog extends Dialog {

    private TextView tvTitle,tvMessage;
    private Context context;
    private String strTitle;
    private Boolean showTitle;
    private String strMessage;
    private Boolean showMessage;
    public SureDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context =context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sure);
        initViews();
        initData();
    }

    private void initViews() {

        tvTitle =findViewById(R.id.dialog_general_title);
        tvMessage =findViewById(R.id.dialog_general_content);


    }


    private void initData() {
//        tvTitle.setText(strTitle);
       /* if (showTitle){
            tvTitle.setVisibility(View.VISIBLE);
        }else {
            tvTitle.setVisibility(View.GONE);
        }*/

       /* tvMessage.setText(strMessage);
        if (showMessage){
            tvMessage.setVisibility(View.VISIBLE);
        }else {
            tvMessage.setVisibility(View.GONE);
        }*/
    }


   /* public void setTitle(String title,Boolean isShow){
        this.strTitle =title;
        this.showTitle =isShow;
    }

    public  void setMessage(String message,Boolean isShow){
        this.strMessage =message;
        this.showMessage =isShow;
    }*/

}
