package com.example.bft_vietname.model;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String sdt;

    public User(Integer id, String username,String sdt, String password) {
        this.id = id;
        this.username = username;
        this.sdt =sdt;
        this.password = password;
    }

    public User(String username, String sdt, String password) {
        this.username = username;
        this.sdt = sdt;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
