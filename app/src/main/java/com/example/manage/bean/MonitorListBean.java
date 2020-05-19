package com.example.manage.bean;

import java.util.List;

public class MonitorListBean{

    /**
     * code : 0000
     * data : {"ableVideos":{"live":{"banhezhan1":{"publisher":{"app":"live","bytes":2961073,"clientId":"PA3C6UIS","connectCreated":"2020-04-27T05:43:17.813Z","ip":"::ffff:127.0.0.1","stream":"banhezhan1","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"banhezhan2":{"publisher":{"app":"live","bytes":11539113,"clientId":"BWV97K6N","connectCreated":"2020-04-27T05:24:14.488Z","ip":"::ffff:127.0.0.1","stream":"banhezhan2","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"yxl_4":{"publisher":{"app":"live","bytes":29910129828,"clientId":"LKPODOV8","connectCreated":"2020-04-26T13:11:11.102Z","ip":"::ffff:127.0.0.1","stream":"yxl_4","video":{"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}},"subscribers":[]}}},"allVideoUrl":[{"videoid":"df999669-0727-07c0-9478-9f24525ce49b","videoname":"燕庄社区西门枪机","videourl":"http://111.6.98.254:8073/live/yxl_6.flv?sign=4100731932000-ce3262542a3f433c3a5c1c98c11f0f66"},{"videoid":"895eb633-c7a3-6b03-0c6e-c847412bb2f8","videoname":"测试视频","videourl":"http://111.6.98.254:8073/live/yxl_5.flv?sign=4100731932000-cd237fd267dfaf6a375c1c4ee4a64418"},{"videoid":"cfeead32-d31d-acce-fe34-db0a4ed75fde","videoname":"燕庄社区西门广场","videourl":""},{"videoid":"96b2f121-910b-20dd-4637-b51ea59fe3b1","videoname":"IPdome","videourl":""},{"videoid":"f3c53d75-6add-49e1-d8a8-1ff4e8caa907","videoname":"菜市场门口","videourl":"http://111.6.98.254:8073/live/yxl_1.flv?sign=4100731932000-44e1e2636a3bc68c9d9d9b35c3ffdd8e"},{"videoid":"fd6bda5a-5b52-b6dd-ee92-01914224c9eb","videoname":"投影处球机","videourl":"http://111.6.98.254:8073/live/yxl_4.flv?sign=4100731932000-c671c4341e3bf539d1f462e864644262"}]}
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
         * ableVideos : {"live":{"banhezhan1":{"publisher":{"app":"live","bytes":2961073,"clientId":"PA3C6UIS","connectCreated":"2020-04-27T05:43:17.813Z","ip":"::ffff:127.0.0.1","stream":"banhezhan1","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"banhezhan2":{"publisher":{"app":"live","bytes":11539113,"clientId":"BWV97K6N","connectCreated":"2020-04-27T05:24:14.488Z","ip":"::ffff:127.0.0.1","stream":"banhezhan2","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"yxl_4":{"publisher":{"app":"live","bytes":29910129828,"clientId":"LKPODOV8","connectCreated":"2020-04-26T13:11:11.102Z","ip":"::ffff:127.0.0.1","stream":"yxl_4","video":{"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}},"subscribers":[]}}}
         * allVideoUrl : [{"videoid":"df999669-0727-07c0-9478-9f24525ce49b","videoname":"燕庄社区西门枪机","videourl":"http://111.6.98.254:8073/live/yxl_6.flv?sign=4100731932000-ce3262542a3f433c3a5c1c98c11f0f66"},{"videoid":"895eb633-c7a3-6b03-0c6e-c847412bb2f8","videoname":"测试视频","videourl":"http://111.6.98.254:8073/live/yxl_5.flv?sign=4100731932000-cd237fd267dfaf6a375c1c4ee4a64418"},{"videoid":"cfeead32-d31d-acce-fe34-db0a4ed75fde","videoname":"燕庄社区西门广场","videourl":""},{"videoid":"96b2f121-910b-20dd-4637-b51ea59fe3b1","videoname":"IPdome","videourl":""},{"videoid":"f3c53d75-6add-49e1-d8a8-1ff4e8caa907","videoname":"菜市场门口","videourl":"http://111.6.98.254:8073/live/yxl_1.flv?sign=4100731932000-44e1e2636a3bc68c9d9d9b35c3ffdd8e"},{"videoid":"fd6bda5a-5b52-b6dd-ee92-01914224c9eb","videoname":"投影处球机","videourl":"http://111.6.98.254:8073/live/yxl_4.flv?sign=4100731932000-c671c4341e3bf539d1f462e864644262"}]
         */

        private AbleVideosBean ableVideos;
        private List<AllVideoUrlBean> allVideoUrl;

        public AbleVideosBean getAbleVideos() {
            return ableVideos;
        }

        public void setAbleVideos(AbleVideosBean ableVideos) {
            this.ableVideos = ableVideos;
        }

        public List<AllVideoUrlBean> getAllVideoUrl() {
            return allVideoUrl;
        }

        public void setAllVideoUrl(List<AllVideoUrlBean> allVideoUrl) {
            this.allVideoUrl = allVideoUrl;
        }

        public static class AbleVideosBean {
            /**
             * live : {"banhezhan1":{"publisher":{"app":"live","bytes":2961073,"clientId":"PA3C6UIS","connectCreated":"2020-04-27T05:43:17.813Z","ip":"::ffff:127.0.0.1","stream":"banhezhan1","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"banhezhan2":{"publisher":{"app":"live","bytes":11539113,"clientId":"BWV97K6N","connectCreated":"2020-04-27T05:24:14.488Z","ip":"::ffff:127.0.0.1","stream":"banhezhan2","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]},"yxl_4":{"publisher":{"app":"live","bytes":29910129828,"clientId":"LKPODOV8","connectCreated":"2020-04-26T13:11:11.102Z","ip":"::ffff:127.0.0.1","stream":"yxl_4","video":{"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}},"subscribers":[]}}
             */

            private LiveBean live;

            public LiveBean getLive() {
                return live;
            }

            public void setLive(LiveBean live) {
                this.live = live;
            }

            public static class LiveBean {
                /**
                 * banhezhan1 : {"publisher":{"app":"live","bytes":2961073,"clientId":"PA3C6UIS","connectCreated":"2020-04-27T05:43:17.813Z","ip":"::ffff:127.0.0.1","stream":"banhezhan1","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]}
                 * banhezhan2 : {"publisher":{"app":"live","bytes":11539113,"clientId":"BWV97K6N","connectCreated":"2020-04-27T05:24:14.488Z","ip":"::ffff:127.0.0.1","stream":"banhezhan2","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}},"subscribers":[]}
                 * yxl_4 : {"publisher":{"app":"live","bytes":29910129828,"clientId":"LKPODOV8","connectCreated":"2020-04-26T13:11:11.102Z","ip":"::ffff:127.0.0.1","stream":"yxl_4","video":{"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}},"subscribers":[]}
                 */

                private Banhezhan1Bean banhezhan1;
                private Banhezhan2Bean banhezhan2;
                private Yxl4Bean yxl_4;

                public Banhezhan1Bean getBanhezhan1() {
                    return banhezhan1;
                }

                public void setBanhezhan1(Banhezhan1Bean banhezhan1) {
                    this.banhezhan1 = banhezhan1;
                }

                public Banhezhan2Bean getBanhezhan2() {
                    return banhezhan2;
                }

                public void setBanhezhan2(Banhezhan2Bean banhezhan2) {
                    this.banhezhan2 = banhezhan2;
                }

                public Yxl4Bean getYxl_4() {
                    return yxl_4;
                }

                public void setYxl_4(Yxl4Bean yxl_4) {
                    this.yxl_4 = yxl_4;
                }

                public static class Banhezhan1Bean {
                    /**
                     * publisher : {"app":"live","bytes":2961073,"clientId":"PA3C6UIS","connectCreated":"2020-04-27T05:43:17.813Z","ip":"::ffff:127.0.0.1","stream":"banhezhan1","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}}
                     * subscribers : []
                     */

                    private PublisherBean publisher;
                    private List<?> subscribers;

                    public PublisherBean getPublisher() {
                        return publisher;
                    }

                    public void setPublisher(PublisherBean publisher) {
                        this.publisher = publisher;
                    }

                    public List<?> getSubscribers() {
                        return subscribers;
                    }

                    public void setSubscribers(List<?> subscribers) {
                        this.subscribers = subscribers;
                    }

                    public static class PublisherBean {
                        /**
                         * app : live
                         * bytes : 2961073
                         * clientId : PA3C6UIS
                         * connectCreated : 2020-04-27T05:43:17.813Z
                         * ip : ::ffff:127.0.0.1
                         * stream : banhezhan1
                         * video : {"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}
                         */

                        private String app;
                        private long bytes;
                        private String clientId;
                        private String connectCreated;
                        private String ip;
                        private String stream;
                        private VideoBean video;

                        public String getApp() {
                            return app;
                        }

                        public void setApp(String app) {
                            this.app = app;
                        }

                        public long getBytes() {
                            return bytes;
                        }

                        public void setBytes(long bytes) {
                            this.bytes = bytes;
                        }

                        public String getClientId() {
                            return clientId;
                        }

                        public void setClientId(String clientId) {
                            this.clientId = clientId;
                        }

                        public String getConnectCreated() {
                            return connectCreated;
                        }

                        public void setConnectCreated(String connectCreated) {
                            this.connectCreated = connectCreated;
                        }

                        public String getIp() {
                            return ip;
                        }

                        public void setIp(String ip) {
                            this.ip = ip;
                        }

                        public String getStream() {
                            return stream;
                        }

                        public void setStream(String stream) {
                            this.stream = stream;
                        }

                        public VideoBean getVideo() {
                            return video;
                        }

                        public void setVideo(VideoBean video) {
                            this.video = video;
                        }

                        public static class VideoBean {
                            /**
                             * codec : H264
                             * fps : 25
                             * height : 360
                             * level : 3
                             * profile : Main
                             * width : 640
                             */

                            private String codec;
                            private int fps;
                            private int height;
                            private int level;
                            private String profile;
                            private int width;

                            public String getCodec() {
                                return codec;
                            }

                            public void setCodec(String codec) {
                                this.codec = codec;
                            }

                            public int getFps() {
                                return fps;
                            }

                            public void setFps(int fps) {
                                this.fps = fps;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }

                            public int getLevel() {
                                return level;
                            }

                            public void setLevel(int level) {
                                this.level = level;
                            }

                            public String getProfile() {
                                return profile;
                            }

                            public void setProfile(String profile) {
                                this.profile = profile;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }
                        }
                    }
                }

                public static class Banhezhan2Bean {
                    /**
                     * publisher : {"app":"live","bytes":11539113,"clientId":"BWV97K6N","connectCreated":"2020-04-27T05:24:14.488Z","ip":"::ffff:127.0.0.1","stream":"banhezhan2","video":{"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}}
                     * subscribers : []
                     */

                    private PublisherBeanX publisher;
                    private List<?> subscribers;

                    public PublisherBeanX getPublisher() {
                        return publisher;
                    }

                    public void setPublisher(PublisherBeanX publisher) {
                        this.publisher = publisher;
                    }

                    public List<?> getSubscribers() {
                        return subscribers;
                    }

                    public void setSubscribers(List<?> subscribers) {
                        this.subscribers = subscribers;
                    }

                    public static class PublisherBeanX {
                        /**
                         * app : live
                         * bytes : 11539113
                         * clientId : BWV97K6N
                         * connectCreated : 2020-04-27T05:24:14.488Z
                         * ip : ::ffff:127.0.0.1
                         * stream : banhezhan2
                         * video : {"codec":"H264","fps":25,"height":360,"level":3,"profile":"Main","width":640}
                         */

                        private String app;
                        private long bytes;
                        private String clientId;
                        private String connectCreated;
                        private String ip;
                        private String stream;
                        private VideoBeanX video;

                        public String getApp() {
                            return app;
                        }

                        public void setApp(String app) {
                            this.app = app;
                        }

                        public long getBytes() {
                            return bytes;
                        }

                        public void setBytes(long bytes) {
                            this.bytes = bytes;
                        }

                        public String getClientId() {
                            return clientId;
                        }

                        public void setClientId(String clientId) {
                            this.clientId = clientId;
                        }

                        public String getConnectCreated() {
                            return connectCreated;
                        }

                        public void setConnectCreated(String connectCreated) {
                            this.connectCreated = connectCreated;
                        }

                        public String getIp() {
                            return ip;
                        }

                        public void setIp(String ip) {
                            this.ip = ip;
                        }

                        public String getStream() {
                            return stream;
                        }

                        public void setStream(String stream) {
                            this.stream = stream;
                        }

                        public VideoBeanX getVideo() {
                            return video;
                        }

                        public void setVideo(VideoBeanX video) {
                            this.video = video;
                        }

                        public static class VideoBeanX {
                            /**
                             * codec : H264
                             * fps : 25
                             * height : 360
                             * level : 3
                             * profile : Main
                             * width : 640
                             */

                            private String codec;
                            private int fps;
                            private int height;
                            private int level;
                            private String profile;
                            private int width;

                            public String getCodec() {
                                return codec;
                            }

                            public void setCodec(String codec) {
                                this.codec = codec;
                            }

                            public int getFps() {
                                return fps;
                            }

                            public void setFps(int fps) {
                                this.fps = fps;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }

                            public int getLevel() {
                                return level;
                            }

                            public void setLevel(int level) {
                                this.level = level;
                            }

                            public String getProfile() {
                                return profile;
                            }

                            public void setProfile(String profile) {
                                this.profile = profile;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }
                        }
                    }
                }

                public static class Yxl4Bean {
                    /**
                     * publisher : {"app":"live","bytes":29910129828,"clientId":"LKPODOV8","connectCreated":"2020-04-26T13:11:11.102Z","ip":"::ffff:127.0.0.1","stream":"yxl_4","video":{"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}}
                     * subscribers : []
                     */

                    private PublisherBeanXX publisher;
                    private List<?> subscribers;

                    public PublisherBeanXX getPublisher() {
                        return publisher;
                    }

                    public void setPublisher(PublisherBeanXX publisher) {
                        this.publisher = publisher;
                    }

                    public List<?> getSubscribers() {
                        return subscribers;
                    }

                    public void setSubscribers(List<?> subscribers) {
                        this.subscribers = subscribers;
                    }

                    public static class PublisherBeanXX {
                        /**
                         * app : live
                         * bytes : 29910129828
                         * clientId : LKPODOV8
                         * connectCreated : 2020-04-26T13:11:11.102Z
                         * ip : ::ffff:127.0.0.1
                         * stream : yxl_4
                         * video : {"codec":"H264","fps":25,"height":2144,"level":4.2,"profile":"High","width":128}
                         */

                        private String app;
                        private long bytes;
                        private String clientId;
                        private String connectCreated;
                        private String ip;
                        private String stream;
                        private VideoBeanXX video;

                        public String getApp() {
                            return app;
                        }

                        public void setApp(String app) {
                            this.app = app;
                        }

                        public long getBytes() {
                            return bytes;
                        }

                        public void setBytes(long bytes) {
                            this.bytes = bytes;
                        }

                        public String getClientId() {
                            return clientId;
                        }

                        public void setClientId(String clientId) {
                            this.clientId = clientId;
                        }

                        public String getConnectCreated() {
                            return connectCreated;
                        }

                        public void setConnectCreated(String connectCreated) {
                            this.connectCreated = connectCreated;
                        }

                        public String getIp() {
                            return ip;
                        }

                        public void setIp(String ip) {
                            this.ip = ip;
                        }

                        public String getStream() {
                            return stream;
                        }

                        public void setStream(String stream) {
                            this.stream = stream;
                        }

                        public VideoBeanXX getVideo() {
                            return video;
                        }

                        public void setVideo(VideoBeanXX video) {
                            this.video = video;
                        }

                        public static class VideoBeanXX {
                            /**
                             * codec : H264
                             * fps : 25
                             * height : 2144
                             * level : 4.2
                             * profile : High
                             * width : 128
                             */

                            private String codec;
                            private int fps;
                            private int height;
                            private double level;
                            private String profile;
                            private int width;

                            public String getCodec() {
                                return codec;
                            }

                            public void setCodec(String codec) {
                                this.codec = codec;
                            }

                            public int getFps() {
                                return fps;
                            }

                            public void setFps(int fps) {
                                this.fps = fps;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }

                            public double getLevel() {
                                return level;
                            }

                            public void setLevel(double level) {
                                this.level = level;
                            }

                            public String getProfile() {
                                return profile;
                            }

                            public void setProfile(String profile) {
                                this.profile = profile;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }
                        }
                    }
                }
            }
        }

        public static class AllVideoUrlBean {
            /**
             * videoid : df999669-0727-07c0-9478-9f24525ce49b
             * videoname : 燕庄社区西门枪机
             * videourl : http://111.6.98.254:8073/live/yxl_6.flv?sign=4100731932000-ce3262542a3f433c3a5c1c98c11f0f66
             */

            private String videoid;
            private String videoname;
            private String videourl;
            private String img;
            private String idname;
            private String historyurl;

            public String getHistoryurl() {
                return historyurl;
            }

            public void setHistoryurl(String historyurl) {
                this.historyurl = historyurl;
            }

            public String getIdname() {
                return idname;
            }

            public void setIdname(String idname) {
                this.idname = idname;
            }
            public String getVideoid() {
                return videoid;
            }

            public void setVideoid(String videoid) {
                this.videoid = videoid;
            }

            public String getVideoname() {
                return videoname;
            }

            public void setVideoname(String videoname) {
                this.videoname = videoname;
            }

            public String getVideourl() {
                return videourl;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}