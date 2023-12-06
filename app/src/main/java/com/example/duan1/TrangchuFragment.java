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

    SanPhamAdapter sanPhamAdapter=new SanPhamAdapter(getActivity(),list);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        sanPhamAdapter=new SanPhamAdapter(getActivity(),list);
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
        // lắng nghe sự kiệ click vào item và setlayout
  sanPhamAdapter.setOnItemClickListener(new SanPhamAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(SanPham sanPham) {

      }
  });
  binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
  binding.recyclerView.setAdapter(sanPhamAdapter);
        View view=binding.getRoot();
        return view;
    }
    // đẩy thông tin đi
private void thongtinsanpham(SanPham sanPham){
        Intent intent=new Intent(getActivity(), ThongTinSanPhamActivity.class);
        intent.putExtra("sanpham",list);
        startActivity(intent);
}

}