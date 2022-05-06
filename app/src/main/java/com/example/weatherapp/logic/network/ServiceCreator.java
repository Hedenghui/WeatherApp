package com.example.weatherapp.logic.network;

import com.example.weatherapp.logic.model.PlaceResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceCreator<T> {
    private static String BASE_URL = "https://api.caiyunapp.com/";


    static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public T Create(Class<T> ServiceClass) {
        T service = retrofit.create(ServiceClass);
        return service;
    }
    public static PlaceService pCreate(Class<PlaceService> placeServiceClass) {
        PlaceService placeService = retrofit.create(placeServiceClass);
        return placeService;
    }
}
