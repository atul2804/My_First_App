package com.example.atul.basic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Atul on 09-12-2016.
 */

public class Imageadapter extends BaseAdapter {
    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.dravid,
            R.drawable.dravid3,
            R.drawable.dravid5,
            R.drawable.dravidanim,
            R.drawable.dravidapproach,
            R.drawable.fab4,
            R.drawable.indian,
            R.drawable.mcg,
            R.drawable.rahuldravid,
            R.drawable.sketch1,
            R.drawable.wallbest
    };

    public Imageadapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
}
