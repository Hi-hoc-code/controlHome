package com.example.bft_vietname.model;

public class HuongDan {
    public int id;
    public String img_ki_thuat;
    public String discription;

    public HuongDan(int id, String img, String title) {
        this.id = id;
        this.img_ki_thuat = img;
        this.discription = title;
    }

    public HuongDan(String img, String title) {
        this.img_ki_thuat = img;
        this.discription = title;
    }

    public HuongDan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_ki_thuat() {
        return img_ki_thuat;
    }

    public void setImg_ki_thuat(String img_ki_thuat) {
        this.img_ki_thuat = img_ki_thuat;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
