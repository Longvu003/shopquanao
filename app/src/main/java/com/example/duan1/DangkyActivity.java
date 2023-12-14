package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.duan1.Model.APIcheck;
import com.example.duan1.databinding.ActivityDangkyBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangkyActivity extends AppCompatActivity {
    ActivityDangkyBinding binding;
    private  APIService apiService;
    private  APIcheck apIcheck;
    //&&
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDangkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Retrofit retrofit=new Retrofit.Builder().baseUrl(APIService.base_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        apiService=retrofit.create(APIService.class);
   binding.Dacotaikhoan.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(DangkyActivity.this,DangNhapActivity.class);
           startActivity(intent);
       }
   });
   binding.loginButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String username=binding.username.getText().toString().trim();
           String password=binding.password.getText().toString().trim();
           String Repassword=binding.Repassword.getText().toString().trim();
           if (!username.matches("\\d{10}")){
               Toast.makeText(DangkyActivity.this, "Vui lòng nhập đúng sdt và không để trống", Toast.LENGTH_SHORT).show();
           }else if (!password.matches("^.{8}$")|| !password.equals(Repassword)){
               Toast.makeText(DangkyActivity.this, "Mật khẩu không đúng định dạng gồm 8 ký tự", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(DangkyActivity.this, "Đăng ký thành công nha", Toast.LENGTH_SHORT).show();
               Dangky(username,password);
               Intent intent=new Intent(DangkyActivity.this, MainActivity.class);
               startActivity(intent);
           }
       }
   });
    }
    private void Dangky(String username, String password){
        Call<ArrayList<APIcheck>> call= apiService.dangky(username,password);
        call.enqueue(new Callback<ArrayList<APIcheck>>() {
            @Override
            public void onResponse(Call<ArrayList<APIcheck>> call, Response<ArrayList<APIcheck>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<APIcheck> apIcheck = response .body();

                        if (apIcheck != null && !apIcheck.isEmpty() && apIcheck.get(0).isSuccess()) {
                            Toast.makeText(DangkyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DangkyActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ArrayList<APIcheck>> call, Throwable t) {
                Log.e("DangkyActivity", "onFailure: " + t.getMessage());
                Toast.makeText(DangkyActivity.this, "Lỗi call api", Toast.LENGTH_SHORT).show();
            }

        });
    }

}