package com.example.duan1;

import com.example.duan1.Model.APIcheck;
import com.example.duan1.Model.SanPham;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    @FormUrlEncoded
    @POST("register.php")
    Call<ArrayList<APIcheck>> dangky(@Field("tennguoidung")String username, @Field("matkhau") String password);
    @GET("login.php")
    Call<APIcheck> getlogin(@Query("sdt") String sdt, @Query("password") String password);
}
