package com.example.iusu_app_v3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.iusu_app_v3.Models.GuildOfficial;
import com.example.iusu_app_v3.R;

public class GoDetailsActivity extends AppCompatActivity {
    TextView goName, goTitle, goCampus, goEmail,goAcademicYear, goPhone, goDescription;
    ImageView goImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_details);

        goName= findViewById(R.id.guildNameTV);
        goTitle= findViewById(R.id.guildTitleTV);
        goCampus= findViewById(R.id.guildCampusTV);
        goEmail= findViewById(R.id.guildEmailTV);
        goAcademicYear= findViewById(R.id.guildAcademicYearTV);
        goPhone= findViewById(R.id.guildPhoneTV);
        goDescription= findViewById(R.id.RoleDescriptionTV);
        goImageView=findViewById(R.id.guildImageIV);


//        intent.putExtra("first_name",guildOfficial.getFirstName());
//        intent.putExtra("last_name",guildOfficial.getLastName());
//        intent.putExtra("campus",guildOfficial.getCampus());
//        intent.putExtra("phone",guildOfficial.getPhone());
//        intent.putExtra("email",guildOfficial.getEmail());
//        intent.putExtra("profile_image",guildOfficial.getProfilemage());
//        intent.putExtra("go_id",guildOfficial.getGoId());
//        intent.putExtra("academic_year",guildOfficial.getAcademicYear());
//        intent.putExtra("gptitle",guildOfficial.getGuildTitle());
//        intent.putExtra("role",guildOfficial.getGuildRole());

        goName.setText(getIntent().getStringExtra("first_name")+" "+getIntent().getStringExtra("last_name"));
        goCampus.setText(getIntent().getStringExtra("campus"));
        goPhone.setText(getIntent().getStringExtra("phone"));
        goEmail.setText(getIntent().getStringExtra("email"));
        Glide.with(this).load(getIntent().getStringExtra("profile_image")).into(goImageView);

        goAcademicYear.setText(getIntent().getStringExtra("academic_year"));
        goTitle.setText(getIntent().getStringExtra("gptitle"));
        goDescription.setText(getIntent().getStringExtra("role"));



    }
}