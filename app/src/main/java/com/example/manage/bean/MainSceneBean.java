package com.example.manage.bean;

public class MainSceneBean {
    private String msg;
    private int isTrue;
    private double lng;
    private double lat;

    public MainSceneBean(String msg, int isTrue,double lng,double lat) {
        this.msg = msg;
        this.isTrue = isTrue;
        this.lng =lng;
        this.lat =lat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "MainSceneBean{" +
                "msg='" + msg + '\'' +
                ", isTrue=" + isTrue +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
