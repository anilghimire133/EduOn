package com.example.eduonmenu;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.child_layout)
public class ChildView {
    private static String TAG ="ChildView";

    @View(R.id.child_name)
    TextView textViewChild;

    @View(R.id.child_price)
    TextView textViewPrice;

    @View(R.id.child_image)
    ImageView childImage;

    private Context mContext;
    private Food food;

    public ChildView(Context mContext, Food food) {
        this.mContext = mContext;
        this.food = food;
    }

    @Resolve
    private void onResolve(){
        Log.d(TAG,"onResolve");
        textViewChild.setText(food.getName());
        textViewPrice.setText(food.getPrice());
        Glide.with(mContext).load(food.getImageUrl()).apply(RequestOptions.circleCropTransform()).into(childImage);
    }
}
