package com.example.manage.bean;

public class FogSettingBean {

    /**
     * code : 0000
     * data : {"timingon":true,"enableFirstSeg":true,"enableSecondSeg":true,"firstSegOpenTime":"14:59","firstSegEndTime":"15:00","secondSegOpenTime":"15:01","secondSegEndTime":"15:02"}
     * message : 查询成功
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
         * timingon : true
         * enableFirstSeg : true
         * enableSecondSeg : true
         * firstSegOpenTime : 14:59
         * firstSegEndTime : 15:00
         * secondSegOpenTime : 15:01
         * secondSegEndTime : 15:02
         */

        private boolean timingon;
        private boolean enableFirstSeg;
        private boolean enableSecondSeg;
        private String firstSegOpenTime;
        private String firstSegEndTime;
        private String secondSegOpenTime;
        private String secondSegEndTime;

        public boolean isTimingon() {
            return timingon;
        }

        public void setTimingon(boolean timingon) {
            this.timingon = timingon;
        }

        public boolean isEnableFirstSeg() {
            return enableFirstSeg;
        }

        public void setEnableFirstSeg(boolean enableFirstSeg) {
            this.enableFirstSeg = enableFirstSeg;
        }

        public boolean isEnableSecondSeg() {
            return enableSecondSeg;
        }

        public void setEnableSecondSeg(boolean enableSecondSeg) {
            this.enableSecondSeg = enableSecondSeg;
        }

        public String getFirstSegOpenTime() {
            return firstSegOpenTime;
        }

        public void setFirstSegOpenTime(String firstSegOpenTime) {
            this.firstSegOpenTime = firstSegOpenTime;
        }

        public String getFirstSegEndTime() {
            return firstSegEndTime;
        }

        public void setFirstSegEndTime(String firstSegEndTime) {
            this.firstSegEndTime = firstSegEndTime;
        }

        public String getSecondSegOpenTime() {
            return secondSegOpenTime;
        }

        public void setSecondSegOpenTime(String secondSegOpenTime) {
            this.secondSegOpenTime = secondSegOpenTime;
        }

        public String getSecondSegEndTime() {
            return secondSegEndTime;
        }

        public void setSecondSegEndTime(String secondSegEndTime) {
            this.secondSegEndTime = secondSegEndTime;
        }
    }
}
