package com.example.iusu_app_v3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iusu_app_v3.Models.News;
import com.example.iusu_app_v3.Adapter.NewsRVAdapter;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private ArrayList<News> newsArrayList;
    private NewsRVAdapter newsRVAdapter;
    private RecyclerView newRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsArrayList= new ArrayList<>();
        newsArrayList.add(new News(1,"Guild Elections in IUIU","June 23 id the day when student are expected to vote for the leaders of the student government. the race is so tight",R.drawable.profile_avatar_placeholder_large,"28 October,2022","Minister of ICT"));
        newsArrayList.add(new News(2,"Law Society Elections in IUIU","June 23 id the day when student are expected to vote for the leaders of the student government. the race is so tight",R.drawable.profile_avatar_placeholder_large,"28 October,2022","Minister of ICT"));

        newsRVAdapter= new NewsRVAdapter(newsArrayList,NewsActivity.this);

        newRecyclerView=findViewById(R.id.rv_news);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NewsActivity.this,RecyclerView.VERTICAL,false);
        newRecyclerView.setLayoutManager(linearLayoutManager);

        newRecyclerView.setAdapter(newsRVAdapter);
    }
}