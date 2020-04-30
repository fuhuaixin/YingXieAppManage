package com.example.manage.bean;

public class LightStatusBean {

    /**
     * code :
     * data : {"deviceKey":"71142","deviceStatus":2,"relayID":0,"realyName":"英协路智慧街道投影电脑","status":1}
     * message :
     * status : true
     */

    private String code;
    private DataBean data;
    private String message;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * deviceKey : 71142
         * deviceStatus : 2
         * relayID : 0
         * realyName : 英协路智慧街道投影电脑
         * status : 1
         */

        private String deviceKey;
        private int deviceStatus;
        private int relayID;
        private String realyName;
        private int status;

        public String getDeviceKey() {
            return deviceKey;
        }

        public void setDeviceKey(String deviceKey) {
            this.deviceKey = deviceKey;
        }

        public int getDeviceStatus() {
            return deviceStatus;
        }

        public void setDeviceStatus(int deviceStatus) {
            this.deviceStatus = deviceStatus;
        }

        public int getRelayID() {
            return relayID;
        }

        public void setRelayID(int relayID) {
            this.relayID = relayID;
        }

        public String getRealyName() {
            return realyName;
        }

        public void setRealyName(String realyName) {
            this.realyName = realyName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
