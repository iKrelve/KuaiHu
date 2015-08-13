package krelve.app.kuaihu.model;

import java.util.List;

/**
 * Created by wwjun.wang on 2015/8/12.
 */
public class Latest {


    /**
     * top_stories : [{"id":7048089,"title":"发生类似天津爆炸事故时，该如何自救？","ga_prefix":"081309","image":"http://pic4.zhimg.com/494dafbd64c141fd023d4e58b3343fcb.jpg","type":0},{"id":7047383,"title":"每卖一辆车亏 4000 美元，这事儿跟「iPhone 成本仅几百元」挺像","ga_prefix":"081307","image":"http://pic1.zhimg.com/40e0f21292df0e8512385f191e71ad14.jpg","type":0},{"id":7047795,"title":"央视说要干预男男性行为，具体是怎么干预法？","ga_prefix":"081310","image":"http://pic4.zhimg.com/89f0bca7d4ccf70bd747f3675adc18eb.jpg","type":0},{"id":7047071,"title":"美国人最爱买的车第一名是它，第二名是它，第三名，还是它\u2026\u2026","ga_prefix":"081307","image":"http://pic1.zhimg.com/9c00c482251e82fa8e0b957fa9ceb334.jpg","type":0},{"id":7046751,"title":"今晚的修破斯哒是 · 小李子","ga_prefix":"081219","image":"http://pic3.zhimg.com/bc5f63634d9c9832da8593ac64ebb7d6.jpg","type":0}]
     * stories : [{"id":7047795,"title":"央视说要干预男男性行为，具体是怎么干预法？","ga_prefix":"081310","images":["http://pic3.zhimg.com/fe27abc8f094510f2d3b4f3706108b56.jpg"],"type":0},{"id":7048089,"title":"发生类似天津爆炸事故时，该如何自救？","ga_prefix":"081309","images":["http://pic1.zhimg.com/eabb48a57948dc405429d0c0185c7950.jpg"],"type":0},{"id":7047188,"title":"分析了一下，发现这几个中国城市不光物价高，而且收入低","ga_prefix":"081308","images":["http://pic2.zhimg.com/7ce0dfe918b11069bc857421876e6609.jpg"],"type":0},{"id":7047383,"title":"每卖一辆车亏 4000 美元，这事儿跟「iPhone 成本仅几百元」挺像","ga_prefix":"081307","images":["http://pic2.zhimg.com/b8319323c8f8e3ec0ccc80d4745305a9.jpg"],"type":0},{"id":7047071,"title":"美国人最爱买的车第一名是它，第二名是它，第三名，还是它\u2026\u2026","ga_prefix":"081307","images":["http://pic2.zhimg.com/822b9ce452e8d48e6d32b83d4c1ea6e9.jpg"],"type":0},{"id":7047484,"title":"理论上就业率对工资很重要，但是在中国没这么回事","ga_prefix":"081307","images":["http://pic4.zhimg.com/d08952ed50050efdcee33203a4225ba3.jpg"],"type":0},{"id":7047181,"title":"瞎扯 · 如何正确地吐槽","ga_prefix":"081306","images":["http://pic4.zhimg.com/1dd6304067619318034671af9cf26803.jpg"],"type":0}]
     * date : 20150813
     */
    private List<TopStoriesEntity> top_stories;
    private List<StoriesEntity> stories;
    private String date;

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public String getDate() {
        return date;
    }

    public static class TopStoriesEntity {
        /**
         * id : 7048089
         * title : 发生类似天津爆炸事故时，该如何自救？
         * ga_prefix : 081309
         * image : http://pic4.zhimg.com/494dafbd64c141fd023d4e58b3343fcb.jpg
         * type : 0
         */
        private int id;
        private String title;
        private String ga_prefix;
        private String image;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        @Override
        public String toString() {
            return "TopStoriesEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", image='" + image + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    public static class StoriesEntity {
        /**
         * id : 7047795
         * title : 央视说要干预男男性行为，具体是怎么干预法？
         * ga_prefix : 081310
         * images : ["http://pic3.zhimg.com/fe27abc8f094510f2d3b4f3706108b56.jpg"]
         * type : 0
         */
        private int id;
        private String title;
        private String ga_prefix;
        private List<String> images;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public List<String> getImages() {
            return images;
        }

        public int getType() {
            return type;
        }

        @Override
        public String toString() {
            return "StoriesEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", images=" + images +
                    ", type=" + type +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Latest{" +
                "top_stories=" + top_stories +
                ", stories=" + stories +
                ", date='" + date + '\'' +
                '}';
    }
}
