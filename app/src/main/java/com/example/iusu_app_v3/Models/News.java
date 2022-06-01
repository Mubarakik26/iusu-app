package com.example.iusu_app_v3.Models;

public class News {

    private int id;
    private String title;
    private String content;
    private int image;
    private String date;
    private String author;


    public News(int id, String title, String content, int image, String date, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.date = date;
        this.author = author;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }
}
