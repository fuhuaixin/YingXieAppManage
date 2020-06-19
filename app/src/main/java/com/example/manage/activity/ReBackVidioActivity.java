package com.example.manage.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.manage.R;
import com.example.manage.base.BaseActivity;
import com.example.manage.utils.DateUtil;
import com.example.manage.utils.DeviceUtil;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import cn.nodemedia.NodePlayer;
import cn.nodemedia.NodePlayerDelegate;
import cn.nodemedia.NodePlayerView;

/**
 * 视频回放界面
 */
public class ReBackVidioActivity extends BaseActivity {

    private TextView tvTitle, tv_start_time, tv_end_time;
    private ImageView imageBack, image_stop, image_scale;
    private String videoId, startTime, endTime;
    private NodePlayerView nodePlayerView;
    private LinearLayout mTopPart, mBotPart;
    private FrameLayout mFlVideoView;
    private RelativeLayout ll_bot;
    private SeekBar mSeekBar;
    private NodePlayer nodePlayer;

    private Timer timer;
    private int seekTime = 0;
    private int isStop = 1;
    private TimerTask task;
    private String strHis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reback_vidio);
        videoId = getIntent().getStringExtra("videoId");
        startTime = getIntent().getStringExtra("startTime");
        endTime = getIntent().getStringExtra("endTime");
        strHis = getIntent().getStringExtra("historyurl");

        Log.e("fhxx", startTime + "--" + endTime + "--" + strHis);
        dialog();
        zLoadingDialog.show();
        initViews();
        initData();

    }

    private void initViews() {
        tvTitle = findViewById(R.id.tv_title);
        imageBack = findViewById(R.id.image_back);
        nodePlayerView = findViewById(R.id.nodePlayer);
        mTopPart = findViewById(R.id.top_part_live_activity);
        mBotPart = findViewById(R.id.bot_part_live_activity);
        mSeekBar = findViewById(R.id.seekBar);

        mFlVideoView = findViewById(R.id.fl_video_view_live_activity);
        image_stop = findViewById(R.id.image_stop);
        image_scale = findViewById(R.id.image_scale);
        ll_bot = findViewById(R.id.ll_bot);
        tv_start_time = findViewById(R.id.tv_start_time);
        tv_end_time = findViewById(R.id.tv_end_time);

    }

    Long dtsHH,dtsMM, dtsSS;
    String dTsStartDate, dTsStartTime, dTsEndDate, dTsEndTime;
    long sTdStart, sTdEnd;
    long nd = 1000 * 24 * 60 * 60;
    long nh = 1000 * 60 * 60;
    long nm = 1000 * 60;
    long ns = 1000;
    private void initData() {
        tvTitle.setText("监控回放");

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Log.e("fhxx 开始 --》",startTime+" - "+endTime);
        sTdStart = DateUtil.getStringToDate(startTime, "yyyy-MM-dd HH:mm:ss");
        sTdEnd = DateUtil.getStringToDate(endTime, "yyyy-MM-dd HH:mm:ss");
//        Log.e("fhxx 完成 --》"," - "+stringToDate);
        Log.e("fhxx 完成 --》",sTdStart+" - "+sTdEnd);
        dTsStartDate = DateUtil.getDateToString(sTdStart, "yyyyMMdd");
        dTsStartTime = DateUtil.getDateToString(sTdStart, "HHmmss");
        dTsEndDate = DateUtil.getDateToString(sTdEnd, "yyyyMMdd");
        dTsEndTime = DateUtil.getDateToString(sTdEnd, "HHmmss");

        setNote(dTsStartDate, dTsStartTime, dTsEndDate, dTsEndTime);

        String datePoor = DateUtil.getDatePoor(sTdEnd, sTdStart);

        long l = Long.valueOf(sTdEnd) - Long.valueOf(sTdStart);

        Log.e("fhxx 相差 --》",l+"");

        dtsSS = l % nd % nh % nm / ns;
        dtsMM = l % nd % nh / nm;
        dtsHH = l % nd / nh;
        Log.e("fhxx 相差2 --》",dtsHH+"---"+dtsMM+"---"+dtsSS);
        tv_end_time.setText(dtsHH+":"+dtsMM + ":" +dtsSS);
        mSeekBar.setMax(Integer.valueOf(String.valueOf( l/1000)));
        image_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStop == 0) {
                    nodePlayer.start();
                    isStop = 1;
                    image_stop.setImageResource(R.mipmap.icon_vidio_stop);
                    timerStart();
                } else {
                    nodePlayer.pause();
                    isStop = 0;
                    image_stop.setImageResource(R.mipmap.icon_vidio_start);
                    task.cancel();
                }

            }
        });

        image_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFullScreen) {
                    setFullScreen();
                } else {
                    setVideoPreview();
                }
            }
        });
        nodePlayer.setNodePlayerDelegate(new NodePlayerDelegate() {
            @Override
            public void onEventCallback(NodePlayer player, int event, String msg) {
//                Log.e("fhxx", event + " ----" + msg);
                switch (event) {
                    case 1001:
                        zLoadingDialog.dismiss();
                        timerStart();
                        break;
                }
            }
        });
        nodePlayerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.ACTION_DOWN == event.getAction()) {
                    if (isScreenClear) {
                        isScreenClear = false;
                        ll_bot.setVisibility(View.VISIBLE);
                        image_stop.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (!isScreenClear) {
                                    isScreenClear = true;
                                    ll_bot.setVisibility(View.GONE);
                                    image_stop.setVisibility(View.GONE);
                                }
                            }
                        }, 3000);
                    } else {
                        isScreenClear = true;
                        ll_bot.setVisibility(View.GONE);
                        image_stop.setVisibility(View.GONE);

                    }
                }
                return true;
            }
        });

        mSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

    }

    /**
     * 设置开始播放
     *
     * @param startDate
     * @param startTime
     * @param endDate
     * @param endTime
     */
    private void setNote(String startDate, String startTime, String endDate, String endTime) {
        String inputUrl = strHis + "?starttime=" + startDate + "t" + startTime + "z&endtime=" + endDate + "t" + endTime + "z";
        nodePlayerView.setRenderType(NodePlayerView.RenderType.SURFACEVIEW);
        nodePlayerView.setUIViewContentMode(NodePlayerView.UIViewContentMode.ScaleToFill);

        nodePlayer = new NodePlayer(this);
        nodePlayer.setPlayerView(nodePlayerView);
        nodePlayer.setRtspTransport(NodePlayer.RTSP_TRANSPORT_TCP);
        nodePlayer.setInputUrl(inputUrl);
        nodePlayer.setVideoEnable(true);
        nodePlayer.start();
    }

    /**
     * 进度条监听
     */
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            nodePlayer.stop();
            nodePlayer.release();
            Log.e("fhxx", "当前进度 2 ：" + seekBar.getProgress());
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.e("fhxx", "结束时--》" + seekBar.getProgress());
            seekTime = seekBar.getProgress();
            mSeekBar.setProgress(seekTime);
            long time = DateUtil.addTime(new Date(sTdStart), 13, seekTime).getTime();
            Log.e("fhxx -->", DateUtil.getDateToString(time, "HHmmss"));
            Log.e("fhxx -->", DateUtil.getDateToString(time, "yyyyMMdd"));
            setNote(DateUtil.getDateToString(time, "yyyyMMdd"), DateUtil.getDateToString(time, "HHmmss"), dTsEndDate, dTsEndTime);
        }
    };


    /**
     * 设置视频全屏
     */
    private boolean isScreenClear = true;
    private boolean isFullScreen;
    int count = 0;

    private void setFullScreen() {
        count++;
        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
//                DeviceUtil.getHeightPixel(this), DeviceUtil.getWidthPixel(this) - DeviceUtil.getStatusBarHeight(this));

        mTopPart.setVisibility(View.GONE);
        mBotPart.setVisibility(View.GONE);
        mFlVideoView.setLayoutParams(fullScreenLLP);//mFlVideoView的宽是屏幕高度，高是屏幕宽度-状态栏高度
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Activity横屏
//        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        nodePlayerView.setUIViewContentMode(NodePlayerView.UIViewContentMode.ScaleToFill);
        isFullScreen = true;
        image_scale.setImageResource(R.mipmap.icon_vidio_shrink);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

    }

    /**
     * 设置视频缩小
     */
    public void setVideoPreview() {
        LinearLayout.LayoutParams previewLLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DeviceUtil.dip2px(213, this));
        mTopPart.setVisibility(View.VISIBLE);
        mBotPart.setVisibility(View.VISIBLE);
        mFlVideoView.setLayoutParams(previewLLP);//mFlVideoView的宽是屏幕的宽度，高是213dp
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//Activity竖屏
        nodePlayerView.setUIViewContentMode(NodePlayerView.UIViewContentMode.ScaleToFill);
        isFullScreen = false;
        image_scale.setImageResource(R.mipmap.icon_vidio_full);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }

    /**
     * 子线程发送信息 主线程中做处理  主要用来更新开始时间和进度条
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 100) {
                String strhh,strmm, strss;
                int obj = (int) msg.obj;
                int hh = obj/60/60;
                int mm=0;
                if (obj / 60>=60){
                    mm= (obj%(60*60))/60;
                }else {
                    mm=obj/60;
                }
                int ss = obj % 60;

                tv_start_time.setText(hh+":"+mm + ":" + ss);
                if (obj >= (Integer.valueOf(String.valueOf(dtsHH)) * 60 *60+Integer.valueOf(String.valueOf(dtsMM)) * 60 + Integer.valueOf(String.valueOf(dtsSS)))) {
                    nodePlayer.pause();
                    isStop = 0;
                    image_stop.setImageResource(R.mipmap.icon_vidio_start);
                    seekTime = 0;
//                    timer.cancel();
                    task.cancel();

                }

            }
        }
    };

    /**
     * 定时器开始
     */
    private void timerStart() {

        timer = new Timer();

        task = new TimerTask() {
            @Override
            public void run() {
                seekTime++;
                mSeekBar.setProgress(seekTime);
                Message message = new Message();
                message.arg1 = 100;
                message.obj = seekTime;
                mHandler.sendMessage(message);
            }
        };
        timer.schedule(task, 0, 1000);
    }

    @Override
    protected void onDestroy() {
        nodePlayer.stop();
        nodePlayer.release();
        super.onDestroy();
    }
}
