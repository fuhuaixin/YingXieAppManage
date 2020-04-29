package com.example.manage.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.example.manage.MainActivity;
import com.example.manage.R;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.LoginBean;
import com.example.manage.http.HttpManager;
import com.example.manage.utils.SPUtils;
import com.example.manage.utils.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.ApiResult;
import com.zhouyou.http.subsciber.BaseSubscriber;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * 登录页
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login; //登录
    private EditText et_user, et_password; //账号密码
    private TextView tv_user_null, tv_pass_null;
    private LinearLayout ll_user, ll_password;
    private CheckBox checkbox;
    LoginBean loginBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        init();
        GetPermission();
    }

    private void initViews() {
        btn_login = findViewById(R.id.btn_login);
        et_user = findViewById(R.id.et_user);
        et_password = findViewById(R.id.et_password);
        tv_user_null = findViewById(R.id.tv_user_null);
        tv_pass_null = findViewById(R.id.tv_pass_null);
        ll_user = findViewById(R.id.ll_user);
        ll_password = findViewById(R.id.ll_password);
        checkbox = findViewById(R.id.checkbox);

        btn_login.setOnClickListener(this);
    }

    private void init() {
        String login_user = SPUtils.getString(this, "login_user");
        String login_pass = SPUtils.getString(this, "login_pass");
        String ischeck = SPUtils.getString(this, "ischeck");
        Log.e("fhxx", login_user + "------" + login_pass);
        et_user.setText(login_user);

        if (ischeck.equals("check")) {
            checkbox.setChecked(true);
            et_password.setText(login_pass);
        } else {
            checkbox.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                toLogin();
                break;
        }
    }

    private void toLogin() {
        if (et_user.getText().toString().equals("")) {
            tv_user_null.setVisibility(View.VISIBLE);
            ll_user.setBackgroundResource(R.drawable.shape_login_null_bg);
        } else if (et_password.getText().toString().equals("")) {
            tv_pass_null.setVisibility(View.VISIBLE);
            ll_password.setBackgroundResource(R.drawable.shape_login_null_bg);
        } else {
            tv_user_null.setVisibility(View.GONE);
            tv_pass_null.setVisibility(View.GONE);
            ll_user.setBackgroundResource(R.drawable.shape_login_ll_bg);
            ll_password.setBackgroundResource(R.drawable.shape_login_ll_bg);
            ToLogin();

        }
    }


    private void GetPermission() {
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
//            mLocationClient.start();// 定位SDK
//            Toast.makeText(LoginActivity.this, "已开启定位权限", Toast.LENGTH_LONG).show();
        }
    }

    private void ToLogin() {
        EasyHttp.get(AppUrl.Login)
                .timeStamp(true)
                .syncRequest(false)
                .params("username", et_user.getText().toString())
                .params("password", et_password.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("fhxx",s);
                        loginBean = JSON.parseObject(s, LoginBean.class);

                        if (loginBean.isStatus()){
                            SPUtils.putString(LoginActivity.this,"login_user",et_user.getText().toString());
                            if (checkbox.isChecked()){
                                SPUtils.putString(LoginActivity.this,"login_pass",et_password.getText().toString());
                                SPUtils.putString(LoginActivity.this,"ischeck","check");
                            }else {
                                SPUtils.putString(LoginActivity.this,"login_pass","");
                                SPUtils.putString(LoginActivity.this,"ischeck","unCheck");
                            }

                            finish();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }else {
                            ToastUtils.show(loginBean.getMessage());
                        }
                    }
                });

    }

    private void post(){
        EasyHttp.post(AppUrl.controlLight)
                .timeStamp(true)
                .syncRequest(false)
                .params("opt","0")
                .params("expireTime","1")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("fhxx",s);
                    }
                });
    }

}
