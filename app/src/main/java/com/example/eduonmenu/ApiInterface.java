package com.example.eduonmenu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiInterface {
 @GET("lvyy2")
 Call<List<Food>> getAllFoods();

}
