package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.duan1.Model.APIcheck;
import com.example.duan1.databinding.ActivityDangNhapBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangNhapActivity extends AppCompatActivity {
ActivityDangNhapBinding binding;
APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDangNhapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Chuacotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DangNhapActivity.this, DangkyActivity.class);
                startActivity(intent);
            }
        });
binding.loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     String username=binding.username.getText().toString().trim();
     String password=binding.password.getText().toString().trim();
     if (username.isEmpty()||password.isEmpty()){
         Toast.makeText(DangNhapActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
     }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Call<APIcheck> call=service.getlogin(username,password);
        call.enqueue(new Callback<APIcheck>() {
            @Override
            public void onResponse(Call<APIcheck> call, Response<APIcheck> response) {
                int statusCode = response.code();
                Log.d("DangNhapActivity", "HTTP Status Code: " + statusCode);

                if (response.isSuccessful()&&response.body()!=null){
                    APIcheck apIcheck=response.body();
                    boolean login=apIcheck.isSuccess();
                    if (login){
                        Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DangNhapActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(DangNhapActivity.this, "Đã xảy ra lỗi nha", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<APIcheck> call, Throwable t) {
                Toast.makeText(DangNhapActivity.this, "Đã xảy ra lỗi", Toast.LENGTH_SHORT).show();
            }
        });
    }
});
    }
}
