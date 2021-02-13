package com.nabin.collegerfinder.Bll;

import com.nabin.collegerfinder.Api.UsersApi;
import com.nabin.collegerfinder.Url.url;
import com.nabin.collegerfinder.model.Cart;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class CartBll {
    boolean isSuccess = false;

    public boolean checkcart(String userId, String itemID) {
        UsersApi usersAPI = url.getInstance().create(UsersApi.class);
        Call<Cart> addCart = usersAPI.addcart(url.token,itemID);
        try {
            Response<Cart> response = addCart.execute();
            if(response.code()==200)
            {
                isSuccess = true;
            }else {
                isSuccess = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
