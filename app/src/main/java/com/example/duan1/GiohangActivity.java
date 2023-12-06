package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.duan1.Adapter.SanPhamAdapter;
import com.example.duan1.Model.SanPham;
import com.example.duan1.databinding.ActivityGiohangBinding;

import java.util.ArrayList;

public class GiohangActivity extends AppCompatActivity {

Context context;
private ArrayList<SanPham> gioHang;
private SanPhamAdapter giohangAdapter;
private RecyclerView recyclerView_giohang;
    private  String total="0";
    SanPham sanPham;
    ActivityGiohangBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);


    }


}