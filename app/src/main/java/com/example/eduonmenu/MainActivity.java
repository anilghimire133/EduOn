package com.example.eduonmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.ExpandablePlaceHolderView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  private Map<String,List<Food>> categoryMap;
  private List<Food> foodList;
  private ExpandablePlaceHolderView expandablePlaceHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView total =  findViewById(R.id.total);

        foodList = new ArrayList<>();
        categoryMap = new HashMap<>();
        expandablePlaceHolderView =  findViewById(R.id.expandablePlaceHolder);

        loadData();

        expandablePlaceHolderView.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(android.view.View view) {
            Toast.makeText(getApplicationContext(),"Clixcked", view.getId()).show();


          }
        });

    }

    private void loadData(){

        ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        apiInterface.getAllFoods().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
              foodList = response.body();
              getHeaderAndChild(foodList);
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });



    }



    private void getHeaderAndChild(List<Food> foodList){

      for (Food food : foodList){
        List<Food> foodList1 = categoryMap.get(food.getCategoty());
        if(foodList1 == null){
          foodList1 = new ArrayList<>();
        }
        foodList1.add(food);
        categoryMap.put(food.getCategoty(), foodList1);
      }

      Log.d("Map",categoryMap.toString());
      Iterator it = categoryMap.entrySet().iterator();
      while (it.hasNext())
      {
        Map.Entry pair = (Map.Entry)it.next();
        Log.d("Key", pair.getKey().toString());
        expandablePlaceHolderView.addView(new HeaderView(this, pair.getKey().toString()));
        List<Food> foodList1 = (List<Food>) pair.getValue();
        for (Food food : foodList1){
          expandablePlaceHolderView.addView(new ChildView(this, food));
        }
        it.remove();
      }
    }


}
