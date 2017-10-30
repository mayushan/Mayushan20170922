package com.example.com.mayushan20170922;

import java.util.List;

/**
 * Created by 怪胎 on 2017/9/22.
 * 解析json的类
 */

public class Results {
    private String createdAt;
    private List<Images> images;
    private String desc;

    public Results(String createdAt, List<Images> images, String desc) {
        this.createdAt = createdAt;
        this.images = images;
        this.desc = desc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
