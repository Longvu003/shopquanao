package com.example.duan1.Model;

import java.io.Serializable;

public class NguoiDung implements Serializable {
    private String manguoidung;
    private String tennguoidung;
    private String sdt;
    private String matkhau;

    public String getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(String manguoidung) {
        this.manguoidung = manguoidung;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public NguoiDung(String manguoidung, String tennguoidung, String sdt, String matkhau) {
        this.manguoidung = manguoidung;
        this.tennguoidung = tennguoidung;
        this.sdt = sdt;
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "manguoidung='" + manguoidung + '\'' +
                ", tennguoidung='" + tennguoidung + '\'' +
                ", sdt='" + sdt + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
}
