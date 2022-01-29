package com.example.weatherapp.logic.network;

import com.example.weatherapp.logic.model.PlaceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {
    @GET("v2/place?token=${WeatherApplication.TOKEN}&lang=zh_CN")
    Call<PlaceResponse> searchPlace(@Query("query")String query);

}
