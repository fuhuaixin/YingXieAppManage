package com.example.manage.bean;

public class MonitorBean {

    private String time;
    private Boolean isChoose;

    public MonitorBean(String time, Boolean isChoose) {
        this.time = time;
        this.isChoose = isChoose;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getChoose() {
        return isChoose;
    }

    public void setChoose(Boolean choose) {
        isChoose = choose;
    }
}
