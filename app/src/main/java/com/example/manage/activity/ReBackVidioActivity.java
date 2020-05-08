package com.example.manage.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.example.manage.R;
import com.example.manage.app.AppUrl;
import com.example.manage.base.BaseActivity;
import com.example.manage.bean.ReBackVidioBean;
import com.example.manage.utils.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

/**
 * 视频回放界面
 */
public class ReBackVidioActivity extends BaseActivity {

    private TextView tvTitle;
    private ImageView imageBack;
    private String videoId,startTime,endTime;
    private VideoView vitamio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reback_vidio);
        dialog();
        zLoadingDialog.show();
        initViews();
        initData();

    }

    private void initViews() {
        tvTitle =findViewById(R.id.tv_title);
        imageBack =findViewById(R.id.image_back);
        vitamio =findViewById(R.id.vitamio);
        videoId= getIntent().getStringExtra("videoId");
        startTime= getIntent().getStringExtra("startTime");
        endTime= getIntent().getStringExtra("endTime");
    }

    private void initData() {
        tvTitle.setText("监控回放");

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createPlayBack(videoId,startTime,endTime);

    }


    private void createPlayBack(String videoId,String startTime,String endTime){

        EasyHttp.post(AppUrl.CreatePlayBack)
                .params("videoId",videoId)
                .params("startTime",startTime)
                .params("endTime",endTime)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        ReBackVidioBean reBackVidioBean = JSON.parseObject(s, ReBackVidioBean.class);
                        if (reBackVidioBean.isStatus()){
                            vitamio.setVideoURI(Uri.parse(reBackVidioBean.getData()));
                            vitamio.start();
                            vitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mediaPlayer) {
                                    //此处设置播放速度为正常速度1
                                    zLoadingDialog.dismiss();

                                }
                            });
                            vitamio.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                @Override
                                public boolean onError(MediaPlayer mp, int what, int extra) {
                                    ToastUtils.show("播放失败");
                                    zLoadingDialog.dismiss();

                                    return false;
                                }
                            });
                        }
                    }
                });

    }
}
