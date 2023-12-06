package com.example.duan1.Model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.duan1.APIService;
import com.example.duan1.Adapter.SanPhamAdapter;
import com.example.duan1.R;
import com.example.duan1.databinding.ActivitySearchBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    ArrayList<SanPham> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Intent intent = getIntent();
        String url = intent.getStringExtra("key");
        service.getListSanPhamTimKiem(url).enqueue(new Callback<ArrayList<SanPham>>() {
            @Override
            public void onResponse(Call<ArrayList<SanPham>> call, Response<ArrayList<SanPham>> response) {
                list = response.body();
                SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(SearchActivity.this, list);
                binding.rv.setAdapter(sanPhamAdapter);
                binding.rv.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));
            }

            @Override
            public void onFailure(Call<ArrayList<SanPham>> call, Throwable t) {

            }
        });
        setSupportActionBar(binding.tb);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(intent.getStringExtra("key"));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}