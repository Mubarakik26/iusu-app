package com.example.iusu_app_v3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iusu_app_v3.R;

public class NewsItemDetailsActivity extends AppCompatActivity {
    ImageView newsImage;
    TextView newsTitleTV,newsContentTV,newsDateTV,newsAuthorTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item_details);

        getSupportActionBar().hide();
        
        newsImage= findViewById(R.id.iv_news_details_image);
        newsTitleTV= findViewById(R.id.tv_news_details_title);
        newsDateTV= findViewById(R.id.tv_news_details_date);
        newsContentTV=findViewById(R.id.tv_news_details_content);
        newsAuthorTV=findViewById(R.id.tv_news_details_author);

        newsImage.setImageResource(getIntent().getIntExtra("image",0));
        newsTitleTV.setText(getIntent().getStringExtra("title"));
        newsContentTV.setText(getIntent().getStringExtra("content"));
        newsDateTV.setText(getIntent().getStringExtra("date"));
        newsAuthorTV.setText(getIntent().getStringExtra("author"));




    }
}