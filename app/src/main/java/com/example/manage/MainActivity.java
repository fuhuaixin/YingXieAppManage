package com.example.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout draw_layout;
    private Button btn_open,btn_close;
    private SlidingDrawer slidingdrawer;
    private ImageView image_top,image_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListen();

    }

    private void initView() {
        draw_layout =findViewById(R.id.draw_layout);
        btn_open =findViewById(R.id.btn_open);
        btn_close =findViewById(R.id.btn_close);
        slidingdrawer =findViewById(R.id.slidingdrawer);
        image_top =findViewById(R.id.image_top);
        image_bottom =findViewById(R.id.image_bottom);
    }


    private void initListen() {
        btn_open.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        draw_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        slidingdrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                image_top.setVisibility(View.GONE);
                image_bottom.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "已经打开", Toast.LENGTH_SHORT).show();
            }
        });
        slidingdrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                image_top.setVisibility(View.VISIBLE);
                image_bottom.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "完全关闭", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_open:
                draw_layout.openDrawer(GravityCompat.END);
                break;
            case R.id.btn_close:
                draw_layout.closeDrawer(GravityCompat.END);
                break;
        }
    }
}
