package com.example.manage.activity;

import android.content.Intent;
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

import com.example.manage.MainActivity;
import com.example.manage.R;
import com.example.manage.utils.SPUtils;

/**
 *登录页
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login; //登录
    private EditText et_user,et_password; //账号密码
    private TextView tv_user_null,tv_pass_null;
    private LinearLayout ll_user,ll_password;
    private CheckBox checkbox;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        init();
    }

    private void initViews() {
        btn_login =findViewById(R.id.btn_login);
        et_user =findViewById(R.id.et_user);
        et_password =findViewById(R.id.et_password);
        tv_user_null =findViewById(R.id.tv_user_null);
        tv_pass_null =findViewById(R.id.tv_pass_null);
        ll_user =findViewById(R.id.ll_user);
        ll_password =findViewById(R.id.ll_password);
        checkbox =findViewById(R.id.checkbox);

        btn_login.setOnClickListener(this);
    }

    private void init() {
        String login_user = SPUtils.getString(this, "login_user");
        String login_pass = SPUtils.getString(this, "login_pass");
        String ischeck = SPUtils.getString(this, "ischeck");
        Log.e("fhxx",login_user +"------"+login_pass);
        et_user.setText(login_user);

        if (ischeck.equals("check")){
            checkbox.setChecked(true);
            et_password.setText(login_pass);
        }else {
            checkbox.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                toLogin();
                break;
        }
    }

    private void toLogin(){
        if (et_user.getText().toString().equals("")){
            tv_user_null.setVisibility(View.VISIBLE);
            ll_user.setBackgroundResource(R.drawable.shape_login_null_bg);
        }else if (et_password.getText().toString().equals("")){
            tv_pass_null.setVisibility(View.VISIBLE);
            ll_password.setBackgroundResource(R.drawable.shape_login_null_bg);
        } else {
            tv_user_null.setVisibility(View.GONE);
            tv_pass_null.setVisibility(View.GONE);
            ll_user.setBackgroundResource(R.drawable.shape_login_ll_bg);
            ll_password.setBackgroundResource(R.drawable.shape_login_ll_bg);
            
            if (et_user.getText().toString().equals("123456")&&et_password.getText().toString().equals("1234")){
                SPUtils.putString(this,"login_user",et_user.getText().toString());
                if (checkbox.isChecked()){
                    SPUtils.putString(this,"login_pass",et_password.getText().toString());
                    SPUtils.putString(this,"ischeck","check");
                }else {
                    SPUtils.putString(this,"login_pass","");
                    SPUtils.putString(this,"ischeck","unCheck");
                }
                finish();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }else {
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();   
            }
            
        }
    }
}