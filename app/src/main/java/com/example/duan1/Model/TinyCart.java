package com.example.duan1.Model;

public class TinyCart {
    private static Cart cart = new Cart();

    public static Cart getInstance() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }
}
