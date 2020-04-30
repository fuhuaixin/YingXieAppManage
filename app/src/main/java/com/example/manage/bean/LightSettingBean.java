package com.example.manage.bean;

import java.util.List;

public class LightSettingBean {


    /**
     * code : 0000
     * data : {"timingon":true,"openTime":"17:40","endTime":"17:43","days":["2020-01-18"]}
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
         * openTime : 17:40
         * endTime : 17:43
         * days : ["2020-01-18"]
         */

        private boolean timingon;
        private String openTime;
        private String endTime;
        private List<String> days;

        public boolean isTimingon() {
            return timingon;
        }

        public void setTimingon(boolean timingon) {
            this.timingon = timingon;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public List<String> getDays() {
            return days;
        }

        public void setDays(List<String> days) {
            this.days = days;
        }
    }
}
