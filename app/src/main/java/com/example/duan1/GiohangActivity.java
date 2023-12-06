package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Adapter.CartAdapter;
import com.example.duan1.Adapter.SanPhamAdapter;
import com.example.duan1.Model.Cart;
import com.example.duan1.Model.SanPham;
import com.example.duan1.Model.TinyCart;
import com.example.duan1.databinding.ActivityGiohangBinding;

import java.util.ArrayList;

public class GiohangActivity extends AppCompatActivity {
    private Cart cart;
    static TextView txtTotal;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        cart = TinyCart.getInstance();

        RecyclerView rv = findViewById(R.id.recycler_view_giohang);
        Toolbar toolbar = findViewById(R.id.tb);
        Button btnPay = findViewById(R.id.btnPay);
        txtTotal = findViewById(R.id.txtTotal);
        cartAdapter = new CartAdapter(this);
        rv.setAdapter(cartAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Giỏ hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiohangActivity.this, CheckOutActivity.class);
                startActivity(intent);
                //Toast.makeText(GiohangActivity.this, cart.getTonggia()+"VND", Toast.LENGTH_SHORT).show();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0 ,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                cart.removeSP(viewHolder.getBindingAdapterPosition());
                cartAdapter.notifyItemRemoved(viewHolder.getBindingAdapterPosition());
                setTxtTotal();
            }
        });
        itemTouchHelper.attachToRecyclerView(rv);

    }

    @Override
    protected void onStart() {
        super.onStart();
        cartAdapter.notifyDataSetChanged();
    }

    public static void setTxtTotal() {
        if (txtTotal == null) {
            return;
        } else {
            txtTotal.setText(TinyCart.getInstance().getTonggia() + " VND");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}