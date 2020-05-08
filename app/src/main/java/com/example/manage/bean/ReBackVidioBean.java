package com.example.manage.bean;

public class ReBackVidioBean {


    /**
     * code :
     * data : http://127.0.0.1:8073/live/f71dad6c70c54964b33a7c1471ee89e9.flv?sign=1588003199-f5c6bbd47c98e32022341382f661a4de
     * message :
     * status : true
     */

    private String code;
    private String data;
    private String message;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}
