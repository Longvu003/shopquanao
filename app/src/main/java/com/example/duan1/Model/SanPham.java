package com.example.duan1.Model;

import java.io.Serializable;


public class SanPham implements Serializable {
    private String masp;
    private String tensp;
    private String giasp;
    private String hinhanhsp;
    private String thongtinsp;
    private int soLuong;

    public SanPham(String masp, String tensp, String giasp, String hinhanhsp, String thongtinsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanhsp = hinhanhsp;
        this.thongtinsp = thongtinsp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void themSoLuong() {
        this.soLuong++;
        setSoLuong(soLuong);
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void giamSoLuong() {
        if (this.soLuong <= 0) {
            this.soLuong = 0;
        } else {
            this.soLuong--;
            setSoLuong(soLuong);
        }
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public String getThongtinsp() {
        return thongtinsp;
    }

    public void setThongtinsp(String thongtinsp) {
        this.thongtinsp = thongtinsp;
    }
}
