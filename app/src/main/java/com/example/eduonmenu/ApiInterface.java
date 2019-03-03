package com.example.eduonmenu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
  @GET("nl3hi")
  Call<List<Food>> getAllFoods();
}
