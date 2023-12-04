package com.example.duan1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Model.SanPham;
import com.example.duan1.R;

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
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_san_pham,null,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.viewholder holder, int position) {
       SanPham sanpham=list.get(position);
       txtmasp.setText(String.valueOf(sanpham.getMasp()));
       txttensp.setText(sanpham.getTensp());
       txtgiasp.setText(String.valueOf(sanpham.getGiasp()));
       txthinhanhsp.setText(sanpham.getHinhanhsp());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private TextView txtmasp;
    private TextView txttensp;
    private TextView txtgiasp;

    private TextView txthinhanhsp;

    public class viewholder extends RecyclerView.ViewHolder {
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtmasp=itemView.findViewById(R.id.txtmasp);
            txttensp=itemView.findViewById(R.id.txttensp);
            txtgiasp=itemView.findViewById(R.id.txtgiasp);
            txthinhanhsp=itemView.findViewById(R.id.txthinhanhsp);
        }
    }
}
