package com.example.com.mayushan20170922;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 怪胎 on 2017/9/22.
 * 适配器
 */

public class MyAdapter extends BaseAdapter {
    private List<Delete.ResultsBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<Delete.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item,null);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.tv_01= (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02= (TextView) convertView.findViewById(R.id.tv_02);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if(list.get(position).getImages()!=null){
            ImageLoader.getInstance().displayImage(list.get(position).getImages().get(0),holder.img);
            holder.tv_01.setText(list.get(position).getDesc());
            holder.tv_02.setText(list.get(position).getWho());
        }else if(list.get(position).getImages()==null){
            holder.tv_01.setText(list.get(position).getDesc());
            holder.tv_02.setText(list.get(position).getWho());
        }

        return convertView;
    }
    //优化类
    class ViewHolder{
        ImageView img;
        TextView tv_01;
        TextView tv_02;
    }



}
