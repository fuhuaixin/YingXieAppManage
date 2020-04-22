package com.example.manage.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class MyApp extends Application {
    public static Context myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = getApplicationContext();
        SDKInitializer.initialize(myApplication);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
