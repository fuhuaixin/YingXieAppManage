package com.example.manage.bean;

import java.util.List;

public class MainDevicesBean {

    /**
     * type : FeatureCollection
     * features : [{"type":"Feature","properties":{"devType":"envMonitor","height":3.9},"geometry":{"type":"Point","coordinates":[113.71190456495687,34.76297940075958]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera1","channelNo":"ch33","height":0.3},"geometry":{"type":"Point","coordinates":[113.71244737461768,34.75990757344383]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera2","channelNo":"ch34","height":0.3},"geometry":{"type":"Point","coordinates":[113.71260167404573,34.75714847926748]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera3","channelNo":"ch35","height":0.3},"geometry":{"type":"Point","coordinates":[113.71262972866185,34.75714875870698]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera4","channelNo":"ch36","height":2.3},"geometry":{"type":"Point","coordinates":[113.71190553999445,34.76297748040258]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera5","channelNo":"ch37","height":0.3},"geometry":{"type":"Point","coordinates":[113.71259802025543,34.756959778453414]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera6","channelNo":"ch38","height":0.3},"geometry":{"type":"Point","coordinates":[113.7124714192648,34.75521228666206]}},{"type":"Feature","properties":{"devType":"camera","name":"IPCamera7","channelNo":"ch39","height":0.3},"geometry":{"type":"Point","coordinates":[113.7124441237693,34.75377133489636]}},{"type":"Feature","properties":{"devType":"spray","height":1},"geometry":{"type":"Point","coordinates":[113.71179741035242,34.76287837932714]}},{"type":"Feature","properties":{"devType":"wifi","name":"64-7A","id":"11257479553632305152","label":"投影处AP"},"geometry":{"type":"Point","coordinates":[113.71190456495687,34.76297940075958]}},{"type":"Feature","properties":{"devType":"wifi","name":"64_A8","id":"11257479553635319808","label":"路长亭AP1"},"geometry":{"type":"Point","coordinates":[113.71253481998589,34.761329396470636]}},{"type":"Feature","properties":{"devType":"wifi","name":"CLIENT-1-2F","id":"11257479553644167168","label":"路长亭AP2"},"geometry":{"type":"Point","coordinates":[113.71253449659719,34.76132066418247]}},{"type":"Feature","properties":{"devType":"wifi","name":"CLIENT-2-16","id":"11257479553642528768","label":"菜市场门口AP"},"geometry":{"type":"Point","coordinates":[113.71245518785912,34.759898270846946]}},{"type":"Feature","properties":{"devType":"wifi","name":"CLIENT-2-CA","id":"11257479553637548032","label":"形象墙AP1"},"geometry":{"type":"Point","coordinates":[113.71260157247924,34.756979262434434]}},{"type":"Feature","properties":{"devType":"wifi","name":"ROOT-1-C9","id":"11257479553637482496","label":"形象墙AP2"},"geometry":{"type":"Point","coordinates":[113.71260105750089,34.75696904673217]}},{"type":"Feature","properties":{"devType":"wifi","name":"ROOT-2-AB","id":"11257479553635516416","label":"商城路英协路路口AP"},"geometry":{"type":"Point","coordinates":[113.71244634015035,34.75376882401699]}},{"type":"Feature","properties":{"devType":"fireStation","height":0.3},"geometry":{"type":"Point","coordinates":[113.71198281188376,34.76026869996854]}},{"type":"Feature","properties":{"devType":"garbageCollector","height":0.03,"label":"路长亭处资源回收"},"geometry":{"type":"Point","coordinates":[113.71256116171845,34.761284863934755]}},{"type":"Feature","properties":{"devType":"garbageCollector","height":0.03,"label":"商城路口资源回收"},"geometry":{"type":"Point","coordinates":[113.7125120845724,34.753785944239105]}},{"type":"Feature","properties":{"devType":"manholeCover","height":0.03,"label":"井盖1"},"geometry":{"type":"Point","coordinates":[113.71205643017129,34.75824868815495]}},{"type":"Feature","properties":{"devType":"manholeCover","height":0.03,"label":"井盖2"},"geometry":{"type":"Point","coordinates":[113.71205629119213,34.75760679988724]}},{"type":"Feature","properties":{"devType":"manholeCover","height":0.03,"label":"井盖3"},"geometry":{"type":"Point","coordinates":[113.71205952017795,34.7566548874571]}}]
     */

    private String type;
    private List<FeaturesBean> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FeaturesBean> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturesBean> features) {
        this.features = features;
    }

    public static class FeaturesBean {
        /**
         * type : Feature
         * properties : {"devType":"envMonitor","height":3.9}
         * geometry : {"type":"Point","coordinates":[113.71190456495687,34.76297940075958]}
         */

        private String type;
        private PropertiesBean properties;
        private GeometryBean geometry;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public PropertiesBean getProperties() {
            return properties;
        }

        public void setProperties(PropertiesBean properties) {
            this.properties = properties;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public static class PropertiesBean {
            /**
             * devType : envMonitor
             * height : 3.9
             */

            private String devType;/*
            private double height;
            private String label;
            private String name;
            private long id;
            private String channelNo;*/

            public String getDevType() {
                return devType;
            }

            public void setDevType(String devType) {
                this.devType = devType;
            }

          /*  public double getHeight() {
                return height;
            }

            public void setHeight(double height) {
                this.height = height;
            }*/
        }

        public static class GeometryBean {
            /**
             * type : Point
             * coordinates : [113.71190456495687,34.76297940075958]
             */

            private String type;
            private List<Double> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }
    }
}
