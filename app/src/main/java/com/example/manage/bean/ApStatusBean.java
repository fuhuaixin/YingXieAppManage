package com.example.manage.bean;

import java.io.Serializable;
import java.util.List;


public class ApStatusBean implements Serializable {

    /**
     * code : 0000
     * data : {"data":[{"id":"11257479553635516416","group_id":0,"local_id":"8086902557500768256","name":"ROOT-2-AB","group":"默认组","ip":"10.10.10.15","usercount":0,"send":0,"recv":0,"joinTime":"2020-04-16 17:35:31","status":1,"alarm_time":0,"workmodel":"normal","position":"有线","mac":"9C-3A-9A-02-64-AB","type":"","sn":"C4Y9410117","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553644167168","group_id":0,"local_id":"8086902557500768256","name":"CLIENT-1-2F","group":"默认组","ip":"10.10.10.7","usercount":1,"send":591174.8,"recv":8202.6,"joinTime":"2020-04-25 16:11:42","status":1,"alarm_time":0,"workmodel":"normal","position":"接收C9","mac":"9C-3A-9A-02-65-2F","type":"","sn":"C4Y9410249","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553637482496","group_id":0,"local_id":"8086902557500768256","name":"ROOT-1-C9","group":"默认组","ip":"10.10.10.8","usercount":2,"send":11.7,"recv":7.7,"joinTime":"2020-04-16 17:35:31","status":1,"alarm_time":0,"workmodel":"normal","position":"有线","mac":"9C-3A-9A-02-64-C9","type":"","sn":"C4Y9410147","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553637548032","group_id":0,"local_id":"8086902557500768256","name":"CLIENT-2-CA","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"2020-04-22 16:09:35","status":2,"alarm_time":0,"workmodel":"-","position":"接收AB","mac":"9C-3A-9A-02-64-CA","type":"","sn":"C4Y9410148","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":1,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553642528768","group_id":0,"local_id":0,"name":"CLIENT-2-16","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"接受AB","mac":"9C-3A-9A-02-65-16","type":"","sn":"C4Y9410224","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553635319808","group_id":0,"local_id":0,"name":"64_A8","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"上联16","mac":"9C-3A-9A-02-64-A8","type":"","sn":"C4Y9410114","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553632305152","group_id":0,"local_id":0,"name":"64-7A","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"上联16","mac":"9C-3A-9A-02-64-7A","type":"","sn":"C4Y9410068","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"}],"onlineCount":3,"offlineCount":4,"depositCount":0,"centerAuthCount":0,"total":7,"success":true}
     * message : 查询成功
     * status : true
     */

    private String code;
    private DataBeanX data;
    private String message;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX implements Serializable {
        /**
         * data : [{"id":"11257479553635516416","group_id":0,"local_id":"8086902557500768256","name":"ROOT-2-AB","group":"默认组","ip":"10.10.10.15","usercount":0,"send":0,"recv":0,"joinTime":"2020-04-16 17:35:31","status":1,"alarm_time":0,"workmodel":"normal","position":"有线","mac":"9C-3A-9A-02-64-AB","type":"","sn":"C4Y9410117","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553644167168","group_id":0,"local_id":"8086902557500768256","name":"CLIENT-1-2F","group":"默认组","ip":"10.10.10.7","usercount":1,"send":591174.8,"recv":8202.6,"joinTime":"2020-04-25 16:11:42","status":1,"alarm_time":0,"workmodel":"normal","position":"接收C9","mac":"9C-3A-9A-02-65-2F","type":"","sn":"C4Y9410249","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553637482496","group_id":0,"local_id":"8086902557500768256","name":"ROOT-1-C9","group":"默认组","ip":"10.10.10.8","usercount":2,"send":11.7,"recv":7.7,"joinTime":"2020-04-16 17:35:31","status":1,"alarm_time":0,"workmodel":"normal","position":"有线","mac":"9C-3A-9A-02-64-C9","type":"","sn":"C4Y9410147","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"WAC_8D6C8025(10.10.10.1)","connection":1,"wlan_count":1,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553637548032","group_id":0,"local_id":"8086902557500768256","name":"CLIENT-2-CA","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"2020-04-22 16:09:35","status":2,"alarm_time":0,"workmodel":"-","position":"接收AB","mac":"9C-3A-9A-02-64-CA","type":"","sn":"C4Y9410148","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":1,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553642528768","group_id":0,"local_id":0,"name":"CLIENT-2-16","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"接受AB","mac":"9C-3A-9A-02-65-16","type":"","sn":"C4Y9410224","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553635319808","group_id":0,"local_id":0,"name":"64_A8","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"上联16","mac":"9C-3A-9A-02-64-A8","type":"","sn":"C4Y9410114","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"},{"id":"11257479553632305152","group_id":0,"local_id":0,"name":"64-7A","group":"默认组","ip":"-","usercount":"-","send":"-","recv":"-","joinTime":"-","status":2,"alarm_time":0,"workmodel":"-","position":"上联16","mac":"9C-3A-9A-02-64-7A","type":"","sn":"C4Y9410068","softVersion":"AP3.7.9.7 BUILD20191015-025251","hardVersion":"NAP-8100(L)","wac_name":"-","connection":0,"wlan_count":0,"apauth":"","wdscnt":"-","hw_ver":"ap-810-l","apvpn_status":false,"apvpn_conflict_msg":[],"wds_type":"-","branch_name":"-","gps":"-"}]
         * onlineCount : 3
         * offlineCount : 4
         * depositCount : 0
         * centerAuthCount : 0
         * total : 7
         * success : true
         */

        private int onlineCount;
        private int offlineCount;
        private int depositCount;
        private int centerAuthCount;
        private int total;
        private boolean success;
        private List<DataBean> data;

        public int getOnlineCount() {
            return onlineCount;
        }

        public void setOnlineCount(int onlineCount) {
            this.onlineCount = onlineCount;
        }

        public int getOfflineCount() {
            return offlineCount;
        }

        public void setOfflineCount(int offlineCount) {
            this.offlineCount = offlineCount;
        }

        public int getDepositCount() {
            return depositCount;
        }

        public void setDepositCount(int depositCount) {
            this.depositCount = depositCount;
        }

        public int getCenterAuthCount() {
            return centerAuthCount;
        }

        public void setCenterAuthCount(int centerAuthCount) {
            this.centerAuthCount = centerAuthCount;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * id : 11257479553635516416
             * group_id : 0
             * local_id : 8086902557500768256
             * name : ROOT-2-AB
             * group : 默认组
             * ip : 10.10.10.15
             * usercount : 0
             * send : 0
             * recv : 0
             * joinTime : 2020-04-16 17:35:31
             * status : 1
             * alarm_time : 0
             * workmodel : normal
             * position : 有线
             * mac : 9C-3A-9A-02-64-AB
             * type :
             * sn : C4Y9410117
             * softVersion : AP3.7.9.7 BUILD20191015-025251
             * hardVersion : NAP-8100(L)
             * wac_name : WAC_8D6C8025(10.10.10.1)
             * connection : 1
             * wlan_count : 1
             * apauth : AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决
             * wdscnt : -
             * hw_ver : ap-810-l
             * apvpn_status : false
             * apvpn_conflict_msg : []
             * wds_type : -
             * branch_name : -
             * gps : -
             */

            private String id;
            private int group_id;
            private String local_id;
            private String name;
            private String group;
            private String ip;
            private String usercount;
            private String send;
            private String recv;
            private String joinTime;
            private int status;
            private int alarm_time;
            private String workmodel;
            private String position;
            private String mac;
            private String type;
            private String sn;
            private String softVersion;
            private String hardVersion;
            private String wac_name;
            private int connection;
            private int wlan_count;
            private String apauth;
            private String wdscnt;
            private String hw_ver;
            private boolean apvpn_status;
            private String wds_type;
            private String branch_name;
            private String gps;
            private List<?> apvpn_conflict_msg;

            public String getUsercount() {
                return usercount;
            }

            public void setUsercount(String usercount) {
                this.usercount = usercount;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getGroup_id() {
                return group_id;
            }

            public void setGroup_id(int group_id) {
                this.group_id = group_id;
            }

            public String getLocal_id() {
                return local_id;
            }

            public void setLocal_id(String local_id) {
                this.local_id = local_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public String getSend() {
                return send;
            }

            public void setSend(String send) {
                this.send = send;
            }

            public String getRecv() {
                return recv;
            }

            public void setRecv(String recv) {
                this.recv = recv;
            }

            public String getJoinTime() {
                return joinTime;
            }

            public void setJoinTime(String joinTime) {
                this.joinTime = joinTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getAlarm_time() {
                return alarm_time;
            }

            public void setAlarm_time(int alarm_time) {
                this.alarm_time = alarm_time;
            }

            public String getWorkmodel() {
                return workmodel;
            }

            public void setWorkmodel(String workmodel) {
                this.workmodel = workmodel;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getMac() {
                return mac;
            }

            public void setMac(String mac) {
                this.mac = mac;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getSoftVersion() {
                return softVersion;
            }

            public void setSoftVersion(String softVersion) {
                this.softVersion = softVersion;
            }

            public String getHardVersion() {
                return hardVersion;
            }

            public void setHardVersion(String hardVersion) {
                this.hardVersion = hardVersion;
            }

            public String getWac_name() {
                return wac_name;
            }

            public void setWac_name(String wac_name) {
                this.wac_name = wac_name;
            }

            public int getConnection() {
                return connection;
            }

            public void setConnection(int connection) {
                this.connection = connection;
            }

            public int getWlan_count() {
                return wlan_count;
            }

            public void setWlan_count(int wlan_count) {
                this.wlan_count = wlan_count;
            }

            public String getApauth() {
                return apauth;
            }

            public void setApauth(String apauth) {
                this.apauth = apauth;
            }

            public String getWdscnt() {
                return wdscnt;
            }

            public void setWdscnt(String wdscnt) {
                this.wdscnt = wdscnt;
            }

            public String getHw_ver() {
                return hw_ver;
            }

            public void setHw_ver(String hw_ver) {
                this.hw_ver = hw_ver;
            }

            public boolean isApvpn_status() {
                return apvpn_status;
            }

            public void setApvpn_status(boolean apvpn_status) {
                this.apvpn_status = apvpn_status;
            }

            public String getWds_type() {
                return wds_type;
            }

            public void setWds_type(String wds_type) {
                this.wds_type = wds_type;
            }

            public String getBranch_name() {
                return branch_name;
            }

            public void setBranch_name(String branch_name) {
                this.branch_name = branch_name;
            }

            public String getGps() {
                return gps;
            }

            public void setGps(String gps) {
                this.gps = gps;
            }

            public List<?> getApvpn_conflict_msg() {
                return apvpn_conflict_msg;
            }

            public void setApvpn_conflict_msg(List<?> apvpn_conflict_msg) {
                this.apvpn_conflict_msg = apvpn_conflict_msg;
            }
        }
    }
}
