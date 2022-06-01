package com.example.iusu_app_v3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iusu_app_v3.Activity.NewsItemDetailsActivity;
import com.example.iusu_app_v3.Models.News;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    ArrayList<News> newsArrayList;
    Context context;

    public NewsRVAdapter(ArrayList<News> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = newsArrayList.get(position);
        holder.newsImg.setImageResource(news.getImage());
        holder.newsDateTV.setText(news.getDate());
        holder.newsTitleTV.setText(news.getTitle());
        holder.newAuthorTV.setText(news.getAuthor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsItemDetailsActivity.class);

                intent.putExtra("id",news.getId());
                intent.putExtra("title",news.getTitle());
                intent.putExtra("image",news.getImage());
                intent.putExtra("content",news.getContent());
                intent.putExtra("date",news.getDate());
                intent.putExtra("author",news.getAuthor());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImg;
        TextView newsTitleTV,newsContentTV,newsDateTV,newAuthorTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitleTV=itemView.findViewById(R.id.tv_news_title);
            newAuthorTV=itemView.findViewById(R.id.tv_news_author);
            newsDateTV=itemView.findViewById(R.id.tv_news_date);
            newsImg=itemView.findViewById(R.id.iv_news_image);


        }
    }
}