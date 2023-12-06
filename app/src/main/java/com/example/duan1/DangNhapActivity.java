package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.duan1.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangNhapActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;

    private List<NguoiDung> list;
    private NguoiDung mnguoiDung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        list = new ArrayList<>();

        getlistNguoiDung();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }
    private void clickLogin(){
        String strUser = edtUser.getText().toString().trim();
        String strPass = edtPass.getText().toString().trim();

        if (list == null || list.isEmpty()){
            return;
        }

        boolean checkUser = false;
        for (NguoiDung nguoiDung : list){
            if (strUser.equals(nguoiDung.getSdt()) && strPass.equals(nguoiDung.getMatkhau())){
                checkUser = true;
                mnguoiDung = nguoiDung;
                break;
            }
        }

        if (checkUser){
            Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user", mnguoiDung);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }
    private void getlistNguoiDung(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService service = retrofit.create(APIService.class);
        service.getlishNguoiDung().enqueue(new Callback<ArrayList<NguoiDung>>() {
            @Override
            public void onResponse(Call<ArrayList<NguoiDung>> call, Response<ArrayList<NguoiDung>> response) {
                list = response.body();
                Log.e("List User", list.size()+"");
            }

            @Override
            public void onFailure(Call<ArrayList<NguoiDung>> call, Throwable t) {
                Toast.makeText(DangNhapActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}