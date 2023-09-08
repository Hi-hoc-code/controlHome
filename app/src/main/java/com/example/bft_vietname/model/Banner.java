package com.example.bft_vietname.model;

public class Banner {
    private Integer id;
    private Integer imgIntro;

    public Banner(Integer imgIntro,Integer id) {
        this.id=id;
        this.imgIntro = imgIntro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImgIntro() {
        return imgIntro;
    }

    public void setImgIntro(Integer imgIntro) {
        this.imgIntro = imgIntro;
    }
}
