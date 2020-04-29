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
    //硬件关机
    public static final String ScreenShutdown = basePath+"screen/hardShutdown";


    public static final String controlLight = basePath+"light/controlLight";



}
