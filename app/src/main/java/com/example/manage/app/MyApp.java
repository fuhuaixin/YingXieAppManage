package com.example.manage.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.example.manage.utils.SPUtils;
import com.videogo.openapi.EZOpenSDK;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.GsonDiskConverter;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.model.HttpHeaders;

import io.vov.vitamio.utils.Log;
import retrofit2.converter.gson.GsonConverterFactory;
import update.UpdateAppUtils;

/**
 * 所有初始化都写再这边
 */
public class MyApp extends Application {
    public static Context myApplication;

    //    .cacheDiskConverter()
    private String tokens = "";

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = getApplicationContext();
        UpdateAppUtils.init(myApplication);
        SDKInitializer.initialize(myApplication);
        SDKInitializer.setCoordType(CoordType.BD09LL);
        EasyHttp.init(this);

        String username = SPUtils.getString(myApplication, "username");
        String timestamp = SPUtils.getString(myApplication, "timestamp");
        String token = SPUtils.getString(myApplication, "token");
        tokens = username + "-" + timestamp + "-" + token;
        Log.e("fhxx", tokens);
        HttpHeaders headers = new HttpHeaders();
        headers.put("token", tokens);
        EasyHttp.getInstance()
                //可以全局统一设置全局URL
                .setBaseUrl(AppUrl.BaseURLTest2)//设置全局URL  url只能是域名 或者域名+端口号
                .debug("EasyHttp", true)
                //如果使用默认的60秒,以下三行也不需要设置
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 100)
                .setConnectTimeout(60 * 100)
                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                //可以全局统一设置超时重连次数,默认为3次,那么最差的情况会请求4次(一次原始请求,三次重连请求),
                //不需要可以设置为0
                .setRetryCount(3)//网络不好自动重试3次
                //可以全局统一设置超时重试间隔时间,默认为500ms,不需要可以设置为0
                .setRetryDelay(500)//每次延时500ms重试
                //可以全局统一设置超时重试间隔叠加时间,默认为0ms不叠加
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
//                .setCacheDiskConverter(new GsonDiskConverter())
                //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体请看CacheMode
                .addCommonHeaders(headers)
                .setCertificates();




    }
}
