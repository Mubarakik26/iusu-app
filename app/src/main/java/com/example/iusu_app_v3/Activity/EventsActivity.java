package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.iusu_app_v3.Adapter.EventsRVAdapter;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    ArrayList<Events> eventsArrayList;
    RecyclerView eventsRecyclerView;
    EventsRVAdapter eventsRVAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        eventsArrayList=new ArrayList<>();
        eventsArrayList.add(new Events(R.drawable.im_1,"Speak Health: Girl talk","Come listen to specialist as the give advice on girl related issues.","24 November,2022","14:00","60 likes"));
        eventsArrayList.add(new Events(R.drawable.im_2,"Computer Clinic","Have issues with your computer, do you want to update windows, or there is software that you want, come we will be there for you.","25 December,2022","18:00","80 likes"));
        eventsArrayList.add(new Events(R.drawable.im_3,"Legal Aid Clinic","Come listen to specialist as the give advice on girl related issues.","24 November,2022","14:00","60 likes"));
        eventsArrayList.add(new Events(R.drawable.im_5,"Blood donation","Come listen to specialist as the give advice on girl related issues.","24 November,2022","14:00","60 likes"));

        eventsRVAdapter= new EventsRVAdapter(eventsArrayList,EventsActivity.this);
        eventsRecyclerView= findViewById(R.id.rv_events);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(EventsActivity.this,RecyclerView.VERTICAL,false);
        eventsRecyclerView.setLayoutManager(linearLayoutManager);
        eventsRecyclerView.setAdapter(eventsRVAdapter);

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
}