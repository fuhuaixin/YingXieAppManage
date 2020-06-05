package com.example.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.manage.activity.MonitorListActivity;
import com.example.manage.activity.NetActivity;
import com.example.manage.activity.SearchActivity;
import com.example.manage.activity.SettingActivity;
import com.example.manage.adapter.MainEquAdapter;
import com.example.manage.adapter.MainSecneAdapter;
import com.example.manage.app.AppUrl;
import com.example.manage.bean.ApStatusBean;
import com.example.manage.bean.ClientNumsBean;
import com.example.manage.bean.EnvironmentBean;
import com.example.manage.bean.MainDevicesBean;
import com.example.manage.bean.MainEquBean;
import com.example.manage.bean.MainEquMesBean;
import com.example.manage.bean.MainSceneBean;
import com.example.manage.bean.StatisticBean;
import com.example.manage.bean.TrushLastestBean;
import com.example.manage.utils.BarChartUtils;
import com.example.manage.utils.ToastUtils;
import com.example.manage.view.EquMesDialog;
import com.example.manage.utils.PieChartUtil;
import com.example.manage.view.CircularProgressView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页，包括里面的两个抽屉
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout draw_layout;
    private LinearLayout ll_visible, ll_cut, ll_setting;//隐藏，切换，设置
    private SlidingDrawer slidingdrawer;
    private LinearLayout ll_into, ll_title, ll_search;
    private LinearLayout headerMesBottom, headerMesTop, ll_main_location;
    private CircularProgressView progress_rub_one, progress_rub_two; //第一个垃圾桶， 第二个
    private TextView tv_progress_two, tv_progress_one; //第一个垃圾桶数值， 第二个
    private TextView btn_ele, btn_war; //电能，水能
    private BarChart barChart; // 柱状图
    private PieChart pieChart;// 饼状图
    private RecyclerView recycle_scene, recycle_equ;
    private LinearLayout ll_net,ll_net_top; //进入网络界面
    private ArrayList count = new ArrayList();
    private FlexboxLayoutManager flexboxLayoutManager;
    private FlexboxLayoutManager flexboxLayoutManagerEqu;
    private Button btn_login;
    private RelativeLayout rl_monitor;
    private TextureMapView mapView = null;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private TextView tvTotalOne, tvTotalTwo, tvTotalThr, tvTotalFour, tvTotalFive, tvTotalSix;
    private TextView tv_rainvalue_bot, tv_pm_bot, tv_humidity_bot, tv_windirection_bot, tv_tem_bot, tv_tem_title_bot;
    private TextView tv_rainvalue_top, tv_pm_top, tv_humidity_top, tv_windirection_top, tv_tem_top, tv_tem_title_top;
    private TextView tv_flow_total, tv_flow_total_bot, tv_online, tv_stack, tv_wifi_total, tv_wifi_online, tv_wifi_unline, tv_unit;
    private ImageView image_add_zoom, image_lose_zoom,image_tem;

    private boolean isFirstLoc = true; //第一次定位
    private int IsVisible = 1; //1为显示 2 为隐藏
    private MapStatus mapStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListen();
        initMap();
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
        ll_net_top = findViewById(R.id.ll_net_top);
        btn_login = findViewById(R.id.btn_login);
        rl_monitor = findViewById(R.id.rl_monitor);
        mapView = findViewById(R.id.mapView);
        ll_title = findViewById(R.id.ll_title);
        ll_search = findViewById(R.id.ll_search);
        ll_main_location = findViewById(R.id.ll_main_location);

        tvTotalOne = findViewById(R.id.tvTotalOne);
        tvTotalTwo = findViewById(R.id.tvTotalTwo);
        tvTotalThr = findViewById(R.id.tvTotalThr);
        tvTotalFour = findViewById(R.id.tvTotalFour);
        tvTotalFive = findViewById(R.id.tvTotalFive);
        tvTotalSix = findViewById(R.id.tvTotalSix);

        tv_rainvalue_bot = findViewById(R.id.tv_rainvalue_bot);
        tv_pm_bot = findViewById(R.id.tv_pm_bot);
        tv_humidity_bot = findViewById(R.id.tv_humidity_bot);
        tv_windirection_bot = findViewById(R.id.tv_windirection_bot);
        tv_tem_bot = findViewById(R.id.tv_tem_bot);
        tv_rainvalue_top = findViewById(R.id.tv_rainvalue_top);
        tv_pm_top = findViewById(R.id.tv_pm_top);
        tv_humidity_top = findViewById(R.id.tv_humidity_top);
        tv_windirection_top = findViewById(R.id.tv_windirection_top);
        tv_tem_top = findViewById(R.id.tv_tem_top);
        tv_tem_title_top = findViewById(R.id.tv_tem_title_top);
        tv_tem_title_bot = findViewById(R.id.tv_tem_title_bot);

        tv_flow_total = findViewById(R.id.tv_flow_total);
        tv_flow_total_bot = findViewById(R.id.tv_flow_total_bot);
        tv_stack = findViewById(R.id.tv_stack);
        tv_online = findViewById(R.id.tv_online);
        tv_unit = findViewById(R.id.tv_unit);

        tv_wifi_total = findViewById(R.id.tv_wifi_total);
        tv_wifi_online = findViewById(R.id.tv_wifi_online);
        tv_wifi_unline = findViewById(R.id.tv_wifi_unline);
        image_add_zoom = findViewById(R.id.image_add_zoom);
        image_lose_zoom = findViewById(R.id.image_lose_zoom);
        image_tem = findViewById(R.id.image_tem);

        ll_visible.setOnClickListener(this);
        btn_ele.setOnClickListener(this);
        btn_war.setOnClickListener(this);
        ll_cut.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_net.setOnClickListener(this);
        ll_net_top.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        rl_monitor.setOnClickListener(this);
        ll_search.setOnClickListener(this);
        ll_main_location.setOnClickListener(this);
        image_add_zoom.setOnClickListener(this);
        image_lose_zoom.setOnClickListener(this);
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


        initBarChartData(2);
        initPieChartData(); //饼状图数据获取
        getRubash();//获取垃圾桶信息
        Environment();//获取环境信息
        ClientNums();//获取wifi累计人数
        ApStatus();//获取wifi设备
        Devices(); //获取列表
        sceneRecycle();
    }


    private void initMap() {
        //设置定位图标
//        MyLocationConfiguration myLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null, 00000000, 00000000);
//        mBaiduMap.setMyLocationConfiguration(myLocationConfiguration);
        // 不显示百度地图Logo
        mapView.removeViewAt(1);
        mBaiduMap = mapView.getMap();
        UiSettings uiSettings = mBaiduMap.getUiSettings();
        uiSettings.setCompassEnabled(false);
        mapView.showZoomControls(false);

   /*     //定位初始化
        mLocationClient = new LocationClient(this);
        mBaiduMap.setMyLocationEnabled(true);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
//        option.setLocationMode(new LocationClientOption.LocationMode());
        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        mLocationClient.registerLocationListener(mListener);
        //开启地图定位图层
        mLocationClient.start();*/

        mapMoveCenter(new LatLng(34.763375, 113.724974), 17);
//        setMaker();
    }


    /**
     * 将地图移动到中心点
     *
     * @param arg0
     */
    private void mapMoveCenter(LatLng arg0, int zoom) {

        mBaiduMap.clear();

        MapStatus mMapStatus = new MapStatus.Builder()
                .target(arg0)
                .zoom(zoom)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.animateMapStatus(mMapStatusUpdate);
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
        //	MapStatusUpdate state = MapStatusUpdateFactory.zoomBy(4);
        //	mBaiduMap.animateMapStatus(state);
        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory.fromResource(R.mipmap.icon_map_location);
        Bundle mBundle = new Bundle();
        mBundle.putString("title", "changjing");
        mBundle.putString("type", "changjing");
        OverlayOptions option = new MarkerOptions().position(arg0).extraInfo(mBundle).icon(mCurrentMarker);
        // 在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);
        // 获取位置名称
    }


    private List<OverlayOptions> optionsList = new ArrayList<>();
    //构建Marker图标
    BitmapDescriptor bitmap = null;
    private void setMaker(List<MainEquMesBean> latLngList, final String type) {
        mBaiduMap.clear();
        mBaiduMap.removeMarkerClickListener(onMarkerClickListener);
        optionsList.clear();

        switch (type) {
            case "wifi":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_wifi_type_big);
                break;
            case "fire":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_fire_type_big);
                break;
            case "garbage":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_recycl_type_big);
                break;
            case "env":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_envir_type_big);
                break;
            case "camera":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_safe_type_big);
                break;
            case "spray":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_park_type_big);
                break;
            case "light":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_light_type_big);
                break;
            case "screen":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_screen_type_big);
                break;
            case "trash":
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_recycl_type_big);
                break;
            default:
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_map_location);
                break;
        }
        Log.e("fhxx",latLngList.toString());

        //构建MarkerOption，用于在地图上添加Marker
        for (int i = 0; i < latLngList.size(); i++) {
            Bundle mBundle = new Bundle();
            mBundle.putString("type", type);
            mBundle.putString("title", latLngList.get(i).getEquName());

            OverlayOptions option = new MarkerOptions()
                    .extraInfo(mBundle)
                    .position(latLngList.get(i).getLatLng())
                    .icon(bitmap);
            optionsList.add(option);
        }
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(latLngList.get(0).getLatLng())
                .zoom(17)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.animateMapStatus(mMapStatusUpdate);

        //在地图上添加Marker，并显示
        //        mBaiduMap.addOverlay(option);
        mBaiduMap.addOverlays(optionsList);
        mBaiduMap.setOnMarkerClickListener(onMarkerClickListener);
    }

    /**
     * marker点点击事件处理
     */
    private EquMesDialog equMesDialog;
    private BaiduMap.OnMarkerClickListener onMarkerClickListener = new BaiduMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
//            marker.setIcon(bitmap);
//            marker.setIcons();
            if (ifshowDialog){
                Bundle extraInfo = marker.getExtraInfo();
                String title = extraInfo.getString("title");
                String type = extraInfo.getString("type");

                Log.e("fhxx",title+" ----- "+type);

                equMesDialog =new EquMesDialog(MainActivity.this);
//            Toast.makeText(MainActivity.this, type + " ---- " + title, Toast.LENGTH_SHORT).show();
                equMesDialog.SetMessage(type,title);
                equMesDialog.show();
                Window window = equMesDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.BOTTOM;
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                equMesDialog.getWindow().setAttributes(lp);
            }

           /* if (type.equals("light")) {
                startActivity(new Intent(MainActivity.this, LightingActivity.class));
            } else if (type.equals("spray")) {
                startActivity(new Intent(MainActivity.this, SenFogActivity.class));
            } else if (type.equals("screen")) {
                startActivity(new Intent(MainActivity.this, BigScreenActivity.class));
            }*/
            return false;
        }
    };

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
                if (IsVisible == 1) {
                    slidingdrawer.setVisibility(View.GONE);
                    ll_cut.setVisibility(View.GONE);
                    ll_setting.setVisibility(View.GONE);
                    ll_title.setVisibility(View.GONE);
                    ll_search.setVisibility(View.GONE);
                    IsVisible = 2;
                } else if (IsVisible == 2) {
                    slidingdrawer.setVisibility(View.VISIBLE);
                    ll_cut.setVisibility(View.VISIBLE);
                    ll_setting.setVisibility(View.VISIBLE);
                    ll_title.setVisibility(View.VISIBLE);
                    ll_search.setVisibility(View.GONE);

                    IsVisible = 1;
                }
                break;
            case R.id.ll_net_top:
            case R.id.ll_net: //进入网络界面
                Intent intent = new Intent(MainActivity.this, NetActivity.class);
                Log.e("fhxx", "发送前--->" + data1.toString());
                intent.putExtra("apStatusBean", apStatusBean);
                startActivity(intent);
                break;
            case R.id.btn_login:
//                startActivity(new Intent(MainActivity.this, BigScreenActivity.class)); //大屏控制
//                startActivity(new Intent(MainActivity.this, LightingActivity.class));//灯光控制
//                startActivity(new Intent(MainActivity.this, SenFogActivity.class));//森雾控制
//                startActivity(new Intent(MainActivity.this, EquipmentListActivity.class));//设备列表
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.rl_monitor:
                startActivity(new Intent(MainActivity.this, MonitorListActivity.class));
                break;
            case R.id.ll_setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
            case R.id.ll_search:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
//                Toast.makeText(this, "搜素", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_main_location:
                mapMoveCenter(new LatLng(34.763375, 113.724974), 17);
                break;
            case R.id.image_add_zoom:
                mapStatus = mBaiduMap.getMapStatus();
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(mapStatus.zoom + 1).build()));
                break;
            case R.id.image_lose_zoom:
                mapStatus = mBaiduMap.getMapStatus();
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(mapStatus.zoom - 1).build()));
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
            tv_unit.setText("单位：立方（m³）");
            yValues.add(new BarEntry(1, Float.valueOf("0.3621")));
            yValues.add(new BarEntry(2, Float.valueOf("0.2548")));
            yValues.add(new BarEntry(3, Float.valueOf("0.1865")));
            yValues.add(new BarEntry(4, Float.valueOf("0.3354")));
            yValues.add(new BarEntry(5, Float.valueOf("0.2130")));
            yValues.add(new BarEntry(6, Float.valueOf("0.25")));
            yValues.add(new BarEntry(7, Float.valueOf("0.1896")));
            yValues.add(new BarEntry(8, Float.valueOf("0.2864")));
            yValues.add(new BarEntry(9, Float.valueOf("0.3654")));
            yValues.add(new BarEntry(10, Float.valueOf("0.4426")));
            yValues.add(new BarEntry(11, Float.valueOf("0.4235")));
            yValues.add(new BarEntry(12, Float.valueOf("0.3356")));

        } else if (type == 2) {
            tv_unit.setText("单位：千瓦（kw）");

            yValues.add(new BarEntry(1, 25));
            yValues.add(new BarEntry(2, 28));
            yValues.add(new BarEntry(3, 30));
            yValues.add(new BarEntry(4, 26));
            yValues.add(new BarEntry(5, 35));
            yValues.add(new BarEntry(6, 25));
            yValues.add(new BarEntry(7, 32));
            yValues.add(new BarEntry(8, 31));
            yValues.add(new BarEntry(9, 29));
            yValues.add(new BarEntry(10, 25));
            yValues.add(new BarEntry(11, 36));
            yValues.add(new BarEntry(12, 34));
        }
        BarChartUtils.getBarChart().setBarChart(barChart, type, yValues, this);
    }

    /**
     * 饼状图数据添加
     */
    int total;
    StatisticBean.DataBean data;

    private void initPieChartData() {
        EasyHttp.get(AppUrl.PoiStatistic)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        StatisticBean statisticBean = JSON.parseObject(s, StatisticBean.class);

                        if (statisticBean.isStatus()) { //判断是否成功
                            data = statisticBean.getData();
                            count.clear();
                            total = 0;
                            for (int i = 0; i < 6; i++) {
                                count.add(data.getStatis().get(i).getNum());
                                total += data.getStatis().get(i).getNum();
                            }
                            tvTotalOne.setText(data.getStatis().get(0).getNum() + "");
                            tvTotalTwo.setText(data.getStatis().get(1).getNum() + "");
                            tvTotalThr.setText(data.getStatis().get(2).getNum() + "");
                            tvTotalFour.setText(data.getStatis().get(3).getNum() + "");
                            tvTotalFive.setText(data.getStatis().get(4).getNum() + "");
                            tvTotalSix.setText(data.getStatis().get(5).getNum() + "");
                            PieChartUtil.getPitChart().setPieChart(pieChart, (ArrayList) count, "周边概况", false, MainActivity.this, total);
                        }

                    }
                });

    }

    /**
     * 垃圾桶信息获取
     */
    private void getRubash() {
        EasyHttp.get(AppUrl.TrushLatestData)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        TrushLastestBean trushLastestBean = JSON.parseObject(s, TrushLastestBean.class);
                        if (trushLastestBean.isStatus()) {
                            List<TrushLastestBean.DataBean.ListBean> list = trushLastestBean.getData().getList();
                            progress_rub_one.setProgress((int)(list.get(0).getOveralam() * 100));
                            tv_progress_one.setText(list.get(0).getOveralam() * 100 + "%");
                            progress_rub_two.setProgress((int) (list.get(1).getOveralam() * 100));
                            tv_progress_two.setText(list.get(1).getOveralam() * 100 + "%");
                        }
                    }
                });
    }

    /**
     * 获取实时环境信息
     */
    private void Environment() {
        EasyHttp.get(AppUrl.RealEnvironment)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        EnvironmentBean environmentBean = JSON.parseObject(s, EnvironmentBean.class);

                        if (environmentBean.isStatus() && environmentBean.getData().getMonitor() != null) {

                            EnvironmentBean.DataBean.MonitorBean monitor = environmentBean.getData().getMonitor();
                            EnvironmentBean.DataBean.WeatherBean weather = environmentBean.getData().getWeather();
                            tv_tem_top.setText(monitor.getTemperature() + "℃");
                            tv_tem_bot.setText(monitor.getTemperature() + "℃");
                            tv_windirection_bot.setText(monitor.getWindirection());
                            tv_windirection_top.setText(monitor.getWindirection());
                            tv_humidity_top.setText(monitor.getHumidity());
                            tv_humidity_bot.setText(monitor.getHumidity());
                            tv_pm_top.setText(monitor.getPm25()+"μg");
                            tv_pm_bot.setText(monitor.getPm25()+"μg");
                            tv_rainvalue_top.setText(monitor.getRainvalue()+"mm");
                            tv_rainvalue_bot.setText(monitor.getRainvalue()+"mm");

                            tv_tem_title_bot.setText(monitor.getTemperature() + "℃");
                            if (environmentBean.getData().getWeather()!=null){
                                tv_tem_title_top.setText(weather.getWea());
                                switch (weather.getWea_img()){
                                    case "xue":
                                    case "bingbao":
                                        image_tem.setImageResource(R.mipmap.icon_bingbao);
                                        break;
                                    case "lei":
                                        image_tem.setImageResource(R.mipmap.icon_lei);
                                        break;
                                    case "shachen":
                                        image_tem.setImageResource(R.mipmap.icon_shachen);
                                        break;
                                    case "wu":
                                        image_tem.setImageResource(R.mipmap.icon_wu);
                                        break;
                                    case "yun":
                                        image_tem.setImageResource(R.mipmap.icon_yun);
                                        break;
                                    case "yu":
                                        image_tem.setImageResource(R.mipmap.icon_yu);
                                        break;
                                    case "yin":
                                        image_tem.setImageResource(R.mipmap.icon_yin);
                                        break;
                                    case "qing":
                                        image_tem.setImageResource(R.mipmap.icon_qing);
                                        break;
                                }

                            }
                        }
                    }
                });
    }

    /**
     * 获取wifi在线人数和累计人数
     */
    private void ClientNums() {
        EasyHttp.get(AppUrl.Clientnums)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        ClientNumsBean clientNumsBean = JSON.parseObject(s, ClientNumsBean.class);
                        if (clientNumsBean.isStatus()) {
                            tv_online.setText("在线人数:" + clientNumsBean.getData().getOnlineusernum() + "人");
                            tv_stack.setText("累计人数:" + clientNumsBean.getData().getStackusernum() + "人");
                        }
                    }
                });
    }

    /**
     * 获取无线网ap列表和状态
     */
    ApStatusBean apStatusBean;
    List<ApStatusBean.DataBeanX.DataBean> data1 = new ArrayList<>();

    private void ApStatus() {
        EasyHttp.get(AppUrl.ApStatus)
                .timeStamp(true)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        apStatusBean = JSON.parseObject(s, ApStatusBean.class);

                        if (apStatusBean.isStatus()) {
                            data1 = apStatusBean.getData().getData();
                            ApStatusBean.DataBeanX data = apStatusBean.getData();
                            tv_wifi_total.setText(data.getTotal() + "");
                            tv_wifi_online.setText(data.getOnlineCount() + "");
                            tv_wifi_unline.setText(data.getOfflineCount() + "");
                        }
                    }
                });
    }

    /**
     * 获取设备列表json
     */
    private List<MainEquMesBean> envList = new ArrayList<>();// 环境监测
    private List<MainEquMesBean> garbageList = new ArrayList<>();//智能回收
    private List<MainEquMesBean> wifiList = new ArrayList<>();//无线网络
    private List<MainEquMesBean> cameraList = new ArrayList<>();//安防监控
    private List<MainEquMesBean> sprayList = new ArrayList<>();//智能雾森
    private List<MainEquMesBean> fireList = new ArrayList<>();//智能消防
    private List<MainEquMesBean> lightList = new ArrayList<>();//灯光互动
    private List<MainEquMesBean> screenList = new ArrayList<>();//广告大屏
    private List<MainEquMesBean> trashList = new ArrayList<>();//小垃圾桶

    private void Devices() {
        EasyHttp.get(AppUrl.Devices)
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String s) {
                        MainDevicesBean mainDevicesBean = JSON.parseObject(s, MainDevicesBean.class);
                        List<MainDevicesBean.FeaturesBean> features = mainDevicesBean.getFeatures();
                        envList.clear();
                        garbageList.clear();
                        wifiList.clear();
                        cameraList.clear();
                        sprayList.clear();
                        fireList.clear();
                        lightList.clear();
                        screenList.clear();
                        trashList.clear();
                        for (int i = 0; i < features.size(); i++) {
                            String devType = features.get(i).getProperties().getDevType();
                            LatLng latLng = gpsToBaidu(features.get(i).getGeometry().getCoordinates().get(1), features.get(i).getGeometry().getCoordinates().get(0));

                            if (devType != null && devType.equals("envMonitor")) {
                                envList.add(new MainEquMesBean(latLng,"envMonitor","env"));
                            } else if (devType != null && devType.equals("garbageCollector")) {
                                garbageList.add(new MainEquMesBean(latLng,"garbageCollector",features.get(i).getProperties().getEid()+""));
                            } else if (devType != null && devType.equals("wifi")) {
                                wifiList.add(new MainEquMesBean(latLng,"wifi",features.get(i).getProperties().getName()));
                            } else if (devType != null && devType.equals("camera")) {
                                cameraList.add(new MainEquMesBean(latLng,"camera",features.get(i).getProperties().getName()));
                            } else if (devType != null && devType.equals("spray")) {
                                sprayList.add(new MainEquMesBean(latLng,"spray","spray"));
                            } else if (devType != null && devType.equals("fireStation")) {
                                fireList.add(new MainEquMesBean(latLng,"fireStation","fireStation"));
                            } else if (devType != null && devType.equals("lighting")) {
                                lightList.add(new MainEquMesBean(latLng,"lighting",features.get(i).getProperties().getLabel()));
                            } else if (devType != null && devType.equals("screen")) {
                                screenList.add(new MainEquMesBean(latLng,"screen",features.get(i).getProperties().getLabel()));
                            }else if (devType != null && devType.equals("trash")) {
                                trashList.add(new MainEquMesBean(latLng,"trash",features.get(i).getProperties().getMsid()));
                            }
                        }

                    }
                });
    }


    private MainSecneAdapter secneAdapter;
    private List<MainSceneBean> mainSceneBeanList = new ArrayList<>();
    private MainEquAdapter equAdapter;
    private List<MainEquBean> equBeansList = new ArrayList<>();

    /**
     * 侧滑抽屉数据
     */
    private Boolean ifshowDialog =false;
    private void sceneRecycle() {
        mainSceneBeanList.add(new MainSceneBean("河南信息广场", 2, 113.723801, 34.766674));
        mainSceneBeanList.add(new MainSceneBean("新鑫花园西门", 2, 113.725302, 34.766352));
        mainSceneBeanList.add(new MainSceneBean("燕庄农贸市场", 2, 113.725162, 34.764932));
        mainSceneBeanList.add(new MainSceneBean("寻味江南", 2, 113.725315, 34.766756));
        mainSceneBeanList.add(new MainSceneBean("福之源酒店", 2, 113.725293, 34.763064));
        mainSceneBeanList.add(new MainSceneBean("天泰轩", 2, 113.724646, 34.76101));
        mainSceneBeanList.add(new MainSceneBean("路长亭", 2, 113.72518, 34.761804));
        mainSceneBeanList.add(new MainSceneBean("锦城山庄西门", 2, 113.725144, 34.760002));
        mainSceneBeanList.add(new MainSceneBean("伟业大厦", 2, 113.724363, 34.758634));
        mainSceneBeanList.add(new MainSceneBean("天佑小区东门", 2, 113.724668, 34.760273));


        equBeansList.add(new MainEquBean("环境监测", 2));
        equBeansList.add(new MainEquBean("智能回收", 2));
        equBeansList.add(new MainEquBean("无线网络", 2));
        equBeansList.add(new MainEquBean("安防监控", 2));
        equBeansList.add(new MainEquBean("智能雾森", 2));
        equBeansList.add(new MainEquBean("智能消防", 2));
        equBeansList.add(new MainEquBean("灯光互动", 2));
        equBeansList.add(new MainEquBean("广告大屏", 2));
        equBeansList.add(new MainEquBean("智能垃圾桶", 2));


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
                        ifshowDialog=false;
                        mapMoveCenter(new LatLng(mainSceneBeanList.get(position).getLat(), mainSceneBeanList.get(position).getLng()), 20);
//                        Toast.makeText(MainActivity.this, "点击了" + mainSceneBeanList.get(position).toString(), Toast.LENGTH_SHORT).show();
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
                        ifshowDialog=true;
                        switch (position) {
                            case 0:
                                setMaker(envList, "env");
                                break;
                            case 1:
                                setMaker(garbageList, "garbage");
                                break;
                            case 2:
                                setMaker(wifiList, "wifi");
                                break;
                            case 3:
                                setMaker(cameraList, "camera");
                                break;
                            case 4:
                                setMaker(sprayList, "spray");
                                break;
                            case 5:
                                setMaker(fireList, "fire");
                                break;
                            case 6:
                                setMaker(lightList, "light");
                                break;
                            case 7:
                                setMaker(screenList, "screen");
                                break;
                            case 8:
                                setMaker(trashList,"trash");
                                break;
                        }

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

    /**
     * gps坐标转百度坐标
     *
     * @param lat
     * @param lng
     * @return
     */
    private LatLng gpsToBaidu(double lat, double lng) {
        LatLng sourceLatLng = new LatLng(lat, lng);
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.GPS);
        // sourceLatLng待转换坐标
        converter.coord(sourceLatLng);
        LatLng desLatLng = converter.convert();

        return desLatLng;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }


    private BDAbstractLocationListener mListener = new BDAbstractLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return;
            }

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);

            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(19.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        mapView = null;
    }
}
