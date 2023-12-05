package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan1.Adapter.SanPhamAdapter;
import com.example.duan1.Model.SanPham;
import com.example.duan1.databinding.FragmentTrangchuBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TrangchuFragment extends Fragment {
    ArrayList<SanPham> list;
    FragmentTrangchuBinding binding;
    private ArrayList<SanPham> gioHang = new ArrayList<>();
    SanPhamAdapter sanPhamAdapter;
    ImageView themvaogiohang;
    private  String toltal="0";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService service = retrofit.create(APIService.class);
        service.getlistsanpham().enqueue(new Callback<ArrayList<SanPham>>() {
            @Override
            public void onResponse(Call<ArrayList<SanPham>> call, Response<ArrayList<SanPham>> response) {
                list = response.body();
                sanPhamAdapter = new SanPhamAdapter(getActivity(), list);
                sanPhamAdapter.setOnItemClickListener(new SanPhamAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(SanPham sanPham) {
                        item_clicked(sanPham.getMasp(),sanPham.getTensp(),sanPham.getGiasp(),sanPham.getHinhanhsp());
                    }
                });
                binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                binding.recyclerView.setAdapter(sanPhamAdapter);
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<SanPham>> call, Throwable t) {
                Toast.makeText(getActivity(), "lỖI", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTrangchuBinding.inflate(inflater, container, false);

        View view=binding.getRoot();
        return view;
    }

    public  void item_clicked(String masp, String tensp,String giasp, String hinhanhsp){
        boolean clicked=false;
        for (SanPham sanPham:gioHang){
        if(sanPham.getMasp().equals(masp)){
            clicked=false;
            sanPham.setMasp(sanPham.getMasp()+1);
            break;
        }
        if (!clicked){
            SanPham sanPham1 = new SanPham(masp, tensp, giasp, hinhanhsp);
            gioHang.add(sanPham1);
        }

        }
        toltal+=giasp;
        Log.d("ItemClick", "Item clicked: " + tensp);
        Intent intent=new Intent(getContext(), GiohangActivity.class);
        intent.putExtra("masp",masp);
        intent.putExtra("tensp",tensp);
        intent.putExtra("giasp",giasp);
        intent.putExtra("hinhanhsp",hinhanhsp);
        startActivity(intent);
    }

}