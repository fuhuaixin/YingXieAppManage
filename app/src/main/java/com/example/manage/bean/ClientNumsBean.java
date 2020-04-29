package com.example.manage.bean;

public class ClientNumsBean {

    /**
     * code : 0000
     * data : {"onlineusernum":3,"stackusernum":24}
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
         * onlineusernum : 3
         * stackusernum : 24
         */

        private int onlineusernum;
        private int stackusernum;

        public int getOnlineusernum() {
            return onlineusernum;
        }

        public void setOnlineusernum(int onlineusernum) {
            this.onlineusernum = onlineusernum;
        }

        public int getStackusernum() {
            return stackusernum;
        }

        public void setStackusernum(int stackusernum) {
            this.stackusernum = stackusernum;
        }
    }
}
