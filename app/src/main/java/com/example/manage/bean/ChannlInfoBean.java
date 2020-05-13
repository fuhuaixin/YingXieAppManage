package com.example.manage.bean;

public class ChannlInfoBean {


    /**
     * channelNo : ch33
     * ipStr : 10.10.10.150
     * name : IPCamera1
     * portStr : 8000
     * status : 0
     */

    private String channelNo;
    private String ipStr;
    private String name;
    private String portStr;
    private int status;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getIpStr() {
        return ipStr;
    }

    public void setIpStr(String ipStr) {
        this.ipStr = ipStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortStr() {
        return portStr;
    }

    public void setPortStr(String portStr) {
        this.portStr = portStr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChannlInfoBean{" +
                "channelNo='" + channelNo + '\'' +
                ", ipStr='" + ipStr + '\'' +
                ", name='" + name + '\'' +
                ", portStr='" + portStr + '\'' +
                ", status=" + status +
                '}';
    }
}
