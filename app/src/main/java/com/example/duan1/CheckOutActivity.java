package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.duan1.Adapter.CartAdapter;
import com.example.duan1.Model.Cart;
import com.example.duan1.Model.TinyCart;

public class CheckOutActivity extends AppCompatActivity {
    private Cart cart;
    static TextView txtTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        cart = TinyCart.getInstance();
        Toolbar toolbar = findViewById(R.id.tb);
        CartAdapter cartAdapter = new CartAdapter(this);
        RecyclerView cartList = findViewById(R.id.cartList);
        cartList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cartList.setAdapter(cartAdapter);
         txtTotal = findViewById(R.id.subtotal);
        txtTotal.setText(cart.getTonggia() + " VND");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thanh Toán");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public static void setTotal() {
        if (txtTotal == null) {
            return;
        } else {
            txtTotal.setText(TinyCart.getInstance().getTonggia()+" VND");
        }
    }
}