package com.example.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.activity.BigScreenActivity;
import com.example.manage.activity.LoginActivity;
import com.example.manage.activity.MonitorListActivity;
import com.example.manage.activity.NetActivity;
import com.example.manage.adapter.MainEquAdapter;
import com.example.manage.adapter.MainSecneAdapter;
import com.example.manage.bean.MainEquBean;
import com.example.manage.bean.MainSceneBean;
import com.example.manage.utils.BarChartUtils;
import com.example.manage.utils.PieChartUtil;
import com.example.manage.view.CircularProgressView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页，包括里面的两个抽屉
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout draw_layout;
    private LinearLayout ll_visible,ll_cut,ll_setting;//隐藏，切换，设置
    private SlidingDrawer slidingdrawer;
    private LinearLayout ll_into;
    private LinearLayout headerMesBottom, headerMesTop;
    private CircularProgressView progress_rub_one, progress_rub_two; //第一个垃圾桶， 第二个
    private TextView tv_progress_two, tv_progress_one; //第一个垃圾桶数值， 第二个
    private TextView btn_ele, btn_war; //电能，水能
    private BarChart barChart; // 柱状图
    private PieChart pieChart;// 饼状图
    private RecyclerView recycle_scene, recycle_equ;
    private LinearLayout ll_net; //进入网络界面
    private ArrayList count = new ArrayList();
    private FlexboxLayoutManager flexboxLayoutManager;
    private FlexboxLayoutManager flexboxLayoutManagerEqu;
    private Button btn_login;
    private RelativeLayout rl_monitor;

    private int IsVisible =1; //1为显示 2 为隐藏
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListen();

    }

    private void initView() {
        draw_layout = findViewById(R.id.draw_layout);
        ll_visible = findViewById(R.id.ll_visible);
        ll_cut = findViewById(R.id.ll_cut);
        ll_setting = findViewById(R.id.ll_setting);
        slidingdrawer = findViewById(R.id.slidingdrawer);
        headerMesBottom = findViewById(R.id.headerMesBottom);
        headerMesTop = findViewById(R.id.headerMesTop);
        ll_into = findViewById(R.id.ll_into);
        progress_rub_one = findViewById(R.id.progress_rub_one);
        progress_rub_two = findViewById(R.id.progress_rub_two);
        tv_progress_one = findViewById(R.id.tv_progress_one);
        tv_progress_two = findViewById(R.id.tv_progress_two);
        btn_ele = findViewById(R.id.btn_ele);
        btn_war = findViewById(R.id.btn_war);
        barChart = findViewById(R.id.barChart);
        pieChart = findViewById(R.id.pieChart);
        recycle_scene = findViewById(R.id.recycle_scene);
        recycle_equ = findViewById(R.id.recycle_equ);
        ll_net = findViewById(R.id.ll_net);
        btn_login = findViewById(R.id.btn_login);
        rl_monitor = findViewById(R.id.rl_monitor);



        ll_visible.setOnClickListener(this);
        btn_ele.setOnClickListener(this);
        btn_war.setOnClickListener(this);
        ll_cut.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_net.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        rl_monitor.setOnClickListener(this);
    }


    private void initListen() {

        //设置drawLayout的宽度
        WindowManager wm = getWindowManager();//获取屏幕宽高
        int width = wm.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = ll_into.getLayoutParams();
        layoutParams.width = width * 3 / 4;
        ll_into.setLayoutParams(layoutParams);


        draw_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


        slidingdrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                headerMesTop.setVisibility(View.GONE);
                headerMesBottom.setVisibility(View.VISIBLE);
            }
        });
        slidingdrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                headerMesTop.setVisibility(View.VISIBLE);
                headerMesBottom.setVisibility(View.GONE);
            }
        });

        progress_rub_one.setProgress(26);
        tv_progress_one.setText(26 + "%");

        progress_rub_two.setProgress(66);
        tv_progress_two.setText(66 + "%");

        initBarChartData(2);
        initPieChartData();

        sceneRecycle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_cut:
                draw_layout.openDrawer(GravityCompat.END);
                break;
            case R.id.btn_war: //水量
                btn_war.setBackgroundColor(getResources().getColor(R.color.light_blue));
                btn_war.setTextColor(getResources().getColor(R.color.white));
                btn_ele.setBackgroundColor(getResources().getColor(R.color.white));
                btn_ele.setTextColor(getResources().getColor(R.color.black));
                initBarChartData(1);
                break;
            case R.id.btn_ele: //电量
                btn_ele.setBackgroundColor(getResources().getColor(R.color.light_blue));
                btn_ele.setTextColor(getResources().getColor(R.color.white));
                btn_war.setBackgroundColor(getResources().getColor(R.color.white));
                btn_war.setTextColor(getResources().getColor(R.color.black));
                initBarChartData(2);
                break;
            case R.id.ll_visible: //隐藏
                if (IsVisible==1){
                    slidingdrawer.setVisibility(View.GONE);
                    ll_cut.setVisibility(View.GONE);
                    ll_setting.setVisibility(View.GONE);
                    IsVisible=2;
                }else if (IsVisible==2){
                    slidingdrawer.setVisibility(View.VISIBLE);
                    ll_cut.setVisibility(View.VISIBLE);
                    ll_setting.setVisibility(View.VISIBLE);

                    IsVisible =1;
                }
                break;
            case R.id.ll_net: //进入网络界面
                Intent intent = new Intent(MainActivity.this, NetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                startActivity(new Intent(MainActivity.this, BigScreenActivity.class));
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.rl_monitor:
                startActivity(new Intent(MainActivity.this, MonitorListActivity.class));
                break;
        }
    }

    /**
     * 柱状图数据添加
     *
     * @param type
     */
    private void initBarChartData(int type) {

        ArrayList<BarEntry> yValues = new ArrayList<>();
        if (type == 1) {
            for (int x = 0; x < 30; x++) {
                // 2.0 ----xValues.add(String.valueOf(i));
                float y = (float) (Math.random() * 500);
                yValues.add(new BarEntry(x, y));
            }
        } else if (type == 2) {
            for (int x = 0; x < 15; x++) {
                // 2.0 ----xValues.add(String.valueOf(i));
                float y = (float) (Math.random() * 500);
                yValues.add(new BarEntry(x, y));
            }
        }
        BarChartUtils.getBarChart().setBarChart(barChart, type, yValues, this);
    }

    /**
     * 饼状图数据添加
     */
    int value1, value2, value3, value4, value5;
    int total;

    private void initPieChartData() {
        value1 = 15;
        value2 = 25;
        value3 = 35;
        value4 = 30;
        value5 = 20;
        count.add(value1);
        count.add(value2);
        count.add(value3);
        count.add(value4);
        count.add(value5);

        total = value1 + value2 + value3 + value4 + value5;

        PieChartUtil.getPitChart().setPieChart(pieChart, (ArrayList) count, "周边概况", false, this, total);
    }

    private MainSecneAdapter secneAdapter;
    private List<MainSceneBean> mainSceneBeanList = new ArrayList<>();
    private MainEquAdapter equAdapter;
    private List<MainEquBean> equBeansList = new ArrayList<>();

    private void sceneRecycle() {
        mainSceneBeanList.add(new MainSceneBean("两个",2));
//        for (int i = 0; i < 8; i++) {
//            mainSceneBeanList.add(new MainSceneBean("英协花" + i, 2));
//        }
        mainSceneBeanList.add(new MainSceneBean("三个字",2));
        mainSceneBeanList.add(new MainSceneBean("我猜就是看了觉得",2));
        mainSceneBeanList.add(new MainSceneBean("你得四字",2));
        mainSceneBeanList.add(new MainSceneBean("两个2",2));
        mainSceneBeanList.add(new MainSceneBean("你得五个字",2));


        equBeansList.add(new MainEquBean("设备" , 2));
        equBeansList.add(new MainEquBean("设备四字" , 2));
        for (int i = 0; i < 8; i++) {
            equBeansList.add(new MainEquBean("设备" + i, 2));
        }
        equBeansList.add(new MainEquBean("设备五个字" , 2));
        equBeansList.add(new MainEquBean("设备五个字" , 2));
        equBeansList.add(new MainEquBean("设备六六个字" , 2));

        mainSceneBeanList.get(0).setIsTrue(1);
        equBeansList.get(0).setIsChoose(1);

        secneAdapter = new MainSecneAdapter(R.layout.item_scene, mainSceneBeanList, this);
        flexboxLayoutManager = new FlexboxLayoutManager(this);
        //设置主轴排列方式
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);
        flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);

        recycle_scene.setLayoutManager(flexboxLayoutManager);

        recycle_scene.setAdapter(secneAdapter);
        secneAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tvMessage:
                        Toast.makeText(MainActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();

                        for (int i = 0; i < mainSceneBeanList.size(); i++) {
                            mainSceneBeanList.get(i).setIsTrue(2);
                        }
                        mainSceneBeanList.get(position).setIsTrue(1);
                        secneAdapter.notifyDataSetChanged();
                        draw_layout.closeDrawer(GravityCompat.END);
                        break;
                }

            }
        });
        flexboxLayoutManagerEqu = new FlexboxLayoutManager(this);
        //设置主轴排列方式
        flexboxLayoutManagerEqu.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        flexboxLayoutManagerEqu.setFlexWrap(FlexWrap.WRAP);
        flexboxLayoutManagerEqu.setAlignItems(AlignItems.STRETCH);
        equAdapter = new MainEquAdapter(R.layout.item_scene, equBeansList, this);
        recycle_equ.setLayoutManager(flexboxLayoutManagerEqu);
        recycle_equ.setAdapter(equAdapter);
        equAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tvMessage:
                        Toast.makeText(MainActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < equBeansList.size(); i++) {
                            equBeansList.get(i).setIsChoose(2);
                        }
                        equBeansList.get(position).setIsChoose(1);
                        equAdapter.notifyDataSetChanged();
                        draw_layout.closeDrawer(GravityCompat.END);
                        break;
                }
            }
        });

    }

    private static final int TIME_EXIT = 2000;
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (slidingdrawer.isOpened()) {
            slidingdrawer.animateClose();
        } else if (draw_layout.isDrawerOpen(GravityCompat.END)) {
            draw_layout.closeDrawer(GravityCompat.END);
        } else {
            if (mBackPressed + TIME_EXIT > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this, "再点击一次返回退出程序", Toast.LENGTH_SHORT).show();
                mBackPressed = System.currentTimeMillis();
            }
        }

    }
}
