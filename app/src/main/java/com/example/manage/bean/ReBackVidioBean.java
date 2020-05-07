package com.example.manage.bean;

import java.util.List;

public class ReBackVidioBean {

    /**
     * code : 0000
     * data : [{"endTime":"","fileName":"ch0004_00000002819000000","fileSize":"","startTime":""},{"endTime":"","fileName":"ch0004_00000002819000000","fileSize":"","startTime":""}]
     * message :
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
         * endTime :
         * fileName : ch0004_00000002819000000
         * fileSize :
         * startTime :
         */

        private String endTime;
        private String fileSize;
        private String startTime;

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }


        public String getFileSize() {
            return fileSize;
        }

        public void setFileSize(String fileSize) {
            this.fileSize = fileSize;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }
}
