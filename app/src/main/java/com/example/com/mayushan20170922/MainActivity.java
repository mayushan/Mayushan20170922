package com.example.com.mayushan20170922;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面用来展示布局
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout ly;
    private ViewPager vp;
    private RadioGroup group;
    private List<Fragment> list = new ArrayList<Fragment>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ListView listView;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<MyFragment> mViewList = new ArrayList<MyFragment>();//页卡视图集合
    private String[] name = new String[]{
            "卢深","板块","指数","港股","新三板","商品","更多","其他"
    };
    private String[] url = new String[]{
            "http://gank.io/api/data/Android/10/",
            "http://gank.io/api/data/iOS/10/",
            "http://gank.io/api/data/%E5%89%8D%E7%AB%AF/10/",
            "http://gank.io/api/data/iOS/10/",
            "http://gank.io/api/data/Android/10/",
            "http://gank.io/api/data/%E5%89%8D%E7%AB%AF/10/",
            "http://gank.io/api/data/iOS/10/",
            "http://gank.io/api/data/Android/10/",
    };
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vp = (ViewPager) findViewById(R.id.vp);
        //group = (RadioGroup) findViewById(R.id.group);

        /*text1  = (TextView) findViewById(R.id.text1);
        text2  = (TextView) findViewById(R.id.text2);
        text3  = (TextView) findViewById(R.id.text3);
        text4  = (TextView) findViewById(R.id.text4);*/


        //初始化组件
        mViewPager = (ViewPager)findViewById(R.id.vp_view);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        //使用同一个Fragment
        for (int i=0;i<name.length;i++){
            MyFragment f = new MyFragment();
            Bundle b = new Bundle();
            b.putString("name",name[i]);
            b.putString("url",url[i]);
            f.setArguments(b);
            mViewList.add(f);
            mTabLayout.addTab(mTabLayout.newTab().setText(name[i]));

        }

        //设置适配器
        FragmentManager fm = getSupportFragmentManager();
        MyViewpager mAdapter = new MyViewpager(fm,mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器




    }
    //适配器类
    class MyViewpager extends FragmentPagerAdapter{
        private List<MyFragment> mViewList;

        public MyViewpager(FragmentManager fm, List<MyFragment> mViewList) {
            super(fm);
            this.mViewList = mViewList;
        }

        @Override
        public Fragment getItem(int position) {
            return mViewList.get(position);
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return name[position]; //页卡标题
        }
    }



}
