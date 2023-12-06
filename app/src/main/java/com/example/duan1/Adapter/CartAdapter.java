package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.duan1.CheckOutActivity;
import com.example.duan1.GiohangActivity;
import com.example.duan1.MainActivity;
import com.example.duan1.Model.Cart;
import com.example.duan1.Model.SanPham;
import com.example.duan1.Model.TinyCart;
import com.example.duan1.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Cart cart;
    private Context context;

    public CartAdapter(Context context) {
        this.cart = TinyCart.getInstance();
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        SanPham sanPham = cart.getListsanpham().get(position);
        Glide.with(context)
                .load(sanPham.getHinhanhsp())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.img);
        holder.txtTen.setText(sanPham.getTensp());
        GiohangActivity.setTxtTotal();
        CheckOutActivity.setTotal();
        holder.txtGia.setText(sanPham.getGiasp() + "VND");
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanPham.themSoLuong();
                holder.txtSoluong.setText(sanPham.getSoLuong()+"");
                GiohangActivity.setTxtTotal();
                CheckOutActivity.setTotal();
            }
        });
        holder.txtSoluong.setText(sanPham.getSoLuong()+"");

        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanPham.giamSoLuong();
                holder.txtSoluong.setText(sanPham.getSoLuong()+"");
                GiohangActivity.setTxtTotal();
                CheckOutActivity.setTotal();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cart == null) {
            return 0;
        }
        return cart.getListsanpham().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img, imgAdd, imgMinus;
        TextView txtTen, txtGia, txtSoluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            imgAdd = itemView.findViewById(R.id.btnAdd);
            imgMinus = itemView.findViewById(R.id.btnMinus);
            txtTen = itemView.findViewById(R.id.nameSP);
            txtGia = itemView.findViewById(R.id.priceSP);
            txtSoluong = itemView.findViewById(R.id.txtSoluong);
        }
    }
}
