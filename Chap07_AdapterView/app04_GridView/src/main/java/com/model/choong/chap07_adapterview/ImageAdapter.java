package com.model.choong.chap07_adapterview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017-06-29.
 */

public class ImageAdapter extends BaseAdapter{
    Context context;


    public ImageAdapter(Context ctx){
        context = ctx;
    }

    @Override
    public int getCount() {
        return MainActivity.thumNail.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else{
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(MainActivity.thumNail[position]);
        return imageView;
    }
}
