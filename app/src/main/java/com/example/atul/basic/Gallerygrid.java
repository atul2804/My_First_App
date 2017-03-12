package com.example.atul.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Gallerygrid extends AppCompatActivity {

    Imageadapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallerygrid);
        adapter1 = new Imageadapter(this);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        if (gridView != null) {
            gridView.setAdapter(adapter1);
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullScreen.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }

}
