package com.example.duan1.Model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<SanPham> listsanpham;
    private  int tonggia;
    private  int soluong;

    public Cart(ArrayList<SanPham> listsanpham, int tonggia, int soluong) {
        this.listsanpham = listsanpham;
        this.tonggia = tonggia;
        this.soluong = soluong;
    }
    


}
