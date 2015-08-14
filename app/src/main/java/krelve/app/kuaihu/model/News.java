package krelve.app.kuaihu.model;

import java.util.List;

/**
 * Created by wwjun.wang on 2015/8/14.
 */
public class News {

    /**
     * stories : [{"id":7050241,"title":"为什么二次元粉丝物理都很难及格？","images":["http://pic4.zhimg.com/a012398ff96c6999fe17a59c177e125b_t.jpg"],"type":2},{"id":7048880,"title":"我们实际在做的 VS 我们心里想做的（爱）","images":["http://pic2.zhimg.com/e79b827b810ea3d62dea7d9ea1a20409_t.jpg"],"type":1},{"id":7049075,"title":"为什么说在中国当消防员是最非人的工作？","images":["http://pic2.zhimg.com/48d8d425bd958bca0e2c8b32947909d9_t.jpg"],"type":2},{"id":7047328,"title":"那些给你造成心理阴影的极品室友！不能忍！","images":["http://pic1.zhimg.com/9248fc025e7bd0beb1f12d8ade879b00_t.jpg"],"type":2},{"id":7046196,"title":"你便便的形状到底意味着什么？","images":["http://pic4.zhimg.com/5653042f76a56b7a16ca70fcf3d24553_t.jpg"],"type":2},{"id":7045556,"title":"6 张意大利小方饺的黄色动图，精神身体双重满足","images":["http://pic1.zhimg.com/09254cb2584580676d00476850c1e3dc_t.jpg"],"type":2},{"id":7044522,"title":"14 个喜怒哀乐的冷知识，比微表情靠谱","images":["http://pic3.zhimg.com/8c56946657296930560b84f9ea96b32a_t.jpg"],"type":2},{"id":7043374,"title":"现在日本妹纸最流行的卖萌妆是找到喝醉的节奏","images":["http://pic3.zhimg.com/0444507622888a2247c0c4a9918b6c46_t.jpg"],"type":2},{"id":7041376,"title":"12 个本周冷知识，我们可能生活在虚拟世界里","images":["http://pic1.zhimg.com/df6c1806637b200a20cf1d1dcb80a110_t.jpg"],"type":2},{"id":7041059,"title":"11 张本周最热节操图，第一视角看冲浪是啥样？","images":["http://pic4.zhimg.com/0651f2f4686239d3152b3fc89e0a3eeb_t.jpg"],"type":2},{"id":7040333,"title":"你不知道的匡威，其实清朝就有了！","images":["http://pic3.zhimg.com/571155680c0f741731ebc6845031726a_t.jpg"],"type":2},{"id":7039746,"title":"9 件男朋友送的崩溃礼物，明明说好了爱我的！","images":["http://pic3.zhimg.com/c16230b4f9c1243488be32b120b96876_t.jpg"],"type":2},{"id":7037920,"title":"小时候家里穷是怎样一种体验？","images":["http://pic4.zhimg.com/f0dd2e448c148205f9d06841e628a32f_t.jpg"],"type":2},{"id":7036785,"title":"12 个关于绿可乐的真相，不是薄荷味的噢","images":["http://pic1.zhimg.com/a3a60aecb5a14fe5eecaa64ccd7eeee0_t.jpg"],"type":2},{"id":7035648,"title":"VICE 呈现：一块钱广告位","images":["http://pic4.zhimg.com/f53275ee42ce45fd49ff1c7823acdd3f_t.jpg"],"type":2},{"id":7035630,"title":"我只有一个愿望：《银魂》永不完结！","images":["http://pic1.zhimg.com/cbc90f48b2eb76dade41a6afb9e659c8_t.jpg"],"type":2},{"id":7033692,"title":"一份来自 \u201c云南山歌\u201d 里的毕业旅行指南 | VICE 中国","images":["http://pic4.zhimg.com/9da0d6540ecce8bd931696fb7a17ed63_t.jpg"],"type":1},{"id":7034628,"title":"在我国当单身女是一种什么体验？","images":["http://pic4.zhimg.com/3662a8259039e1bcfa0767c64b94997f_t.jpg"],"type":2},{"id":7033873,"title":"6 个去美国冻卵子前必须清楚的医学风险","images":["http://pic3.zhimg.com/be8d675e6270b54e3ad18b027433bae2_t.jpg"],"type":2}]
     * color : 8307764
     * description : 为你发现最有趣的新鲜事，建议在 WiFi 下查看
     * name : 不许无聊
     * background : http://pic1.zhimg.com/a5128188ed788005ad50840a42079c41.jpg
     * image : http://pic3.zhimg.com/da1fcaf6a02d1223d130d5b106e828b9.jpg
     * editors : [{"id":70,"bio":"微在 Wezeit 主编","name":"益康糯米","avatar":"http://pic4.zhimg.com/068311926_m.jpg","url":"http://www.zhihu.com/people/wezeit"},{"id":69,"bio":"VICE 中国编辑","name":"狐狸","avatar":"http://pic2.zhimg.com/6dbfe3c7f_m.jpg","url":"http://www.zhihu.com/people/firefoxwae"},{"id":71,"bio":"明月般俊朗","name":"顾惜朝","avatar":"http://pic4.zhimg.com/43d10de2b46c918a9ffe5d0472947b67_m.jpg","url":"http://www.zhihu.com/people/kuangzhou"}]
     * image_source :
     */
    private List<StoriesEntity> stories;
    private int color;
    private String description;
    private String name;
    private String background;
    private String image;
    private List<EditorsEntity> editors;
    private String image_source;

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setEditors(List<EditorsEntity> editors) {
        this.editors = editors;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public int getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getBackground() {
        return background;
    }

    public String getImage() {
        return image;
    }

    public List<EditorsEntity> getEditors() {
        return editors;
    }

    public String getImage_source() {
        return image_source;
    }


    public static class EditorsEntity {
        /**
         * id : 70
         * bio : 微在 Wezeit 主编
         * name : 益康糯米
         * avatar : http://pic4.zhimg.com/068311926_m.jpg
         * url : http://www.zhihu.com/people/wezeit
         */
        private int id;
        private String bio;
        private String name;
        private String avatar;
        private String url;

        public void setId(int id) {
            this.id = id;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public String getBio() {
            return bio;
        }

        public String getName() {
            return name;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getUrl() {
            return url;
        }
    }
}
