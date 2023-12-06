package com.example.duan1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.duan1.GiohangActivity;
import com.example.duan1.Model.SanPham;
import com.example.duan1.R;
import com.example.duan1.ThongTinSanPhamActivity;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.viewholder> {
    Context context;
    ArrayList<SanPham> list;


    public SanPhamAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SanPhamAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_san_pham, null, false);
        return new viewholder(view);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private TextView txtmasp;
    private TextView txttensp;
    private TextView txtgiasp;

    private OnItemClickListener mListener;


    public class viewholder extends RecyclerView.ViewHolder {
        ImageView imganhsp;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtmasp = itemView.findViewById(R.id.txtmasp);
            txttensp = itemView.findViewById(R.id.txttensp);
            txtgiasp = itemView.findViewById(R.id.txtgiasp);
            imganhsp = itemView.findViewById(R.id.anhsp);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(SanPham sanPham);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.viewholder holder, int position) {
        SanPham sanpham = list.get(position);
        txtmasp.setText(String.valueOf(sanpham.getMasp()));
        txttensp.setText(sanpham.getTensp());
        txtgiasp.setText(sanpham.getGiasp() + " VND");
        Glide.with(context)
                .load(sanpham.getHinhanhsp())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imganhsp);
// sự kiện click truyền thông tin đi
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ThongTinSanPhamActivity.class);
                intent.putExtra("sanpham",list.get(position));
                context.startActivity(intent);
            }
        });



    }
}
