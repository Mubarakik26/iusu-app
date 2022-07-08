package com.example.iusu_app_v3.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.iusu_app_v3.Adapter.AnnouncementRVAdapter;
import com.example.iusu_app_v3.Adapter.EventsRVAdapter;
import com.example.iusu_app_v3.Adapter.LatestAnnAdapter;
import com.example.iusu_app_v3.Adapter.LatestEventsAdapter;
import com.example.iusu_app_v3.Adapter.LatestNewsAdapter;
import com.example.iusu_app_v3.Adapter.NewsRVAdapter;
import com.example.iusu_app_v3.Models.Announcement;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.Models.News;
import com.example.iusu_app_v3.R;
import com.example.iusu_app_v3.SharedPreferenceManager;
import com.example.iusu_app_v3.URLs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    //Button announcementsBtn, eventsBtn, newsBtn, guildBtn;
    TextView announcementsTV,eventsTV,newsTV;
/////Announcement
    ArrayList<Announcement> announcementArrayList;
    LatestAnnAdapter latestAnnAdapter;
    RecyclerView recyclerView;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    ///////////News
    private ArrayList<News> newsArrayList;
    private LatestNewsAdapter latestNewsAdapter;
    private RecyclerView newRecyclerView;
    JsonArrayRequest jsonArrayRequest2;
    RequestQueue requestQueue2;

    ///////////Events
    ArrayList<Events> eventsArrayList;
    RecyclerView eventsRecyclerView;
    LatestEventsAdapter latestEventsAdapter;
    JsonArrayRequest jsonArrayRequest3;
    RequestQueue requestQueue3                  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(SharedPreferenceManager.getInstance(this).isLoggedIn()){
            //getSupportActionBar().hide();
            bottomNavigationMethod();



//            announcementsBtn=findViewById(R.id.btnAnnouncements);
//            eventsBtn=findViewById(R.id.btnEvents);
//            newsBtn=findViewById(R.id.btnNews);
//            guildBtn=findViewById(R.id.btnGuild);

            announcementsTV=findViewById(R.id.seemoreAnnouncemetsTV);
            eventsTV=findViewById(R.id.seemoreEventsTV);
            newsTV=findViewById(R.id.seemoreNewsTV);

//Announcement
            announcementArrayList= new ArrayList<>();
            recyclerView = findViewById(R.id.latestAnnouncementsRV);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);
            latestAnnouncementJsonRequest();
  //News
            newsArrayList= new ArrayList<>();
            newRecyclerView=findViewById(R.id.latestNewsRV);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
            newRecyclerView.setLayoutManager(linearLayoutManager2);
            latestNewsJsonRequest();

//Events
            eventsArrayList=new ArrayList<>();
            eventsRecyclerView= findViewById(R.id.latestEventsRV);
            LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
            eventsRecyclerView.setLayoutManager(linearLayoutManager3);
            latestEventsJsonRequest();



            announcementsTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,AnnouncementActivity.class);
                    startActivity(intent);
                }
            });

            eventsTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,EventsActivity.class);
                    startActivity(intent);
                }
            });

            newsTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
            });


//            guildBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this,GuildOfficialActivity.class);
//                    startActivity(intent);
//                }
//            });







        }
        else{
            Intent  intent = new Intent(MainActivity.this,LogInActivity.class);
            startActivity(intent);
            finish();
        }

    }


    public void bottomNavigationMethod(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.favorites:
                        Intent intent = new Intent(MainActivity.this, FavoriteNewsActivity.class);
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

    public void latestAnnouncementJsonRequest() {

        jsonArrayRequest = new JsonArrayRequest(URLs.URL_LATEST_ANNOUNCEMENTS, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i<response.length();i++){

                    try{

                        jsonObject=response.getJSONObject(i);
                        Announcement announcement = new Announcement(jsonObject.getInt("id"),jsonObject.getString("title"),jsonObject.getString("description"),jsonObject.getString("date_time"),jsonObject.getString("go_id"),jsonObject.getString("gptitle"));
                        announcementArrayList.add(announcement);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                latestAnnAdapter= new LatestAnnAdapter(announcementArrayList,MainActivity.this);
                recyclerView.setAdapter(latestAnnAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);


    }

    public void latestNewsJsonRequest() {

        jsonArrayRequest2 = new JsonArrayRequest(URLs.URL_LATEST_NEWS_FETCH, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i<response.length();i++){

                    try{

                        jsonObject=response.getJSONObject(i);
                        News news = new News(jsonObject.getInt("id"),jsonObject.getString("image"),jsonObject.getString("title"),jsonObject.getString("description"),jsonObject.getString("date_time"),jsonObject.getString("go_id"),jsonObject.getString("gptitle"));
                        newsArrayList.add(news);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                latestNewsAdapter= new LatestNewsAdapter(newsArrayList,MainActivity.this);
                newRecyclerView.setAdapter(latestNewsAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue2 = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest2);


    }

    public void latestEventsJsonRequest() {

        jsonArrayRequest3 = new JsonArrayRequest(URLs.URL_LATEST_EVENT, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i<response.length();i++){

                    try{

                        jsonObject=response.getJSONObject(i);
                        Events events = new Events(jsonObject.getInt("id"),jsonObject.getString("image"),jsonObject.getString("title"),jsonObject.getString("description"),jsonObject.getString("date"),jsonObject.getString("time"),jsonObject.getString("go_id"),jsonObject.getString("gptitle"));
                        eventsArrayList.add(events);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                latestEventsAdapter= new LatestEventsAdapter(eventsArrayList,MainActivity.this);
                eventsRecyclerView.setAdapter(latestEventsAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue3 = Volley.newRequestQueue(MainActivity.this);
        requestQueue3.add(jsonArrayRequest3);


    }




}