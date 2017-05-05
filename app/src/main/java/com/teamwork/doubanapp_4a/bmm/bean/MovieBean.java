package com.teamwork.doubanapp_4a.bmm.bean;

import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */

public class MovieBean {


    private String name;

    private List<ModulesBean> modules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModulesBean> getModules() {
        return modules;
    }

    public void setModules(List<ModulesBean> modules) {
        this.modules = modules;
    }

    public static class ModulesBean {
        private String url;

        private DataBean data;
        private String uri;
        private String key;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static class DataBean {
            private String image;
            private String title;

            private int total;

            private List<SubjectCollectionBoardsBean> subject_collection_boards;

            private List<SelectedCollectionsBean> selected_collections;

            public int getTotal() {
                return total;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<SubjectCollectionBoardsBean> getSubject_collection_boards() {
                return subject_collection_boards;
            }

            public void setSubject_collection_boards(List<SubjectCollectionBoardsBean> subject_collection_boards) {
                this.subject_collection_boards = subject_collection_boards;
            }

            public List<SelectedCollectionsBean> getSelected_collections() {
                return selected_collections;
            }

            public void setSelected_collections(List<SelectedCollectionsBean> selected_collections) {
                this.selected_collections = selected_collections;
            }

            public static class SelectedCollectionsBean {
                private String description;
                private String url;
                private String uri;
                private boolean rank;
                private String background_color;
                private String id;
                private String name;
                private List<String> covers;

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public boolean isRank() {
                    return rank;
                }

                public void setRank(boolean rank) {
                    this.rank = rank;
                }

                public String getBackground_color() {
                    return background_color;
                }

                public void setBackground_color(String background_color) {
                    this.background_color = background_color;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<String> getCovers() {
                    return covers;
                }

                public void setCovers(List<String> covers) {
                    this.covers = covers;
                }
            }

            public static class SubjectCollectionBoardsBean {

                private SubjectCollectionBean subject_collection;
                private String type;

                private List<ItemsBean> items;

                public SubjectCollectionBean getSubject_collection() {
                    return subject_collection;
                }

                public void setSubject_collection(SubjectCollectionBean subject_collection) {
                    this.subject_collection = subject_collection;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<ItemsBean> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBean> items) {
                    this.items = items;
                }

                public static class SubjectCollectionBean {
                    private int subject_count;
                    private String name;
                    private String url;
                    private String uri;
                    private String cover_url;
                    /**
                     * layout : grid
                     */

                    private DisplayBean display;
                    private String sharing_url;
                    private String id;
                    private String description;

                    public int getSubject_count() {
                        return subject_count;
                    }

                    public void setSubject_count(int subject_count) {
                        this.subject_count = subject_count;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public String getCover_url() {
                        return cover_url;
                    }

                    public void setCover_url(String cover_url) {
                        this.cover_url = cover_url;
                    }

                    public DisplayBean getDisplay() {
                        return display;
                    }

                    public void setDisplay(DisplayBean display) {
                        this.display = display;
                    }

                    public String getSharing_url() {
                        return sharing_url;
                    }

                    public void setSharing_url(String sharing_url) {
                        this.sharing_url = sharing_url;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public static class DisplayBean {
                        private String layout;

                        public String getLayout() {
                            return layout;
                        }

                        public void setLayout(String layout) {
                            this.layout = layout;
                        }
                    }
                }

                public static class ItemsBean {
                    private String info;
                    private Object original_price;

                    private RatingBean rating;
                    private String description;
                    private String title;
                    private String url;
                    private String reviewer_name;
                    private String release_date;
                    private String wish_count;

                    private CoverBean cover;
                    private String uri;
                    private Object label;
                    private String subtype;
                    private Object date;
                    private String id;
                    private String type;
                    private Object price;
                    private List<?> actions;
                    private List<String> directors;
                    private List<String> actors;

                    public String getInfo() {
                        return info;
                    }

                    public String getWish_count() {
                        return wish_count;
                    }

                    public void setWish_count(String wish_count) {
                        this.wish_count = wish_count;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

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

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getReviewer_name() {
                        return reviewer_name;
                    }

                    public void setReviewer_name(String reviewer_name) {
                        this.reviewer_name = reviewer_name;
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

                    public Object getLabel() {
                        return label;
                    }

                    public void setLabel(Object label) {
                        this.label = label;
                    }

                    public String getSubtype() {
                        return subtype;
                    }

                    public void setSubtype(String subtype) {
                        this.subtype = subtype;
                    }

                    public Object getDate() {
                        return date;
                    }

                    public void setDate(Object date) {
                        this.date = date;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public Object getPrice() {
                        return price;
                    }

                    public void setPrice(Object price) {
                        this.price = price;
                    }

                    public List<?> getActions() {
                        return actions;
                    }

                    public void setActions(List<?> actions) {
                        this.actions = actions;
                    }

                    public List<String> getDirectors() {
                        return directors;
                    }

                    public void setDirectors(List<String> directors) {
                        this.directors = directors;
                    }

                    public List<String> getActors() {
                        return actors;
                    }

                    public void setActors(List<String> actors) {
                        this.actors = actors;
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
        }
    }
}
