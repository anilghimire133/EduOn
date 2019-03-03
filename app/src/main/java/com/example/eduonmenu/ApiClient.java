package com.example.eduonmenu;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

  private static Retrofit retrofit;
  private static String BASE_URL="https://api.myjson.com/bins/";

  public static Retrofit getInstance(){
    if(retrofit == null){
      retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
