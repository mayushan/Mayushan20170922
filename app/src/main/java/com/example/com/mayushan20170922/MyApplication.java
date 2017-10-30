package com.example.com.mayushan20170922;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 怪胎 on 2017/9/22.
 * 网络加载图片
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(200,300)
                .build();
        ImageLoader.getInstance().init(build);
    }
}
