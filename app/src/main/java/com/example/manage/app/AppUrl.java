package com.example.manage.app;

public class AppUrl {

    public static final String BaseURLTest = "http://192.168.10.151:8080/"; //测试(测试环境)
    public static final String BaseURLTest2 = "http://192.168.10.104:8080/"; //测试(测试环境)2
//    public static final String PRODUCT_URL = "https://www.jianshu.com/"; //正式服务器(生产环境)



    public static final String basePath ="zhjd/server/";

    //登录
    public static final String Login = basePath+"auth/login";

    //周边概况统计
    public static final String PoiStatistic = basePath+"info/poiStatistic";
    //获取垃圾桶最新数据
    public static final String TrushLatestData = basePath+"env/getTrushLatestData";
    //实时环境信息接口
    public static final String RealEnvironment = basePath+"env/realEnvironment";
    //wifi在线人数和累计人数
    public static final String Clientnums = basePath+"wifi/clientnums";
    //无线网ap列表和状态
    public static final String ApStatus = basePath+"wifi/apstatus";

    //获取广告屏开机状态
    public static final String ScreenStatus = basePath+"screen/getStatus";
    //广告屏硬件关机
    public static final String ScreenHardShutdown = basePath+"screen/hardShutdown";
    //广告屏系统重启
    public static final String ScreenSoftReBoot = basePath+"screen/softReboot";
    //广告屏硬件重启
    public static final String ScreenHardReBoot = basePath+"screen/hardReboot";
    //广告屏关机并定时开机
    public static final String ScreenAlarm = basePath+"screen/alarmPoweron";

    //灯光互动设备状态
    public static final String LightStatus = basePath+"light/lightStatus";
    //灯光互动控制
    public static final String LightControl = basePath+"light/controlLight";
    //互动灯光设备定时配置
    public static final String LightSetting = basePath+"light/lightSetting";
    //设置互动灯光定时任务
    public static final String LightSaveSetting = basePath+"light/saveLightSetting";


    //雾森设备开关状态
    public static final String FogStatus = basePath+"fog/fogStatus";
    //控制雾森设备开关
    public static final String FogsonControl = basePath+"fog/fogsonControl";
    //获取雾森定时配置
    public static final String FogSetting = basePath+"fog/fogSetting";
    //获取雾森定时配置
    public static final String SaveFogSetting = basePath+"fog/savefogSetting";

    //获取视频列表
    public static final String VideoVideos = basePath+"video/videos";





}