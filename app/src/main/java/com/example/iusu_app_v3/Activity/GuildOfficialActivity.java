package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.iusu_app_v3.Adapter.EventsRVAdapter;

import com.example.iusu_app_v3.Adapter.GuildOfficialRVAdapter;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.Models.GuildOfficial;
import com.example.iusu_app_v3.Models.News;
import com.example.iusu_app_v3.R;
import com.example.iusu_app_v3.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GuildOfficialActivity extends AppCompatActivity {

    ArrayList<GuildOfficial> guildOfficialArrayList;
    RecyclerView goRecyclerView;
    GuildOfficialRVAdapter guildOfficialRVAdapter;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        guildOfficialArrayList=new ArrayList<>();

        goRecyclerView= findViewById(R.id.rv_events);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(GuildOfficialActivity.this,2,RecyclerView.VERTICAL,false);
        goRecyclerView.setLayoutManager(gridLayoutManager);
        eventsJsonRequest();

        findViewById(R.id.events_fab_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateEventActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void eventsJsonRequest() {

        jsonArrayRequest = new JsonArrayRequest(URLs.URL_FETCH_GUILD_OFFICIAL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i<response.length();i++){

                    try{

                        jsonObject=response.getJSONObject(i);
                        GuildOfficial guildOfficial = new GuildOfficial(jsonObject.getString("first_name"),jsonObject.getString("last_name"),jsonObject.getString("campus"),jsonObject.getString("phone"),jsonObject.getString("email"),jsonObject.getString("profile_image"),jsonObject.getString("go_id"),jsonObject.getString("academic_year"),jsonObject.getString("gptitle"),jsonObject.getString("role"));
                        guildOfficialArrayList.add(guildOfficial);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                guildOfficialRVAdapter= new GuildOfficialRVAdapter(guildOfficialArrayList,GuildOfficialActivity.this);
                goRecyclerView.setAdapter(guildOfficialRVAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(GuildOfficialActivity.this);
        requestQueue.add(jsonArrayRequest);


    }
}