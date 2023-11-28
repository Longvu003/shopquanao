package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duan1.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private int selectab = 1;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // ánh xạ layout


        getSupportFragmentManager().beginTransaction().
                setReorderingAllowed(true).replace(R.id.Fragment_container, TrangchuFragment.class, null).
                commit();
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