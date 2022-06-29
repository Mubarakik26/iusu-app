package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.iusu_app_v3.Adapter.NewsRVAdapter;
import com.example.iusu_app_v3.Models.Announcement;
import com.example.iusu_app_v3.Adapter.AnnouncementRVAdapter;
import com.example.iusu_app_v3.Models.News;
import com.example.iusu_app_v3.R;
import com.example.iusu_app_v3.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {

    ArrayList<Announcement> announcementArrayList;
    AnnouncementRVAdapter announcementRVAdapter;
    RecyclerView recyclerView;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);




        announcementArrayList= new ArrayList<>();


//    announcementRVAdapter = new AnnouncementRVAdapter(announcementArrayList,AnnouncementActivity.this);
        recyclerView = findViewById(R.id.rv_announcement);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AnnouncementActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

//    recyclerView.setAdapter(announcementRVAdapter);
        findViewById(R.id.ann_fab_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnnouncementActivity.this,CreateAnnouncementActivity.class);
                startActivity(intent);
            }
        });



        announcementJsonRequest();

    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void announcementJsonRequest() {

        jsonArrayRequest = new JsonArrayRequest(URLs.URL_ANN_GET_ANN, new Response.Listener<JSONArray>() {

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

                announcementRVAdapter= new AnnouncementRVAdapter(announcementArrayList,AnnouncementActivity.this);
                recyclerView.setAdapter(announcementRVAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(AnnouncementActivity.this);
        requestQueue.add(jsonArrayRequest);


    }
}