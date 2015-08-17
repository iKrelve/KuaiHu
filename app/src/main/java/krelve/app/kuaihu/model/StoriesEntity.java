package krelve.app.kuaihu.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wwjun.wang on 2015/8/14.
 */
public class StoriesEntity implements Serializable{
    /**
     * id : 7047795
     * title : 央视说要干预男男性行为，具体是怎么干预法？
     * ga_prefix : 081310
     * images : ["http://pic3.zhimg.com/fe27abc8f094510f2d3b4f3706108b56.jpg"]
     * type : 0
     */
    private int id;
    private String title;
//    private String ga_prefix;
    private List<String> images;
    private int type;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setGa_prefix(String ga_prefix) {
//        this.ga_prefix = ga_prefix;
//    }

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

//    public String getGa_prefix() {
//        return ga_prefix;
//    }

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
                /*", ga_prefix='" + ga_prefix + '\'' +*/
                ", images=" + images +
                ", type=" + type +
                '}';
    }
}
