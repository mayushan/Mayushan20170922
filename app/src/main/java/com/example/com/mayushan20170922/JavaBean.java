package com.example.com.mayushan20170922;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 怪胎 on 2017/9/22.
 * 解析json类
 */

public class JavaBean {
    private ArrayList<Results> results;

    public JavaBean(ArrayList<Results> results) {
        this.results = results;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
}
