package com.example.com.mayushan20170922;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 怪胎 on 2017/9/22.
 * 公用一个类
 */

public class MyFragment extends Fragment {

    private List<Delete.ResultsBean> list;
    private TextView tv;
    private String name;
    private String url;
    int j = 1;
    private MyAdapter adapter;
    private PullToRefreshListView lv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        name = (String) b.get("name");
        url = (String) b.get("url");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.myfragment,null);
        //tv=(TextView)view.findViewById(R.id.tv);
       // tv.setText(name+"---"+url);
        lv= (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
        //网络判断
        boolean c = isNetworkConnected(getActivity());
        if(c){
            Toast.makeText(getActivity(),"网络良好",Toast.LENGTH_SHORT).show();
            into();
        }else{
            Toast.makeText(getActivity(),"没网",Toast.LENGTH_SHORT).show();
        }





        return view;
    }
    //上拉下拉方法
    private void into() {
        //第一次异步加载
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
                String js = params[0];
                String json = new JsonBean().getJson(js);
                return json;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Delete delete = new Gson().fromJson(s, Delete.class);
                list = delete.getResults();

                adapter = new MyAdapter(list, getActivity());
                lv.setAdapter(adapter);

            }
        }.execute(url+j);
        //上拉
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new AsyncTask<String, Integer, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        String js = params[0];
                        String json = new JsonBean().getJson(js);
                        return json;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Delete delete = new Gson().fromJson(s, Delete.class);
                        list = delete.getResults();

                        adapter = new MyAdapter(list, getActivity());
                        lv.setAdapter(adapter);
                        lv.onRefreshComplete();
                    }
                }.execute(url+j);
            }
        });
            //下拉
        lv.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                j++;
                new AsyncTask<String, Integer, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        String js = params[0];
                        String json = new JsonBean().getJson(js);
                        return json;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Delete delete = new Gson().fromJson(s, Delete.class);
                        List<Delete.ResultsBean> lists = delete.getResults();
                        list.addAll(lists);
                        adapter.notifyDataSetChanged();

                    }
                }.execute(url+j);
            }
        });


    }
    //网络判断
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
