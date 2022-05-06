package com.example.weatherapp.logic.network;

import android.util.Log;

import com.example.weatherapp.logic.model.PlaceResponse;

import java.io.IOException;

import retrofit2.Response;

public class WeatherNetwork {
    private static String TAG = WeatherNetwork.class.getName();
    private static String RESPONSE_RESULT_NOTNULL = "response result is not null";
    private static String RESPONSE_RESULT_NULL = "response result is null";
    private static PlaceService placeService = ServiceCreator.pCreate(PlaceService.class);
    private static PlaceResponse Presult = new PlaceResponse();

    public static PlaceResponse searchPlaces(String query) {
        try{
            Response<PlaceResponse> response = placeService.searchPlace(query).execute();
            PlaceResponse body = response.body();
            if(body!=null){
                Presult = body;
                Log.d(TAG, RESPONSE_RESULT_NOTNULL);
                Log.d(TAG,"status :" + Presult.getStatus());
            }else{
                Log.d(TAG, RESPONSE_RESULT_NULL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return Presult;
        }
    }
}
