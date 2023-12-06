package com.example.duan1;

import com.example.duan1.Model.SanPham;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    public static String base_URL = "https://shopbanquanao.id.vn/";

    @GET("sanpham.php")
    Call<ArrayList<SanPham>> getlistsanpham();

    @GET("sanphamnam.php")
    Call<ArrayList<SanPham>> getlistsanphamnam();

    @GET("phukien.php")
    Call<ArrayList<SanPham>> getlistphukien();

    @GET("timkiem.php")
    Call<ArrayList<SanPham>> getListSanPhamTimKiem(@Query("keyword") String text);

}
