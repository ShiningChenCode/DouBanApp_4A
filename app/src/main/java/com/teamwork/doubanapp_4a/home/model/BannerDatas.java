package com.teamwork.doubanapp_4a.home.model;

import java.util.List;

/**
 * Created by Iden on 2017/5/9.
 */

public class BannerDatas {


    private List<PromosBean> promos;

    public List<PromosBean> getPromos() {
        return promos;
    }

    public void setPromos(List<PromosBean> promos) {
        this.promos = promos;
    }

    public static class PromosBean {
        /**
         * notification : {"count":0,"version":""}
         * image : https://img3.doubanio.com/img/files/file-14927769277750.png
         * text :
         * id : 3517
         * uri : https://www.douban.com/gallery/topic/%E5%9B%BE%E4%B9%A6%E9%A6%86/?dt_banner_src=home_page
         */

        private NotificationBean notification;
        private String image;
        private String text;
        private String id;
        private String uri;

        public NotificationBean getNotification() {
            return notification;
        }

        public void setNotification(NotificationBean notification) {
            this.notification = notification;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public static class NotificationBean {
            /**
             * count : 0
             * version :
             */

            private int count;
            private String version;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
