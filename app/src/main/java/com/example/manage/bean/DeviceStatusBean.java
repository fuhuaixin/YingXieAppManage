package com.example.manage.bean;

import java.util.List;

public class DeviceStatusBean {


    /**
     * code : 0000
     * data : {"alarmStatus":false,"apInfo":{"centerAuthCount":0,"data":[{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635516416","ip":"10.10.10.15","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-AB","name":"ROOT-2-AB","position":"有线","recv":0,"send":0,"sn":"C4Y9410117","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":0,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553644167168","ip":"10.10.10.7","joinTime":"2020-05-06 02:39:53","local_id":"8086902557500768256","mac":"9C-3A-9A-02-65-2F","name":"CLIENT-1-2F","position":"接收C9","recv":9292.8,"send":587981.2,"sn":"C4Y9410249","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":1,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637482496","ip":"10.10.10.8","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-C9","name":"ROOT-1-C9","position":"有线","recv":129355.3,"send":4573.5,"sn":"C4Y9410147","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":2,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637548032","ip":"-","joinTime":"2020-05-01 15:15:45","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-CA","name":"CLIENT-2-CA","position":"接收AB","recv":"-","send":"-","sn":"C4Y9410148","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553642528768","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-65-16","name":"CLIENT-2-16","position":"接受AB","recv":"-","send":"-","sn":"C4Y9410224","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635319808","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-A8","name":"64_A8","position":"上联16","recv":"-","send":"-","sn":"C4Y9410114","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553632305152","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-7A","name":"64-7A","position":"上联16","recv":"-","send":"-","sn":"C4Y9410068","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"}],"depositCount":0,"offlineCount":4,"onlineCount":3,"success":true,"total":7},"cameraList":[{"channelNo":"ch33","ipStr":"10.10.10.150","name":"IPCamera1","portStr":"8000","status":0},{"channelNo":"ch34","ipStr":"192.168.1.64","name":"IPCamera2","portStr":"8000","status":0},{"channelNo":"ch35","ipStr":"172.16.101.14","name":"IPCamera3","portStr":"8000","status":0},{"channelNo":"ch36","ipStr":"172.16.101.141","name":"IPCamera4","portStr":"8000","status":1},{"channelNo":"ch37","ipStr":"172.16.101.140","name":"IPCamera5","portStr":"8000","status":0},{"channelNo":"ch38","ipStr":"172.16.101.142","name":"IPCamera6","portStr":"8000","status":0},{"channelNo":"ch39","ipStr":"192.168.1.64","name":"IPCamera7","portStr":"8000","status":0}],"envMonitor":true,"fogStatus":{"deviceKey":"97347","deviceStatus":2,"realyName":"40046486继电器1","relayID":0,"status":1},"lightStatus":{"deviceKey":"71142","deviceStatus":2,"realyName":"英协路智慧街道投影电脑","relayID":0,"status":1},"screenStatus":false}
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

    public static class DataBeanX {
        /**
         * alarmStatus : false
         * apInfo : {"centerAuthCount":0,"data":[{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635516416","ip":"10.10.10.15","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-AB","name":"ROOT-2-AB","position":"有线","recv":0,"send":0,"sn":"C4Y9410117","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":0,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553644167168","ip":"10.10.10.7","joinTime":"2020-05-06 02:39:53","local_id":"8086902557500768256","mac":"9C-3A-9A-02-65-2F","name":"CLIENT-1-2F","position":"接收C9","recv":9292.8,"send":587981.2,"sn":"C4Y9410249","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":1,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637482496","ip":"10.10.10.8","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-C9","name":"ROOT-1-C9","position":"有线","recv":129355.3,"send":4573.5,"sn":"C4Y9410147","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":2,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637548032","ip":"-","joinTime":"2020-05-01 15:15:45","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-CA","name":"CLIENT-2-CA","position":"接收AB","recv":"-","send":"-","sn":"C4Y9410148","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553642528768","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-65-16","name":"CLIENT-2-16","position":"接受AB","recv":"-","send":"-","sn":"C4Y9410224","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635319808","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-A8","name":"64_A8","position":"上联16","recv":"-","send":"-","sn":"C4Y9410114","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553632305152","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-7A","name":"64-7A","position":"上联16","recv":"-","send":"-","sn":"C4Y9410068","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"}],"depositCount":0,"offlineCount":4,"onlineCount":3,"success":true,"total":7}
         * cameraList : [{"channelNo":"ch33","ipStr":"10.10.10.150","name":"IPCamera1","portStr":"8000","status":0},{"channelNo":"ch34","ipStr":"192.168.1.64","name":"IPCamera2","portStr":"8000","status":0},{"channelNo":"ch35","ipStr":"172.16.101.14","name":"IPCamera3","portStr":"8000","status":0},{"channelNo":"ch36","ipStr":"172.16.101.141","name":"IPCamera4","portStr":"8000","status":1},{"channelNo":"ch37","ipStr":"172.16.101.140","name":"IPCamera5","portStr":"8000","status":0},{"channelNo":"ch38","ipStr":"172.16.101.142","name":"IPCamera6","portStr":"8000","status":0},{"channelNo":"ch39","ipStr":"192.168.1.64","name":"IPCamera7","portStr":"8000","status":0}]
         * envMonitor : true
         * fogStatus : {"deviceKey":"97347","deviceStatus":2,"realyName":"40046486继电器1","relayID":0,"status":1}
         * lightStatus : {"deviceKey":"71142","deviceStatus":2,"realyName":"英协路智慧街道投影电脑","relayID":0,"status":1}
         * screenStatus : false
         */

        private boolean alarmStatus;
        private ApInfoBean apInfo;
        private boolean envMonitor;
        private FogStatusBean fogStatus;
        private LightStatusBean lightStatus;
        private boolean screenStatus;
        private List<CameraListBean> cameraList;

        public boolean isAlarmStatus() {
            return alarmStatus;
        }

        public void setAlarmStatus(boolean alarmStatus) {
            this.alarmStatus = alarmStatus;
        }

        public ApInfoBean getApInfo() {
            return apInfo;
        }

        public void setApInfo(ApInfoBean apInfo) {
            this.apInfo = apInfo;
        }

        public boolean isEnvMonitor() {
            return envMonitor;
        }

        public void setEnvMonitor(boolean envMonitor) {
            this.envMonitor = envMonitor;
        }

        public FogStatusBean getFogStatus() {
            return fogStatus;
        }

        public void setFogStatus(FogStatusBean fogStatus) {
            this.fogStatus = fogStatus;
        }

        public LightStatusBean getLightStatus() {
            return lightStatus;
        }

        public void setLightStatus(LightStatusBean lightStatus) {
            this.lightStatus = lightStatus;
        }

        public boolean isScreenStatus() {
            return screenStatus;
        }

        public void setScreenStatus(boolean screenStatus) {
            this.screenStatus = screenStatus;
        }

        public List<CameraListBean> getCameraList() {
            return cameraList;
        }

        public void setCameraList(List<CameraListBean> cameraList) {
            this.cameraList = cameraList;
        }

        public static class ApInfoBean {
            /**
             * centerAuthCount : 0
             * data : [{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635516416","ip":"10.10.10.15","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-AB","name":"ROOT-2-AB","position":"有线","recv":0,"send":0,"sn":"C4Y9410117","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":0,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553644167168","ip":"10.10.10.7","joinTime":"2020-05-06 02:39:53","local_id":"8086902557500768256","mac":"9C-3A-9A-02-65-2F","name":"CLIENT-1-2F","position":"接收C9","recv":9292.8,"send":587981.2,"sn":"C4Y9410249","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":1,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637482496","ip":"10.10.10.8","joinTime":"2020-04-16 17:35:31","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-C9","name":"ROOT-1-C9","position":"有线","recv":129355.3,"send":4573.5,"sn":"C4Y9410147","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":1,"type":"","usercount":2,"wac_name":"WAC_8D6C8025(10.10.10.1)","wds_type":"-","wdscnt":"-","wlan_count":1,"workmodel":"normal"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":1,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553637548032","ip":"-","joinTime":"2020-05-01 15:15:45","local_id":"8086902557500768256","mac":"9C-3A-9A-02-64-CA","name":"CLIENT-2-CA","position":"接收AB","recv":"-","send":"-","sn":"C4Y9410148","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553642528768","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-65-16","name":"CLIENT-2-16","position":"接受AB","recv":"-","send":"-","sn":"C4Y9410224","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553635319808","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-A8","name":"64_A8","position":"上联16","recv":"-","send":"-","sn":"C4Y9410114","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"},{"alarm_time":0,"apauth":"","apvpn_conflict_msg":[],"apvpn_status":false,"branch_name":"-","connection":0,"gps":"-","group":"默认组","group_id":0,"hardVersion":"NAP-8100(L)","hw_ver":"ap-810-l","id":"11257479553632305152","ip":"-","joinTime":"-","local_id":0,"mac":"9C-3A-9A-02-64-7A","name":"64-7A","position":"上联16","recv":"-","send":"-","sn":"C4Y9410068","softVersion":"AP3.7.9.7 BUILD20191015-025251","status":2,"type":"","usercount":"-","wac_name":"-","wds_type":"-","wdscnt":"-","wlan_count":0,"workmodel":"-"}]
             * depositCount : 0
             * offlineCount : 4
             * onlineCount : 3
             * success : true
             * total : 7
             */

            private int centerAuthCount;
            private int depositCount;
            private int offlineCount;
            private int onlineCount;
            private boolean success;
            private int total;
            private List<DataBean> data;

            public int getCenterAuthCount() {
                return centerAuthCount;
            }

            public void setCenterAuthCount(int centerAuthCount) {
                this.centerAuthCount = centerAuthCount;
            }

            public int getDepositCount() {
                return depositCount;
            }

            public void setDepositCount(int depositCount) {
                this.depositCount = depositCount;
            }

            public int getOfflineCount() {
                return offlineCount;
            }

            public void setOfflineCount(int offlineCount) {
                this.offlineCount = offlineCount;
            }

            public int getOnlineCount() {
                return onlineCount;
            }

            public void setOnlineCount(int onlineCount) {
                this.onlineCount = onlineCount;
            }

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * alarm_time : 0
                 * apauth : AP授权文件与WAC不匹配,具体请联系产品相关技术人员进行解决
                 * apvpn_conflict_msg : []
                 * apvpn_status : false
                 * branch_name : -
                 * connection : 1
                 * gps : -
                 * group : 默认组
                 * group_id : 0
                 * hardVersion : NAP-8100(L)
                 * hw_ver : ap-810-l
                 * id : 11257479553635516416
                 * ip : 10.10.10.15
                 * joinTime : 2020-04-16 17:35:31
                 * local_id : 8086902557500768256
                 * mac : 9C-3A-9A-02-64-AB
                 * name : ROOT-2-AB
                 * position : 有线
                 * recv : 0
                 * send : 0
                 * sn : C4Y9410117
                 * softVersion : AP3.7.9.7 BUILD20191015-025251
                 * status : 1
                 * type :
                 * usercount : 0
                 * wac_name : WAC_8D6C8025(10.10.10.1)
                 * wds_type : -
                 * wdscnt : -
                 * wlan_count : 1
                 * workmodel : normal
                 */

                private int alarm_time;
                private String apauth;
                private boolean apvpn_status;
                private String branch_name;
                private int connection;
                private String gps;
                private String group;
                private int group_id;
                private String hardVersion;
                private String hw_ver;
                private String id;
                private String ip;
                private String joinTime;
                private String local_id;
                private String mac;
                private String name;
                private String position;
                private String recv;
                private String send;
                private String sn;
                private String softVersion;
                private int status;
                private String type;
                private String usercount;
                private String wac_name;
                private String wds_type;
                private String wdscnt;
                private int wlan_count;
                private String workmodel;
                private List<?> apvpn_conflict_msg;

                public int getAlarm_time() {
                    return alarm_time;
                }

                public void setAlarm_time(int alarm_time) {
                    this.alarm_time = alarm_time;
                }

                public String getApauth() {
                    return apauth;
                }

                public void setApauth(String apauth) {
                    this.apauth = apauth;
                }

                public boolean isApvpn_status() {
                    return apvpn_status;
                }

                public void setApvpn_status(boolean apvpn_status) {
                    this.apvpn_status = apvpn_status;
                }

                public String getBranch_name() {
                    return branch_name;
                }

                public void setBranch_name(String branch_name) {
                    this.branch_name = branch_name;
                }

                public int getConnection() {
                    return connection;
                }

                public void setConnection(int connection) {
                    this.connection = connection;
                }

                public String getGps() {
                    return gps;
                }

                public void setGps(String gps) {
                    this.gps = gps;
                }

                public String getGroup() {
                    return group;
                }

                public void setGroup(String group) {
                    this.group = group;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getHardVersion() {
                    return hardVersion;
                }

                public void setHardVersion(String hardVersion) {
                    this.hardVersion = hardVersion;
                }

                public String getHw_ver() {
                    return hw_ver;
                }

                public void setHw_ver(String hw_ver) {
                    this.hw_ver = hw_ver;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getIp() {
                    return ip;
                }

                public void setIp(String ip) {
                    this.ip = ip;
                }

                public String getJoinTime() {
                    return joinTime;
                }

                public void setJoinTime(String joinTime) {
                    this.joinTime = joinTime;
                }

                public String getLocal_id() {
                    return local_id;
                }

                public void setLocal_id(String local_id) {
                    this.local_id = local_id;
                }

                public String getMac() {
                    return mac;
                }

                public void setMac(String mac) {
                    this.mac = mac;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getRecv() {
                    return recv;
                }

                public void setRecv(String recv) {
                    this.recv = recv;
                }

                public String getSend() {
                    return send;
                }

                public void setSend(String send) {
                    this.send = send;
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

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUsercount() {
                    return usercount;
                }

                public void setUsercount(String  usercount) {
                    this.usercount = usercount;
                }

                public String getWac_name() {
                    return wac_name;
                }

                public void setWac_name(String wac_name) {
                    this.wac_name = wac_name;
                }

                public String getWds_type() {
                    return wds_type;
                }

                public void setWds_type(String wds_type) {
                    this.wds_type = wds_type;
                }

                public String getWdscnt() {
                    return wdscnt;
                }

                public void setWdscnt(String wdscnt) {
                    this.wdscnt = wdscnt;
                }

                public int getWlan_count() {
                    return wlan_count;
                }

                public void setWlan_count(int wlan_count) {
                    this.wlan_count = wlan_count;
                }

                public String getWorkmodel() {
                    return workmodel;
                }

                public void setWorkmodel(String workmodel) {
                    this.workmodel = workmodel;
                }

                public List<?> getApvpn_conflict_msg() {
                    return apvpn_conflict_msg;
                }

                public void setApvpn_conflict_msg(List<?> apvpn_conflict_msg) {
                    this.apvpn_conflict_msg = apvpn_conflict_msg;
                }
            }
        }

        public static class FogStatusBean {
            /**
             * deviceKey : 97347
             * deviceStatus : 2
             * realyName : 40046486继电器1
             * relayID : 0
             * status : 1
             */

            private String deviceKey;
            private int deviceStatus;
            private String realyName;
            private int relayID;
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

            public String getRealyName() {
                return realyName;
            }

            public void setRealyName(String realyName) {
                this.realyName = realyName;
            }

            public int getRelayID() {
                return relayID;
            }

            public void setRelayID(int relayID) {
                this.relayID = relayID;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class LightStatusBean {
            /**
             * deviceKey : 71142
             * deviceStatus : 2
             * realyName : 英协路智慧街道投影电脑
             * relayID : 0
             * status : 1
             */

            private String deviceKey;
            private int deviceStatus;
            private String realyName;
            private int relayID;
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

            public String getRealyName() {
                return realyName;
            }

            public void setRealyName(String realyName) {
                this.realyName = realyName;
            }

            public int getRelayID() {
                return relayID;
            }

            public void setRelayID(int relayID) {
                this.relayID = relayID;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class CameraListBean {
            /**
             * channelNo : ch33
             * ipStr : 10.10.10.150
             * name : IPCamera1
             * portStr : 8000
             * status : 0
             */

            private String channelNo;
            private String ipStr;
            private String name;
            private String portStr;
            private int status;

            public String getChannelNo() {
                return channelNo;
            }

            public void setChannelNo(String channelNo) {
                this.channelNo = channelNo;
            }

            public String getIpStr() {
                return ipStr;
            }

            public void setIpStr(String ipStr) {
                this.ipStr = ipStr;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPortStr() {
                return portStr;
            }

            public void setPortStr(String portStr) {
                this.portStr = portStr;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
