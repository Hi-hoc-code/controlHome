package com.example.lv_adapter_add_update_delete_clear.model;

public class SinhVien {
    private String id;
    private String ten;
    private Integer namSinh;

    public SinhVien() {
    }

    public SinhVien(String id, String ten, Integer namSinh) {
        this.id = id;
        this.ten = ten;
        this.namSinh = namSinh;
    }

    public SinhVien(String ten, Integer namSinh) {
        this.ten = ten;
        this.namSinh = namSinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }
}
