package com.example.weatherapp.logic.network;

import android.util.Log;

import com.example.weatherapp.logic.model.PlaceResponse;

import java.io.IOException;

import retrofit2.Response;

public class WeatherNetwork {
    private static PlaceService placeService=ServiceCreator.pCreate(PlaceService.class);
    private static PlaceResponse Presult=new PlaceResponse();

    public static PlaceResponse searchPlaces(String query){
        try{
            Response<PlaceResponse> response=placeService.searchPlace(query).execute();
            PlaceResponse body=response.body();
            if(body!=null){
                Presult=body;
                Log.d("WeatherNetwork","响应结果不为空");
                Log.d("WeatherNetwork","status :" +Presult.getStatus());
            }else{
                Log.d("WeatherNetwork","请求结果为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return Presult;
        }
    }
}
