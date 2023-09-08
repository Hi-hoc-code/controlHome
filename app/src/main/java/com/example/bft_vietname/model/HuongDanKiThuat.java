package com.example.bft_vietname.model;

import android.graphics.Bitmap;

public class HuongDanKiThuat {
    private int id;
    private Bitmap  img;
    private String title;

    public HuongDanKiThuat(int id, Bitmap img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }
    public HuongDanKiThuat(Bitmap img, String title) {
        this.img = img;
        this.title = title;
    }


    public int getId() {
        return id   ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getImg() {
        return img;
    }
        
    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
