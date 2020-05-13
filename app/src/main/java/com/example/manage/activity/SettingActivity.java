package com.example.manage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.example.manage.R;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.GMBean;
import com.example.manage.utils.PackageUtils;
import com.example.manage.utils.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import constant.UiType;
import listener.OnInitUiListener;
import listener.UpdateDownloadListener;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageBack;
    private TextView tvTitle, tv_logout;
    private LinearLayout ll_equ_list, ll_check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        inits();
    }


    private void initViews() {
        imageBack = findViewById(R.id.image_back);
        tvTitle = findViewById(R.id.tv_title);
        ll_equ_list = findViewById(R.id.ll_equ_list);
        tv_logout = findViewById(R.id.tv_logout);
        ll_check = findViewById(R.id.ll_check);

        imageBack.setOnClickListener(this);
        ll_equ_list.setOnClickListener(this);
        tv_logout.setOnClickListener(this);
        ll_check.setOnClickListener(this);
    }


    private void inits() {
        tvTitle.setText("设置");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.ll_equ_list:
                startActivity(new Intent(SettingActivity.this, EquipmentListActivity.class));
                break;
            case R.id.tv_logout:
                finish();
                break;
            case R.id.ll_check:
                GetLastVersion();
                break;
        }
    }

    /**
     * 检查更新
     */

    private void GetLastVersion() {
        EasyHttp.post(AppUrl.GetLastVersion)
                .params("system", "client")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.show("网络错误");
                    }

                    @Override
                    public void onSuccess(String s) {
                        GMBean gmBean = JSON.parseObject(s, GMBean.class);
                        if (gmBean.isStatus()) {

                            double VersionName = Double.valueOf(PackageUtils.getVersionName(SettingActivity.this));
                            double code = Double.valueOf(gmBean.getData().toString());
                            if (VersionName < code) {
                                upDate(code);
                            } else {
                                ToastUtils.show("已经是最新版本");
                            }
                        }
                    }
                });
    }

    /**
     * 去更新
     */
    private void upDate(final Double code) {
        String apkUrl = AppUrl.BaseURLTest2 + AppUrl.DownloadApk;
        String updateTitle = "发现新版本";
        String updateContent = "发现新版本升级后体验更顺畅";
        UpdateConfig updateConfig = new UpdateConfig();
        updateConfig.setCheckWifi(true);
        updateConfig.isShowNotification();
        updateConfig.setAlwaysShowDownLoadDialog(true);
        updateConfig.setNotifyImgRes(R.mipmap.ic_launcher);

        UiConfig uiConfig = new UiConfig();
        uiConfig.setUiType(UiType.CUSTOM);
        uiConfig.setCustomLayoutId(R.layout.view_update_dialog_custom);

        UpdateAppUtils.getInstance()
                .apkUrl(apkUrl)
                .updateTitle(updateTitle)
                .updateContent(updateContent)
                .uiConfig(uiConfig)
                .updateConfig(updateConfig)
                .setOnInitUiListener(new OnInitUiListener() {
                    @Override
                    public void onInitUpdateUi(View view, UpdateConfig updateConfig, UiConfig uiConfig) {
                        TextView tv_code =view.findViewById(R.id.tv_code);
                        tv_code.setText("V"+code);
                    }
                })
                .update();

    }
}
