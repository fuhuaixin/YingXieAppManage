package com.example.manage.bean;

public class NetBean {

    private String state ="";//状态
    private String name ="";//名称
    private String sn ="";//sn
    private String ip ="";//ip
    private String reception ="";//接收
    private String joinTime ="";//最近加入时间
    private String send ="";//发送
    private String people ="";//已连接人数


    public NetBean(String state, String name, String sn, String ip, String reception, String joinTime, String send, String people) {
        this.state = state;
        this.name = name;
        this.sn = sn;
        this.ip = ip;
        this.reception = reception;
        this.joinTime = joinTime;
        this.send = send;
        this.people = people;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReception() {
        return reception;
    }

    public void setReception(String reception) {
        this.reception = reception;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
