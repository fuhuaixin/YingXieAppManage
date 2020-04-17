package com.example.manage.bean;

public class MainEquBean {
    private String msg ="";
    private int isChoose =0;

    public MainEquBean(String msg, int isChoose) {
        this.msg = msg;
        this.isChoose = isChoose;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }
}
