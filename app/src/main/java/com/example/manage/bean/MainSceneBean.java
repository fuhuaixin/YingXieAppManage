package com.example.manage.bean;

public class MainSceneBean {
    private String msg;
    private int isTrue;

    public MainSceneBean(String msg, int isTrue) {
        this.msg = msg;
        this.isTrue = isTrue;
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
}
