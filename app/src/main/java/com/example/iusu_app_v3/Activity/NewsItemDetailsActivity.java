package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iusu_app_v3.R;

public class NewsItemDetailsActivity extends AppCompatActivity {
  ImageView newsImage;
  TextView newsTitleTV,newsContentTV,newsDateTV,newsAuthorTV;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_item_details);

    ActionBar actionBar = getSupportActionBar();

    // showing the back button in action bar
    actionBar.setDisplayHomeAsUpEnabled(true);

    newsImage= findViewById(R.id.iv_news_details_image);
    newsTitleTV= findViewById(R.id.tv_news_details_title);
    newsDateTV= findViewById(R.id.tv_news_details_date);
    newsContentTV=findViewById(R.id.tv_news_details_content);
    newsAuthorTV=findViewById(R.id.tv_news_details_author);

//        newsImage.setImageResource(getIntent().getIntExtra("image",0));
    newsTitleTV.setText(getIntent().getStringExtra("title"));
    newsContentTV.setText(getIntent().getStringExtra("content"));
    newsDateTV.setText(getIntent().getStringExtra("date"));
    newsAuthorTV.setText(getIntent().getStringExtra("author"));

    Glide.with(this).load(getIntent().getStringExtra("image")).into(newsImage);




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