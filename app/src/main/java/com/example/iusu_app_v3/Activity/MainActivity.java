package com.example.iusu_app_v3.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iusu_app_v3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    Button announcementsBtn, eventsBtn, newsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        bottomNavigationMethod();

        announcementsBtn=findViewById(R.id.btnAnnouncements);
        eventsBtn=findViewById(R.id.btnEvents);
        newsBtn=findViewById(R.id.btnNews);

        announcementsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AnnouncementActivity.class);
                startActivity(intent);
            }
        });

      eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        });

      newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });



    }


    public void bottomNavigationMethod(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.favorites:
                        Intent intent = new Intent(MainActivity.this,FavoritesActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.help:
                        Intent intent2 = new Intent(MainActivity.this,HelpActivity.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        Intent intent1 = new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
    }


}