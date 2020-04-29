package com.example.manage.bean;

import java.util.List;

public class StatisticBean {

    /**
     * code : 0000
     * data : {"statis":[{"poiclass":"gouwu","num":221},{"poiclass":"shenghuofuwu","num":35},{"poiclass":"canyin","num":102},{"poiclass":"dichanxiaoqu","num":107},{"poiclass":"xiuxianyule","num":23},{"poiclass":"jinrong","num":18}]}
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
        private List<StatisBean> statis;

        public List<StatisBean> getStatis() {
            return statis;
        }

        public void setStatis(List<StatisBean> statis) {
            this.statis = statis;
        }

        public static class StatisBean {
            /**
             * poiclass : gouwu
             * num : 221
             */

            private String poiclass;
            private int num;

            public String getPoiclass() {
                return poiclass;
            }

            public void setPoiclass(String poiclass) {
                this.poiclass = poiclass;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
