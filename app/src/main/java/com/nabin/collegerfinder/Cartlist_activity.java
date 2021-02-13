package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.nabin.collegerfinder.Adapter.CartAdapter;
import com.nabin.collegerfinder.Api.ItemApi;
import com.nabin.collegerfinder.Url.url;
import com.nabin.collegerfinder.model.Cart;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cartlist_activity extends AppCompatActivity {
    RecyclerView RecyclerViewcart;
    public static String id="";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlist_activity);

        RecyclerViewcart=findViewById(R.id.REcart);
        getBook();
    }
    public void getBook() {

        String userId=id;
        ItemApi retrofitProductAPI = url.getInstance().create(ItemApi.class);
        Call<List<Cart>> ProductsCall = retrofitProductAPI.getcartlist(url.token);
        ProductsCall.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if(response.code()==200){
                    CartAdapter recyclerviewAdapter = new CartAdapter(response.body(), getApplicationContext());
                    RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                    RecyclerViewcart.setLayoutManager(mlayoutManager);
                    RecyclerViewcart.setHasFixedSize(true);
                    RecyclerViewcart.setAdapter(recyclerviewAdapter);
                    recyclerviewAdapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(Cartlist_activity.this,"error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Toast.makeText(Cartlist_activity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}