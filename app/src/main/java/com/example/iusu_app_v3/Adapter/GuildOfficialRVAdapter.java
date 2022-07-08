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
import com.example.iusu_app_v3.Activity.GoDetailsActivity;
import com.example.iusu_app_v3.Models.Events;
import com.example.iusu_app_v3.Models.GuildOfficial;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class GuildOfficialRVAdapter extends RecyclerView.Adapter<GuildOfficialRVAdapter.ViewHolder> {


    ArrayList<GuildOfficial> guildOfficialArrayList;
    Context context;
    RequestOptions option;

    public GuildOfficialRVAdapter(ArrayList<GuildOfficial> guildOfficialArrayList, Context context) {
        this.guildOfficialArrayList = guildOfficialArrayList;
        this.context = context;
        option= new RequestOptions().centerCrop().placeholder(R.drawable.profile_avatar_placeholder_large).error(R.drawable.profile_avatar_placeholder_large);
    }

    @NonNull
    @Override
    public GuildOfficialRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guild_official_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuildOfficialRVAdapter.ViewHolder holder, int position) {

        GuildOfficial guildOfficial = guildOfficialArrayList.get(position);
        //holder.eventImage.setImageResource(events.getImage());
        holder.goTitleTV.setText(guildOfficial.getGuildTitle());
        holder.goCampusTV.setText(guildOfficial.getCampus());



        Glide.with(context).load(guildOfficial.getProfilemage()).apply(option).into(holder.goProfileImageIV);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GoDetailsActivity.class);
                intent.putExtra("first_name",guildOfficial.getFirstName());
                intent.putExtra("last_name",guildOfficial.getLastName());
                intent.putExtra("campus",guildOfficial.getCampus());
                intent.putExtra("phone",guildOfficial.getPhone());
                intent.putExtra("email",guildOfficial.getEmail());
                intent.putExtra("profile_image",guildOfficial.getProfilemage());
                intent.putExtra("go_id",guildOfficial.getGoId());
                intent.putExtra("academic_year",guildOfficial.getAcademicYear());
                intent.putExtra("gptitle",guildOfficial.getGuildTitle());
                intent.putExtra("role",guildOfficial.getGuildRole());
                //intent.putExtra("likes",events.getLikes());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return guildOfficialArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView goProfileImageIV;
        TextView goTitleTV,goCampusTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            goProfileImageIV=itemView.findViewById(R.id.go_profile_image_iv);
            goTitleTV=itemView.findViewById(R.id.guildTitle_tv);
            goCampusTV=itemView.findViewById(R.id.guildCampus_tv);

        }
    }
}