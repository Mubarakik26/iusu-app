package com.example.iusu_app_v3.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.iusu_app_v3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoriteNewsActivity extends Activity {
    BottomNavigationView bottomNavigationView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_news);

    }

    public void bottomNavigationMethod(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.favorites);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.home:
                        Intent intent = new Intent(FavoriteNewsActivity.this,MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.help:
                        Intent intent2 = new Intent(FavoriteNewsActivity.this,HelpActivity.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        Intent intent1 = new Intent(FavoriteNewsActivity.this,ProfileActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
    }
}
