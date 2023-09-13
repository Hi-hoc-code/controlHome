package com.example.bft_vietname.model;

public class HuongDan {
    private int id;
    private String  img;
    private String title;

    public HuongDan(int id, String img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public HuongDan(String img, String title) {
        this.img = img;
        this.title = title;
    }

    public HuongDan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
