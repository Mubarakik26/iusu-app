package com.example.iusu_app_v3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iusu_app_v3.R;

public class EventsDetailsActivity extends AppCompatActivity {

    ImageView eventDetailsImageIV;
    TextView eventDetailsTitleTV,eventDetailsDescriptionTV,eventDetailsDateTV,eventDetailsTimeTV;
    Button beThereBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        eventDetailsImageIV=findViewById(R.id.iv_event_details_image);
        eventDetailsTitleTV=findViewById(R.id.tv_event_details_title);
        eventDetailsDescriptionTV=findViewById(R.id.tv_event_details_description);
        eventDetailsDateTV=findViewById(R.id.tv_event_details_date);
        eventDetailsTimeTV=findViewById(R.id.tv_event_details_time);
        beThereBtn=findViewById(R.id.btn_event_details_willBeThere);


        eventDetailsImageIV.setImageResource(getIntent().getIntExtra("image",0));
        eventDetailsTitleTV.setText(getIntent().getStringExtra("title"));
        eventDetailsDescriptionTV.setText(getIntent().getStringExtra("description"));
        eventDetailsDateTV.setText(getIntent().getStringExtra("date"));
        eventDetailsTimeTV.setText(getIntent().getStringExtra("time"));

        beThereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventsDetailsActivity.this, "Event added to your favorites list", Toast.LENGTH_SHORT).show();
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