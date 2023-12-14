package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.duan1.Model.Cart;
import com.example.duan1.Model.SanPham;
import com.example.duan1.Model.TinyCart;
import com.example.duan1.databinding.ActivityThongTinSanPhamBinding;

public class ThongTinSanPhamActivity extends AppCompatActivity {

    SanPham sanPham;
    ActivityThongTinSanPhamBinding binding;
    TextView tensanpham;
    TextView giasanpham;
    ImageView photo;
    TextView thongtinsanpham;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_san_pham);
        tensanpham = findViewById(R.id.tensanpham_thongtin);
        giasanpham = findViewById(R.id.giasp_thongtin);
        photo = findViewById(R.id.photo);
        thongtinsanpham = findViewById(R.id.thongtinsanpham);
        Button btnAdd = findViewById(R.id.addToCartButton);



        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("sanpham")) {
            sanPham = (SanPham) getIntent().getSerializableExtra("sanpham");
        }

        if (sanPham != null) {
            tensanpham.setText(sanPham.getTensp());
            giasanpham.setText(sanPham.getGiasp() + " VND");
            Glide.with(this).load(sanPham.getHinhanhsp()).
                    apply(RequestOptions.centerCropTransform()).into(photo);
            thongtinsanpham.setText(sanPham.getThongtinsp());

            cart = TinyCart.getInstance();
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!cart.getContainSP(sanPham)) {
                        cart.addSP(sanPham);
                        btnAdd.setEnabled(false);
                        btnAdd.setText("Sản phẩm đã có trong giỏ hàng");
                    }
                }
            });
        }

        if (cart.getContainSP(sanPham)) {
            btnAdd.setEnabled(false);
            btnAdd.setText("Sản phẩm đã có trong giỏ hàng");
        }
    }


}