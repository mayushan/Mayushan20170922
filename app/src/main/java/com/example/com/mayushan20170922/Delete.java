package com.example.com.mayushan20170922;

import java.util.List;

/**
 * Created by 怪胎 on 2017/9/22.
 * 解析json后的类
 */

public class Delete {


    private List<ResultsBean> results;

    public Delete(List<ResultsBean> results) {
        this.results = results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String desc;
        private String who;
        private List<String> images;

        public ResultsBean(String desc, String who, List<String> images) {
            this.desc = desc;
            this.who = who;
            this.images = images;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
    }
