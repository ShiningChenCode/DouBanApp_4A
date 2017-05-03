package com.teamwork.doubanapp_4a.bmm.bean;

import java.util.List;

/**
 * Created by admin on 2017/5/1.
 */

public class MovieSuggestion {
    private int count;
    private int start;
    private int total;

    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Object original_price;

        private RatingBean rating;
        private String id;
        private String recommended_reason;
        private String title;
        private RecomDataBean recom_data;
        private Object label;
        private String short_recommended_reason;
        private String type;
        private String description;
        private Object price;
        private Object date;
        private String info;
        private String url;
        private String release_date;

        private CoverBean cover;
        private String uri;
        private String subtype;
        private String reviewer_name;
        private List<?> actions;
        private List<String> actors;
        private List<String> directors;

        public Object getOriginal_price() {
            return original_price;
        }

        public void setOriginal_price(Object original_price) {
            this.original_price = original_price;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRecommended_reason() {
            return recommended_reason;
        }

        public void setRecommended_reason(String recommended_reason) {
            this.recommended_reason = recommended_reason;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public RecomDataBean getRecom_data() {
            return recom_data;
        }

        public void setRecom_data(RecomDataBean recom_data) {
            this.recom_data = recom_data;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public String getShort_recommended_reason() {
            return short_recommended_reason;
        }

        public void setShort_recommended_reason(String short_recommended_reason) {
            this.short_recommended_reason = short_recommended_reason;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getDate() {
            return date;
        }

        public void setDate(Object date) {
            this.date = date;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getReviewer_name() {
            return reviewer_name;
        }

        public void setReviewer_name(String reviewer_name) {
            this.reviewer_name = reviewer_name;
        }

        public List<?> getActions() {
            return actions;
        }

        public void setActions(List<?> actions) {
            this.actions = actions;
        }

        public List<String> getActors() {
            return actors;
        }

        public void setActors(List<String> actors) {
            this.actors = actors;
        }

        public List<String> getDirectors() {
            return directors;
        }

        public void setDirectors(List<String> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            private int count;
            private int max;
            private double value;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }
        }

        public static class RecomDataBean {
        }

        public static class CoverBean {
            private String url;
            private int width;
            private String shape;
            private int height;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getShape() {
                return shape;
            }

            public void setShape(String shape) {
                this.shape = shape;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
