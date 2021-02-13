package com.nabin.collegerfinder.Bll;

import com.nabin.collegerfinder.Api.RetrofitCaller;
import com.nabin.collegerfinder.model.Item;
import com.nabin.collegerfinder.Api.bbaApi;
import com.nabin.collegerfinder.StrictMode.strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bbaBll {
    List<Item> itemList=  new ArrayList<>();
    Boolean status=false;
    bbaApi bbaApi  = RetrofitCaller.getInstance().create(bbaApi.class);

    public  List<Item> getAllItems() {
        Call<List<Item>> itemsCall = bbaApi.getAllItemsLIst();
        strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
        Call<Void> voidCall = bbaApi.insertItem(item);
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
