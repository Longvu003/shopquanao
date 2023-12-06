package com.example.duan1.Model;

public class TinyCart {
    public static final Cart cart = new Cart();

    public static Cart getInstance() {
        if (cart == null) {
            return new Cart();
        }
        return cart;
    }
}
