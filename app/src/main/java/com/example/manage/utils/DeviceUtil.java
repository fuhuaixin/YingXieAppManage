package com.example.manage.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public class DeviceUtil {
    private static final String NOTIFICATION_STATE_OPEN = "打开";
    private static final String NOTIFICATION_STATE_CLOSE = "关闭";
    private static final String UN_KNOWN = "未知";

    /**
     * 得到屏幕高度，单位是像素
     *
     * @param activity
     * @return
     */
    public static int getHeightPixel(Activity activity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels;
    }

    /**
     * 得到屏幕宽度，单位是像素
     *
     * @param activity
     * @return
     */
    public static int getWidthPixel(Activity activity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
    }

    /**
     * 手机状态栏的高度，及信号、电量、时间一栏的高度，单位是像素
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }

    /**
     * dp转成px
     *
     * @param dpValue
     * @param context
     * @return
     */
    public static int dip2px(float dpValue, Context context) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转成dp
     *
     * @param pxValue
     * @param context
     * @return
     */
    public static int px2dip(float pxValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static String getBrand() {
        return Build.BRAND;

    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getCpuType() {
        return Build.CPU_ABI;
    }

}
