package com.example.manage.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.manage.R;
import com.example.manage.base.BaseActivity;
import com.example.manage.utils.DeviceUtil;
import com.example.manage.utils.WindowSizeChangeNotifier;
import com.ezvizuikit.open.EZUIError;
import com.ezvizuikit.open.EZUIKit;
import com.ezvizuikit.open.EZUIPlayer;

import java.util.Calendar;



public class EzOpenActivity extends BaseActivity implements EZUIPlayer.EZUIPlayerCallBack, WindowSizeChangeNotifier.OnWindowSizeChangedListener, View.OnClickListener {
    private EZUIPlayer player;
    private LinearLayout mTopPart, mBottomPart;
    private FrameLayout mFlVideoView;
    private ImageView image_stop, image_scale,image_back;
    private TextView tvTitle;
    private RelativeLayout ll_bot;

    private String videourl, accesstoken;
    private MyOrientationDetector mOrientationDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ez_open);
        //初始化EZUIKit
        EZUIKit.initWithAppKey(this.getApplication(), "2d34a04176844e5c986842dc6a8d5572");

        videourl = getIntent().getStringExtra("videourl");
        accesstoken = getIntent().getStringExtra("accesstoken");


        Log.e("ezOpen", videourl + "---" + accesstoken );

        EZUIKit.setDebug(true);
        //设置授权token
        EZUIKit.setAccessToken(accesstoken);

        initViews();
        initDatas();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mOrientationDetector.enable();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mOrientationDetector.disable();
    }

    private void initListener() {
        image_stop.setOnClickListener(this);
        image_scale.setOnClickListener(this);
        image_back.setOnClickListener(this);
        player.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.ACTION_DOWN == event.getAction()) {
                    if (isScreenClear) {
                        isScreenClear = false;
                        ll_bot.setVisibility(View.VISIBLE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (!isScreenClear) {
                                    isScreenClear = true;
                                    ll_bot.setVisibility(View.GONE);
                                }
                            }
                        }, 3000);
                    } else {
                        isScreenClear = true;
                        ll_bot.setVisibility(View.GONE);
                    }
                }
                return true;
            }
        });
    }


    private void initViews() {
        player = findViewById(R.id.player_ui);
        mTopPart = findViewById(R.id.top_part_live_activity);
        mBottomPart = findViewById(R.id.bottom_part_live_activity);
        mFlVideoView = findViewById(R.id.fl_video_view_live_activity);
        image_stop = findViewById(R.id.image_stop);
        image_scale = findViewById(R.id.image_scale);
        tvTitle = findViewById(R.id.tv_title);
        ll_bot = findViewById(R.id.ll_bot);
        image_back = findViewById(R.id.image_back);

    }

    private void initDatas() {
        tvTitle.setText("监控播放");
        mOrientationDetector = new MyOrientationDetector(this);
        //设置加载需要显示的view
        player.setLoadingView(initProgressBar());
        player.setCallBack(this);
        //设置播放参数
        player.setUrl(videourl);
        setSurfaceSize();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止播放
        player.stopPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        player.releasePlayer();
    }

    private String TAG = "EZOpen";

    @Override
    public void onPlaySuccess() {
        Log.d(TAG, "onPlaySuccess");

    }

    @Override
    public void onPlayFail(EZUIError error) {
        Log.d(TAG, "onPlayFail");
        if (error.getErrorString().equals(EZUIError.UE_ERROR_INNER_VERIFYCODE_ERROR)) {

        } else if (error.getErrorString().equalsIgnoreCase(EZUIError.UE_ERROR_NOT_FOUND_RECORD_FILES)) {
            //未发现录像文件
            Toast.makeText(this, "未发现录像文件", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onVideoSizeChange(int width, int height) {
        Log.d(TAG, "onVideoSizeChange  width = " + width + "   height = " + height);
    }

    @Override
    public void onPrepared() {
        Log.d(TAG, "onPrepared");
        //播放
        player.startPlay();
    }

    @Override
    public void onPlayTime(Calendar calendar) {
        if (calendar != null) {
            // TODO: 2017/2/16 当前播放时间
            Log.d(TAG, "onPlayTime calendar = " + calendar.getTime().toString());
        }
    }

    @Override
    public void onPlayFinish() {
        Log.d(TAG, "onPlayFinish");
    }


    /**
     * 创建加载view
     *
     * @return
     */
    private View initProgressBar() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(lp);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);//addRule参数对应RelativeLayout XML布局的属性
        ProgressBar mProgressBar = new ProgressBar(this);
        mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progress));
        relativeLayout.addView(mProgressBar, rlp);
        return relativeLayout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_stop:
                if (player.getStatus() == EZUIPlayer.STATUS_PLAY) {
                    //播放状态，点击停止播放
                    image_stop.setImageResource(R.mipmap.icon_vidio_start);
                    player.stopPlay();
                } else if (player.getStatus() == EZUIPlayer.STATUS_STOP) {
                    //停止状态，点击播放
                    image_stop.setImageResource(R.mipmap.icon_vidio_stop);
                    player.startPlay();
                }
                break;
            case R.id.image_back:
                finish();
                break;
            case R.id.image_scale:
                if (!isFullScreen) {
                    setFullScreen();
                } else {
                    setVideoPreview();
                }
                break;
        }
    }


    /**
     * 设置视频全屏
     */
    private boolean isScreenClear = true;
    private boolean isFullScreen;

    private void setFullScreen() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
//                DeviceUtil.getHeightPixel(this), DeviceUtil.getWidthPixel(this) - DeviceUtil.getStatusBarHeight(this));

        mTopPart.setVisibility(View.GONE);
        mBottomPart.setVisibility(View.GONE);
        mFlVideoView.setLayoutParams(fullScreenLLP);//mFlVideoView的宽是屏幕高度，高是屏幕宽度-状态栏高度
//        player.setSurfaceSize(dm.widthPixels,dm.heightPixels);//mFlVideoView的宽是屏幕高度，高是屏幕宽度-状态栏高度
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Activity横屏
//        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        isFullScreen = true;
        image_scale.setImageResource(R.mipmap.icon_vidio_shrink);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    /**
     * 设置视频缩小
     */
    public void setVideoPreview() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        LinearLayout.LayoutParams previewLLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DeviceUtil.dip2px(200, this));
        mTopPart.setVisibility(View.VISIBLE);
        mBottomPart.setVisibility(View.VISIBLE);
        mFlVideoView.setLayoutParams(previewLLP);//mFlVideoView的宽是屏幕的宽度，高是203dp
//        player.setSurfaceSize(dm.widthPixels,0);//mFlVideoView的宽是屏幕高度，高是屏幕宽度-状态栏高度
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//Activity竖屏
//        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        isFullScreen = false;
        image_scale.setImageResource(R.mipmap.icon_vidio_full);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }

    private void setSurfaceSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        boolean isWideScrren = mOrientationDetector.isWideScrren();
        //竖屏
        if (!isWideScrren) {
            //竖屏调整播放区域大小，宽全屏，高根据视频分辨率自适应
            player.setSurfaceSize(dm.widthPixels, 0);
            setVideoPreview();
        } else {
            //横屏屏调整播放区域大小，宽、高均全屏，播放区域根据视频分辨率自适应
            player.setSurfaceSize(dm.widthPixels, dm.heightPixels);
            setFullScreen();
        }
    }


    @Override
    public void onWindowSizeChanged(int w, int h, int oldW, int oldH) {
        if (player != null) {
            setSurfaceSize();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");
        setSurfaceSize();
    }

    public class MyOrientationDetector extends OrientationEventListener {

        private WindowManager mWindowManager;
        private int mLastOrientation = 0;

        public MyOrientationDetector(Context context) {
            super(context);
            mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }

        public boolean isWideScrren() {
            Display display = mWindowManager.getDefaultDisplay();
            Point pt = new Point();
            display.getSize(pt);
            return pt.x > pt.y;
        }

        @Override
        public void onOrientationChanged(int orientation) {
            int value = getCurentOrientationEx(orientation);
            if (value != mLastOrientation) {
                mLastOrientation = value;
                int current = getRequestedOrientation();
                if (current == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                        || current == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }
        }

        private int getCurentOrientationEx(int orientation) {
            int value = 0;
            if (orientation >= 315 || orientation < 45) {
                // 0度
                value = 0;
                return value;
            }
            if (orientation >= 45 && orientation < 135) {
                // 90度
                value = 90;
                return value;
            }
            if (orientation >= 135 && orientation < 225) {
                // 180度
                value = 180;
                return value;
            }
            if (orientation >= 225 && orientation < 315) {
                // 270度
                value = 270;
                return value;
            }
            return value;
        }
    }
}
