package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.duan1.Model.SanPham;
import com.example.duan1.databinding.ActivityThongTinSanPhamBinding;

public class ThongTinSanPhamActivity extends AppCompatActivity {

    SanPham sanPham;
    int getid;
    ActivityThongTinSanPhamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_san_pham);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (intent != null) {
            getid = bundle.getInt("sanpham");
//        }
//            binding.productname.setText(sanPham.getTensp());
//            binding.thePriceOfProduct.setText(String.valueOf(sanPham.getGiasp()));
        }
    }
}