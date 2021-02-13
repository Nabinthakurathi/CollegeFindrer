package com.nabin.collegerfinder.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.nabin.collegerfinder.Url.url;

public class RetrofitCaller {
    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
