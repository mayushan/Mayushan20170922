package com.example.com.mayushan20170922;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 怪胎 on 2017/9/22.
 * 网络请求的类
 */

public class JsonBean {
    public String getJson(String js){
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String str = "";
        try {
            url = new URL(js);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            //是否响应码为200
            if(responseCode==200){
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] b = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(b))!=-1){
                    str+=new String(b,0,length);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回
        return str;
    }
}
