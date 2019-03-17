package com.example.eduonmenu;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
      private static Retrofit retrofit;
//     private static String BASE_URL="https://api.myjson.com/bins/";
    private static String BASE_URL = "http://ksodari.pythonanywhere.com/api/cat/menus/";
    private static ApiClient apiClient;
    private static ApiInterface apiInterface;
    private static final String Key ="Authorization";
    private static final String APP_VALUE ="Token 2cfceef344c54a65b2405acee44bdb22a8a09487";


//public static Retrofit getInstance() {
//    OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
//            .addInterceptor(
//                    new Interceptor() {
//                        @Override
//                        public Response intercept(Interceptor.Chain chain) throws IOException {
//                            Request request = chain.request().newBuilder()
//                                    .addHeader("Authorization", "Token 2cfceef344c54a65b2405acee44bdb22a8a09487").build();
//                            return chain.proceed(request);
//                        }
//                    }).build();
//     retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(defaultHttpClient)
//            .build();
//
//
//    return retrofit;
//}

  public  ApiClient(){
   retrofit = new Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build();
      apiInterface = retrofit.create(ApiInterface.class);
    }

    public static ApiClient getInstance(){
      if (apiClient == null){
          apiClient = new ApiClient();
      }
      return apiClient;
    }


  }

