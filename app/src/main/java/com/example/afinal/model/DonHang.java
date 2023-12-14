package com.example.afinal.model;

public class DonHang {
    private int maDon;
    private String tenDon;
    private int giaDon;
    private int KhoiLuong;
    private String ngayNhan;

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public String getTenDon() {
        return tenDon;
    }

    public void setTenDon(String tenDon) {
        this.tenDon = tenDon;
    }

    public int getGiaDon() {
        return giaDon;
    }

    public void setGiaDon(int giaDon) {
        this.giaDon = giaDon;
    }

    public int getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(int khoiLuong) {
        KhoiLuong = khoiLuong;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public DonHang(int maDon, String tenDon, int giaDon, int khoiLuong, String ngayNhan) {
        this.maDon = maDon;
        this.tenDon = tenDon;
        this.giaDon = giaDon;
        KhoiLuong = khoiLuong;
        this.ngayNhan = ngayNhan;
    }
}
