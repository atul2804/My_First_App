package com.example.atul.basic;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.atul.basic.R.id.gallery1;
import static com.example.atul.basic.R.id.textView;

public class Main22Activity extends AppCompatActivity {

    Integer[] imageIDs = {
            R.drawable.dravid,
            R.drawable.dravid3,
            R.drawable.fab42,
            R.drawable.indian,
            R.drawable.fab4,
            R.drawable.dravidanim,
            R.drawable.wall1,
            R.drawable.wallbest,
            R.drawable.rahuldravid,
            R.drawable.dravidapproach
    };
    ViewPager viewpager;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        viewpager = (ViewPager) findViewById(R.id.view1);
        adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
    }

    public class ImageAdapter extends PagerAdapter {
        private Context ctx;
        private int itemBackground;
        private LayoutInflater layoutInflater;

        public ImageAdapter(Context ctx) {
            this.ctx = ctx;

        }

    /*    public ImageAdapter(Context c) {
            ctx = c;
            // sets a grey background; wraps around the images
            TypedArray a = obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }  */

        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return (view == (LinearLayout)object);
        }

        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }

        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }

        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(ctx);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }

        public Object instantiateItem(ViewGroup container,int position) {
            layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item_view = layoutInflater.inflate(R.layout.swipe,container,false);
            ImageView imageview = (ImageView) item_view.findViewById(R.id.image5);
            TextView  textView1 = (TextView) item_view.findViewById(R.id.textcount);
            imageview.setImageResource(imageIDs[position]);
            textView1.setText("Image : " + (position + 1));
            container.addView(item_view);
            return item_view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);

        }
    }
}

