package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.duan1.Adapter.SanPhamAdapter;
import com.example.duan1.Model.SanPham;
import com.example.duan1.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private int selectab = 1;
    ActivityMainBinding binding;
//    RecyclerView recyclerView;
//    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new TrangchuFragment()).commit();
        binding.bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nvhome) {
                    fragment = new TrangchuFragment();
                } else if (item.getItemId() == R.id.nvdanhmuc) {
                    fragment = new DanhmucFragment();
                } else if (item.getItemId() == R.id.nvyeuthich) {
                    fragment = new YeuthichFragment();
                } else if (item.getItemId() == R.id.nvthanhvien) {
                    fragment = new CanhanFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, fragment).commit();
                return true;
            }
        });


    }

}
