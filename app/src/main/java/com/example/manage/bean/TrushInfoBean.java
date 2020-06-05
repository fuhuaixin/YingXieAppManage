package com.example.manage.bean;

import java.util.List;

public class TrushInfoBean {

    /**
     * code : 0000
     * data : [{"deviceId":"7189a25669bb4b3f9fedd689c7a6cf45","fwjs":"0","id":"5584feb2-8ba6-4340-bd42-4ebaa9ac3896","imei":"864162046302553","lsm":"12","magJizhunF":"120","magJizhunJ":"120","magLim":"350","magRaodong":"100","msgLeixing":"1","msid":"M20058S5179","mtime":"03182803","rfRssq":"22","shebeiJiancezhi":"41","shebeiPower":"90","shebeiState":"1","shebeiVoltage":"3.6000001430511475","wendu":"18.100000381469727"}]
     * message : 查询成功
     * status : true
     */

    private String code;
    private String message;
    private boolean status;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * deviceId : 7189a25669bb4b3f9fedd689c7a6cf45
         * fwjs : 0
         * id : 5584feb2-8ba6-4340-bd42-4ebaa9ac3896
         * imei : 864162046302553
         * lsm : 12
         * magJizhunF : 120
         * magJizhunJ : 120
         * magLim : 350
         * magRaodong : 100
         * msgLeixing : 1
         * msid : M20058S5179
         * mtime : 03182803
         * rfRssq : 22
         * shebeiJiancezhi : 41
         * shebeiPower : 90
         * shebeiState : 1
         * shebeiVoltage : 3.6000001430511475
         * wendu : 18.100000381469727
         */

        private String deviceId;
        private String fwjs;
        private String id;
        private String imei;
        private String lsm;
        private String magJizhunF;
        private String magJizhunJ;
        private String magLim;
        private String magRaodong;
        private String msgLeixing;
        private String msid;
        private String mtime;
        private String rfRssq;
        private String shebeiJiancezhi;
        private String shebeiPower;
        private String shebeiState;
        private String shebeiVoltage;
        private String wendu;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getFwjs() {
            return fwjs;
        }

        public void setFwjs(String fwjs) {
            this.fwjs = fwjs;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getLsm() {
            return lsm;
        }

        public void setLsm(String lsm) {
            this.lsm = lsm;
        }

        public String getMagJizhunF() {
            return magJizhunF;
        }

        public void setMagJizhunF(String magJizhunF) {
            this.magJizhunF = magJizhunF;
        }

        public String getMagJizhunJ() {
            return magJizhunJ;
        }

        public void setMagJizhunJ(String magJizhunJ) {
            this.magJizhunJ = magJizhunJ;
        }

        public String getMagLim() {
            return magLim;
        }

        public void setMagLim(String magLim) {
            this.magLim = magLim;
        }

        public String getMagRaodong() {
            return magRaodong;
        }

        public void setMagRaodong(String magRaodong) {
            this.magRaodong = magRaodong;
        }

        public String getMsgLeixing() {
            return msgLeixing;
        }

        public void setMsgLeixing(String msgLeixing) {
            this.msgLeixing = msgLeixing;
        }

        public String getMsid() {
            return msid;
        }

        public void setMsid(String msid) {
            this.msid = msid;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public String getRfRssq() {
            return rfRssq;
        }

        public void setRfRssq(String rfRssq) {
            this.rfRssq = rfRssq;
        }

        public String getShebeiJiancezhi() {
            return shebeiJiancezhi;
        }

        public void setShebeiJiancezhi(String shebeiJiancezhi) {
            this.shebeiJiancezhi = shebeiJiancezhi;
        }

        public String getShebeiPower() {
            return shebeiPower;
        }

        public void setShebeiPower(String shebeiPower) {
            this.shebeiPower = shebeiPower;
        }

        public String getShebeiState() {
            return shebeiState;
        }

        public void setShebeiState(String shebeiState) {
            this.shebeiState = shebeiState;
        }

        public String getShebeiVoltage() {
            return shebeiVoltage;
        }

        public void setShebeiVoltage(String shebeiVoltage) {
            this.shebeiVoltage = shebeiVoltage;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }
    }
}
