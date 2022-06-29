package com.example.iusu_app_v3.Models;

public class Events {

    private int image;
    private String title;
    private String description;
    private String date;
    private String time;
    private String likes;

    public Events(int image, String title, String description, String date, String time, String likes) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.likes = likes;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLikes() {
        return likes;
    }
}