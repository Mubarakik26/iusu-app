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

import com.example.iusu_app_v3.Activity.EventsDetailsActivity;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class EventsRVAdapter extends RecyclerView.Adapter<EventsRVAdapter.ViewHolder> {


    ArrayList<Events> eventsArrayList;
    Context context;

    public EventsRVAdapter(ArrayList<Events> eventsArrayList, Context context) {
        this.eventsArrayList = eventsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsRVAdapter.ViewHolder holder, int position) {

        Events events = eventsArrayList.get(position);
        holder.eventImage.setImageResource(events.getImage());
        holder.eventTitleTV.setText(events.getTitle());
        holder.eventDateTV.setText(events.getDate());
        holder.eventTimeTV.setText(events.getTime());
        holder.eventLikesTV.setText(events.getLikes());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventsDetailsActivity.class);
                intent.putExtra("image",events.getImage());
                intent.putExtra("title",events.getTitle());
                intent.putExtra("description",events.getDescription());
                intent.putExtra("date",events.getDate());
                intent.putExtra("time",events.getTime());
                intent.putExtra("likes",events.getLikes());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView eventImage;
        TextView eventTitleTV,eventDateTV,eventTimeTV,eventLikesTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImage=itemView.findViewById(R.id.iv_event_image);
            eventTitleTV=itemView.findViewById(R.id.tv_event_title);
            eventDateTV=itemView.findViewById(R.id.tv_event_date);
            eventTimeTV=itemView.findViewById(R.id.tv_event_time);
            eventLikesTV=itemView.findViewById(R.id.tv_event_likes);
        }
    }
}