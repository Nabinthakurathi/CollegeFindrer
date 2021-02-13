package com.nabin.collegerfinder.Bll;

import com.nabin.collegerfinder.Api.ItApi;
import com.nabin.collegerfinder.Api.RetrofitCaller;
import com.nabin.collegerfinder.model.Item;
import com.nabin.collegerfinder.StrictMode.strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItBll {
    List<Item> itemList=  new ArrayList<>();
    Boolean status=false;
    ItApi itApi  = RetrofitCaller.getInstance().create(ItApi.class);

    public  List<Item> getAllItems() {
        Call<List<Item>> itemsCall = itApi.getAllItemsLIst();
        strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
        Call<Void> voidCall = itApi.insertItem(item);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    status=true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status=false;
            }
        });
        return  status;
    }
}
