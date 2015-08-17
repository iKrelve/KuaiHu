package krelve.app.kuaihu.model;

import java.util.List;

/**
 * Created by wwjun.wang on 2015/8/17.
 */
public class Content {

    /**
     * id : 7053854
     * recommenders : [{"avatar":"http://pic3.zhimg.com/bbb689a7a_m.jpg"}]
     * body : 这是html文本
     * title : 野生动物从不刷牙，有点担心他们的牙齿出问题
     * ga_prefix : 081710
     * share_url : http://daily.zhihu.com/story/7053854
     * js : []
     * image : http://pic1.zhimg.com/3d8395f01761c77e87b673d0806191a4.jpg
     * type : 0
     * css : ["http://news.at.zhihu.com/css/news_qa.auto.css?v=016bb"]
     * image_source : 站酷海洛创意
     */
    private int id;
    private List<RecommendersEntity> recommenders;
    private String body;
    private String title;
    private String ga_prefix;
    private String share_url;
    private String image;
    private int type;
    private List<String> css;
    private String image_source;

    public void setId(int id) {
        this.id = id;
    }

    public void setRecommenders(List<RecommendersEntity> recommenders) {
        this.recommenders = recommenders;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public int getId() {
        return id;
    }

    public List<RecommendersEntity> getRecommenders() {
        return recommenders;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public String getShare_url() {
        return share_url;
    }


    public String getImage() {
        return image;
    }

    public int getType() {
        return type;
    }

    public List<String> getCss() {
        return css;
    }

    public String getImage_source() {
        return image_source;
    }

    public static class RecommendersEntity {
        /**
         * avatar : http://pic3.zhimg.com/bbb689a7a_m.jpg
         */
        private String avatar;

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar() {
            return avatar;
        }
    }
}
