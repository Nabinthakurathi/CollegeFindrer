package com.nabin.collegerfinder.Bll;

import com.nabin.collegerfinder.Api.UsersApi;
import com.nabin.collegerfinder.serverResponse.SignupResponse;
import com.nabin.collegerfinder.Url.url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    Boolean isSuccess = false;


    public boolean checkUser(String username, String password){

        UsersApi usersApi = url.getInstance().create(UsersApi.class);
        Call<SignupResponse> usersCall = usersApi.CheckUser(username, password);

        try{
            Response<SignupResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                url.token += loginResponse.body().getToken();

                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
