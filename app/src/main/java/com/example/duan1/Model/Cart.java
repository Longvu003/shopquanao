package com.example.duan1.Model;

import android.util.Log;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<SanPham> listsanpham = new ArrayList<>();
    private int tonggia;
    private int soluong;

    public Cart() {
    }

    public void addSP(SanPham sanPham) {
        sanPham.setSoLuong(1);
        listsanpham.add(sanPham);
    }

    public boolean getContainSP(SanPham sanPham) {
        if (listsanpham != null) {
            for (int i = 0; i < listsanpham.size(); i++) {
                if (sanPham.getMasp().equals(listsanpham.get(i).getMasp())) {
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<SanPham> getListsanpham() {
        return listsanpham;
    }

    public boolean removeSP(SanPham sanPham) {
        if (listsanpham != null) {
            for (int i = 0; i < listsanpham.size(); i++) {
                if (sanPham.getMasp().equals(listsanpham.get(i).getMasp())) {
                    listsanpham.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeSP(int index) {
        if (listsanpham != null) {
            listsanpham.remove(index);
            return true;
        }
        return false;
    }

    public int getTonggia() {
        this.tonggia = 0;
        if (listsanpham != null) {
            for (int i = 0; i < listsanpham.size(); i++) {
                SanPham sanPham = listsanpham.get(i);
                tonggia += sanPham.getSoLuong() * Integer.parseInt(sanPham.getGiasp());
            }
            return tonggia;
        }
        return 0;
    }

    public int getSoluong() {
        Log.e("Hello", "getSoluong: "+soluong);
        return soluong;
    }
}
