package com.example.manage.bean;

public class MonitorListBean {
    private String image;
    private String msg;

    public MonitorListBean(String image, String msg) {
        this.image = image;
        this.msg = msg;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
