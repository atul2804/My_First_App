package com.example.atul.basic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class WelcomeActivity extends Activity {
    ImageView img;
    private ProgressDialog p1;
    ProgressBar progressBar;
    private static int time_out = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        img = (ImageView) findViewById(R.id.imageview1);
        progressBar = (ProgressBar) findViewById(R.id.spinner);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, time_out);
    }
}
