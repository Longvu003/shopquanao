package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.duan1.Model.SanPham;
import com.example.duan1.databinding.ActivityThongTinSanPhamBinding;

public class ThongTinSanPhamActivity extends AppCompatActivity {

    SanPham sanPham;
    ActivityThongTinSanPhamBinding binding;
    TextView tensanpham;
    TextView giasanpham;
    ImageView  photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_san_pham);
        tensanpham=findViewById(R.id.tensanpham_thongtin);
        giasanpham=findViewById(R.id.giasp_thongtin);
        photo=findViewById(R.id.photo);
        Intent intent = getIntent();
       if(intent !=null&&intent.hasExtra("sanpham")){
            sanPham = (SanPham) getIntent().getSerializableExtra("sanpham");
       }if (sanPham!=null){
        tensanpham.setText(sanPham.getTensp());
        giasanpham.setText(sanPham.getGiasp());
            Glide.with(this).load(sanPham.getHinhanhsp()).
                    apply(RequestOptions.centerCropTransform()).into(photo);
        }
    }

}