package com.example.manage.bean;

import java.util.List;

public class TrushLastestBean {

    /**
     * code :
     * data : {"list":[{"todayrecovery":0,"todaydonation":0,"eid":101,"nowrecovery":0,"totaldonation":0,"todayprint":1,"overalam":0.8,"todayreturn":0,"totalreturn":0,"totalprint":0,"totalcarbon":0,"totalrecovery":0},{"todayrecovery":0,"todaydonation":0,"eid":102,"nowrecovery":0,"totaldonation":0,"todayprint":1,"overalam":0.4,"todayreturn":0,"totalreturn":0,"totalprint":0,"totalcarbon":0,"totalrecovery":0}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * todayrecovery : 0
             * todaydonation : 0
             * eid : 101
             * nowrecovery : 0
             * totaldonation : 0
             * todayprint : 1
             * overalam : 0.8
             * todayreturn : 0
             * totalreturn : 0
             * totalprint : 0
             * totalcarbon : 0
             * totalrecovery : 0
             */

            private int todayrecovery;
            private int todaydonation;
            private int eid;
            private int nowrecovery;
            private int totaldonation;
            private int todayprint;
            private double overalam;
            private int todayreturn;
            private int totalreturn;
            private int totalprint;
            private int totalcarbon;
            private int totalrecovery;

            public int getTodayrecovery() {
                return todayrecovery;
            }

            public void setTodayrecovery(int todayrecovery) {
                this.todayrecovery = todayrecovery;
            }

            public int getTodaydonation() {
                return todaydonation;
            }

            public void setTodaydonation(int todaydonation) {
                this.todaydonation = todaydonation;
            }

            public int getEid() {
                return eid;
            }

            public void setEid(int eid) {
                this.eid = eid;
            }

            public int getNowrecovery() {
                return nowrecovery;
            }

            public void setNowrecovery(int nowrecovery) {
                this.nowrecovery = nowrecovery;
            }

            public int getTotaldonation() {
                return totaldonation;
            }

            public void setTotaldonation(int totaldonation) {
                this.totaldonation = totaldonation;
            }

            public int getTodayprint() {
                return todayprint;
            }

            public void setTodayprint(int todayprint) {
                this.todayprint = todayprint;
            }

            public double getOveralam() {
                return overalam;
            }

            public void setOveralam(double overalam) {
                this.overalam = overalam;
            }

            public int getTodayreturn() {
                return todayreturn;
            }

            public void setTodayreturn(int todayreturn) {
                this.todayreturn = todayreturn;
            }

            public int getTotalreturn() {
                return totalreturn;
            }

            public void setTotalreturn(int totalreturn) {
                this.totalreturn = totalreturn;
            }

            public int getTotalprint() {
                return totalprint;
            }

            public void setTotalprint(int totalprint) {
                this.totalprint = totalprint;
            }

            public int getTotalcarbon() {
                return totalcarbon;
            }

            public void setTotalcarbon(int totalcarbon) {
                this.totalcarbon = totalcarbon;
            }

            public int getTotalrecovery() {
                return totalrecovery;
            }

            public void setTotalrecovery(int totalrecovery) {
                this.totalrecovery = totalrecovery;
            }
        }
    }
}
