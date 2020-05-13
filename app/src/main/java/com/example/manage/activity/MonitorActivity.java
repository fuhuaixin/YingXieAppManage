package com.example.manage.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.R;
import com.example.manage.adapter.MonitorAdapter;
import com.example.manage.base.BaseActivity;
import com.example.manage.bean.MonitorBean;
import com.example.manage.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;


/**
 * 监控直播界面
 */
public class MonitorActivity extends BaseActivity {

    private ImageView imageBack,image_stop;
    private TextView tvTitle,tv_monitor_title;
    private RecyclerView recycle_monitor;
    private MonitorAdapter monitorAdapter;
    private VideoView vitamio;
    private List<MonitorBean> monitorBeanList =new ArrayList<>();
    private LinearLayout ll_reback_vidio;

    private String strTitle="",strUrl="",strId="";
    private int isStop =0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Vitamio.isInitialized(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_monitor);
        dialog();
        zLoadingDialog.show();
        initViews();
        inits();

    }

    private void initViews() {
        strTitle =getIntent().getStringExtra("videoname");
        strUrl =getIntent().getStringExtra("videourl");
        strId =getIntent().getStringExtra("videoid");

        imageBack =findViewById(R.id.image_back);
        tvTitle =findViewById(R.id.tv_title);
        tv_monitor_title =findViewById(R.id.tv_monitor_title);
        recycle_monitor =findViewById(R.id.recycle_monitor);
        vitamio =findViewById(R.id.vitamio);
        ll_reback_vidio =findViewById(R.id.ll_reback_vidio);
        image_stop =findViewById(R.id.image_stop);

    }

    private void inits(){

        tvTitle.setText("监控播放");
        tv_monitor_title.setText(strTitle);


        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i = 0; i < 8; i++) {
            monitorBeanList.add(new MonitorBean("time"+i,false));
        }

        recycle_monitor.setLayoutManager(new LinearLayoutManager(this));
        monitorAdapter=new MonitorAdapter(R.layout.item_monitor,monitorBeanList);
        recycle_monitor.setAdapter(monitorAdapter);

        monitorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        for (int i = 0; i < monitorBeanList.size(); i++) {
                            monitorBeanList.get(i).setChoose(false);
                        }
                        monitorBeanList.get(position).setChoose(true);
                        monitorAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        vitamio.setVideoURI(Uri.parse(strUrl));
        vitamio.start();
//        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        vitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //此处设置播放速度为正常速度1
//                mediaPlayer.setPlaybackSpeed(1.0f);
                zLoadingDialog.dismiss();
                isStop=1;

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

        ll_reback_vidio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitorActivity.this,RebackVidioListActivity.class);
                intent.putExtra("backId",strId);
                startActivity(intent);
            }
        });

        image_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStop==0){
                    vitamio.start();
                    isStop=1;
                }else {
                    vitamio.pause();
                    isStop=0;
                }

            }
        });
    }

}
