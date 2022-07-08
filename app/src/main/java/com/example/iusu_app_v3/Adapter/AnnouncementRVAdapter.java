package com.example.iusu_app_v3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iusu_app_v3.Models.Announcement;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class AnnouncementRVAdapter extends RecyclerView.Adapter<AnnouncementRVAdapter.ViewHolder> {
    private ArrayList<Announcement> announcementArrayList;
    private Context context;


    public AnnouncementRVAdapter(ArrayList<Announcement> announcementArrayList, Context context) {
        this.announcementArrayList = announcementArrayList;
        this.context = context;
    }



    @NonNull
    @Override
    public AnnouncementRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_layout_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementRVAdapter.ViewHolder holder, int position) {
        Announcement announcement= announcementArrayList.get(position);

        holder.titleTV.setText(announcement.getTitle());
        holder.contentTV.setText(announcement.getMessage());
        holder.authorTV.setText(announcement.getAuthor());
        holder.dateTV.setText(announcement.getDate());




    }

    @Override
    public int getItemCount() {
        return announcementArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV,contentTV,dateTV,authorTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV=itemView.findViewById(R.id.txt_title);
            contentTV=itemView.findViewById(R.id.txt_content);
            dateTV=itemView.findViewById(R.id.txt_date_and_time);
            authorTV=itemView.findViewById(R.id.txt_author);


        }
    }
}