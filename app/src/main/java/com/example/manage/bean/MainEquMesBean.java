package com.example.manage.bean;

import com.baidu.mapapi.model.LatLng;

/**
 * 首页设备名称以及位置信息
 */
public class MainEquMesBean {
    private LatLng latLng;
    private String type;
    private String equName;
    private String id; //每个设备的唯一标识

    public MainEquMesBean(LatLng latLng, String type, String equName,String id) {
        this.latLng = latLng;
        this.type = type;
        this.equName = equName;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    @Override
    public String toString() {
        return "MainEquMesBean{" +
                "latLng=" + latLng +
                ", type='" + type + '\'' +
                ", equName='" + equName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
