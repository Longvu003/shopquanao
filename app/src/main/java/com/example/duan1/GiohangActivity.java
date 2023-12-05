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
//        recyclerView_giohang=findViewById(R.id.recycler_view_giohang);
//        gioHang=getIntent().<SanPham>getParcelableArrayListExtra("gioHang");
//        giohangAdapter=new SanPhamAdapter(this,gioHang);
//        recyclerView_giohang.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView_giohang.setAdapter(giohangAdapter);
//        Intent intent = getIntent();
//        if (intent!=null){
//            String masp = intent.getStringExtra("masp");
//            String tensp = intent.getStringExtra("tensp");
//            String giasp = intent.getStringExtra("giasp");
//            String hinhanhsp = intent.getStringExtra("hinhanhsp");
//            total+=giasp;
//            Log.d("IntentData", "masp: " + masp + ", tensp: " + tensp + ", giasp: " + giasp + ", hinhanhsp: " + hinhanhsp);
//        }

    }


}