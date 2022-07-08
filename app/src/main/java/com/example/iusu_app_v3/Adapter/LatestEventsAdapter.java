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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.iusu_app_v3.Activity.EventsDetailsActivity;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class LatestEventsAdapter extends RecyclerView.Adapter<LatestEventsAdapter.ViewHolder> {


    ArrayList<Events> eventsArrayList;
    Context context;
    RequestOptions option;

    public LatestEventsAdapter(ArrayList<Events> eventsArrayList, Context context) {
        this.eventsArrayList = eventsArrayList;
        this.context = context;
        option= new RequestOptions().centerCrop().placeholder(R.drawable.profile_avatar_placeholder_large).error(R.drawable.profile_avatar_placeholder_large);
    }

    @NonNull
    @Override
    public LatestEventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_events_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestEventsAdapter.ViewHolder holder, int position) {

        Events events = eventsArrayList.get(position);
        //holder.eventImage.setImageResource(events.getImage());
        holder.eventTitleTV.setText(events.getTitle());
        holder.eventDateTV.setText(events.getDate());
        holder.eventTimeTV.setText(events.getTime());
        // holder.eventLikesTV.setText(events.getLikes());

        Glide.with(context).load(events.getImage()).apply(option).into(holder.eventImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventsDetailsActivity.class);
                intent.putExtra("image",events.getImage());
                intent.putExtra("title",events.getTitle());
                intent.putExtra("description",events.getDescription());
                intent.putExtra("date",events.getDate());
                intent.putExtra("time",events.getTime());
                //intent.putExtra("likes",events.getLikes());

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
        TextView eventTitleTV,eventDateTV,eventTimeTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImage=itemView.findViewById(R.id.eventsImageIV);
            eventTitleTV=itemView.findViewById(R.id.eventsTitleTV);
            eventDateTV=itemView.findViewById(R.id.eventsDateTV);
            eventTimeTV=itemView.findViewById(R.id.eventsTimeTV);

        }
    }
}