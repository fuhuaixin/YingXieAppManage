package com.example.manage.bean;

import java.io.Serializable;
import java.util.List;

public class EquListBean implements Serializable {

    /**
     * Result : [{"list":[{"message":"我有一只小狗我有一只小狗我有一只小狗我有一只小狗"},{"message":"我有一只小狗我有一只小狗我有一只小狗我有一只小狗"}],"title":"我有一只小狗"},{"list":[{"message":"我有一只小狗我有一只小狗我有一只小狗我有一只小狗"}],"title":"我有一只小狗"}]
     * StatusCode : 200
     * Success : true
     */

    private int StatusCode;
    private boolean Success;
    private List<ResultBean> Result;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public List<ResultBean> getResult() {
        return Result;
    }

    public void setResult(List<ResultBean> Result) {
        this.Result = Result;
    }

    public static class ResultBean {

        public ResultBean(Boolean state, String title, Boolean titleStatus, List<ListBean> list) {
            this.state = state;
            this.title = title;
            this.titleStatus = titleStatus;
            this.list = list;
        }

        /**
         * list : [{"message":"我有一只小狗我有一只小狗我有一只小狗我有一只小狗"},{"message":"我有一只小狗我有一只小狗我有一只小狗我有一只小狗"}]
         * title : 我有一只小狗
         */


        private Boolean state;
        private String title;
        private Boolean titleStatus;
        private List<ListBean> list;

        public Boolean getState() {
            return state;
        }

        public Boolean getTitleStatus() {
            return titleStatus;
        }

        public void setTitleStatus(Boolean titleStatus) {
            this.titleStatus = titleStatus;
        }

        public void setState(Boolean state) {
            this.state = state;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            public ListBean(String message, int status) {
                this.message = message;
                this.status = status;
            }

            /**
             * message : 我有一只小狗我有一只小狗我有一只小狗我有一只小狗
             */


            private String message;
            private int status;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }
    }
}
