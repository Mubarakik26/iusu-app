package com.example.iusu_app_v3.Models;

public class Events {

    private int id;
    private String image;
    private String title;
    private String description;
    private String date;
    private String time;
    private String goId;
    private String gpostTitle;

    public Events(int id,String image, String title, String description, String date, String time,String goId, String gpostTitle) {

        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.goId = goId;
        this.gpostTitle = gpostTitle;

    }

    public String getImage() {
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

    public int getId() {
        return id;
    }

    public String getGoId() {
        return goId;
    }

    public String getGpostTitle() {
        return gpostTitle;
    }
}