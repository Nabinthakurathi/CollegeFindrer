package com.nabin.collegerfinder.Api;

import com.nabin.collegerfinder.model.BannerItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BannerimageApi {
    @POST("banner/create")
    Call<Void> insertBanner(@Body BannerItem bannerItem);

    @GET("banner/all")
    Call<List<BannerItem>> getAllBanners();
}
