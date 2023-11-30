package com.example.duan1.model;

public class SanPham {
    private String masp;
    private String tensp;
    private String giasp;
    private String thongtinsp;
    private String hinhanhsp;

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

    public String getThongtinsp() {
        return thongtinsp;
    }

    public void setThongtinsp(String thongtinsp) {
        this.thongtinsp = thongtinsp;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public SanPham(String masp, String tensp, String giasp, String thongtinsp, String hinhanhsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.thongtinsp = thongtinsp;
        this.hinhanhsp = hinhanhsp;
    }
}
