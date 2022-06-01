package com.example.iusu_app_v3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iusu_app_v3.Models.Announcement;
import com.example.iusu_app_v3.Adapter.AnnouncementRVAdapter;
import com.example.iusu_app_v3.R;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {

    ArrayList<Announcement> announcementArrayList;
    AnnouncementRVAdapter announcementRVAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        getSupportActionBar().hide();


        announcementArrayList= new ArrayList<>();

        announcementArrayList.add(new Announcement(1,"Project Proposal","The mode of communication used to pass information between leaders and their subordinates or subjects should be timely, give provision for feedback, complete and other qualities that effective communication should have as discussed by iEduNote (2019). As seen in the background, IUSU mainly uses two modes of communication that is WhatsApp and noticeboards but they do not fully satisfy the needs of students and the IUSU government leaders. On the other hand, when students want to make complaints to the government, they have to approach the different offices of the government in order to be worked upon. Keeping the fact that the greatest number of Ministers do not have offices constant, the IUSU government consists of students who are not always in these offices since they also have other duties they have to attend to as students, thus the students need an alternative where they can make complaints from anywhere without necessarily approaching the offices.\n" +
                "If the available system is not improved, there will always be issues of transparency as leaders do not communicate to students as often as necessary, students will only get to identify who","20/11/2022","",1,"Min of Infromation"));

       announcementArrayList.add(new Announcement(2,"Identity cards out","The mode of communication used to pass information between leaders and their subordinates or subjects should be timely, give provision for feedback, complete and other qualities that effective communication should have as discussed by iEduNote (2019). As seen in the background, IUSU mainly uses two modes of communication that is WhatsApp and noticeboards but they do not fully satisfy the needs of students and the IUSU government leaders. On the other hand, when students want to make complaints to the government, they have to approach the different offices of the government in order to be worked upon. Keeping the fact that the greatest number of Ministers do not have offices constant, the IUSU government consists of students who are not always in these offices since they also have other duties they have to attend to as students, thus the students need an alternative where they can make complaints from anywhere without necessarily approaching the offices.\n" +
                "If the available system is not improved, there will always be issues of transparency as leaders do not communicate to students as often as necessary, students will only get to identify who","20/11/2022","",1,"Min of Infromation"));

        announcementRVAdapter = new AnnouncementRVAdapter(announcementArrayList,AnnouncementActivity.this);
        recyclerView = findViewById(R.id.rv_announcement);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AnnouncementActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(announcementRVAdapter);


    }
}