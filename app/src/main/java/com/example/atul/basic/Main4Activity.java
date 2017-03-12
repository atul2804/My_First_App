package com.example.atul.basic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    TextView date1;
    int year,month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        auth = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(Main4Activity.this, LoginActivity.class));
                    finish();
                    }
                }
            };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email suggestions if any !!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent gmail = new Intent(Intent.ACTION_VIEW);
                gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[] { "atulksingh1507@gmail.com" });
                gmail.setData(Uri.parse(""));
                gmail.putExtra(Intent.EXTRA_SUBJECT, "Suggestion ");
                gmail.setType("plain/text");
                gmail.putExtra(Intent.EXTRA_TEXT, "Hi ! Atul Singh");
                startActivity(gmail);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navheaderView = navigationView.inflateHeaderView(R.layout.nav_header_main4);
        ImageView img = (ImageView) navheaderView.findViewById(R.id.image2);
     //   TextView emailtext = (TextView) navheaderView.findViewById(R.id.textView);
     //   emailtext.setText(k);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }
        if (id == R.id.sign_out1) {
            auth.signOut();
            Intent i5 = new Intent(Main4Activity.this,LoginActivity.class);
            startActivity(i5);
            Toast.makeText(getApplicationContext(),"You are not logged in ",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i3 = new Intent(Main4Activity.this,Main2Activity.class);
            startActivity(i3);
            Toast.makeText(Main4Activity.this,"Sorry !!! Submit Not Working",Toast.LENGTH_LONG).show();
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(Main4Activity.this,Main22Activity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i1 = new Intent(Main4Activity.this,Main3Activity.class);
            startActivity(i1);
        } else if (id == R.id.nav_manage) {
            Intent i2 = new Intent(Main4Activity.this,ScrollingActivity.class);
            startActivity(i2);
            return true;
        } else if (id == R.id.nav_share) {
            Intent i3 = new Intent(Main4Activity.this,ResetPassword.class);
            startActivity(i3);
            return true;
           // Toast.makeText(Main4Activity.this,"Coming Soon",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Intent i4 = new Intent(Main4Activity.this,QuizUp.class);
            startActivity(i4);
            return true;
          //  Toast.makeText(Main4Activity.this,"Coming Soon",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
