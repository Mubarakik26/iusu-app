package com.example.iusu_app_v3.Models;

public class Announcement {


    private int announcementId;
    private String title;
    private String message;
    private String date;
    private String time;
    private int go_id;
    private String author;

    public Announcement(int announcementId, String title, String message, String date, String time, int go_id, String author) {
        this.announcementId = announcementId;
        this.title = title;
        this.message = message;
        this.date = date;
        this.time = time;
        this.go_id = go_id;
        this.author = author;
    }


    public int getAnnouncementId() {
        return announcementId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getGo_id() {
        return go_id;
    }

    public String getAuthor() {
        return author;
    }
}
