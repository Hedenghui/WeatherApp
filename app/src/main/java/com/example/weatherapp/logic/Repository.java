package com.example.weatherapp.logic;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.logic.model.PlaceResponse;
import com.example.weatherapp.logic.network.WeatherNetwork;

import java.util.List;

public class Repository {
    private static String TAG = Repository.class.getName();
    private static List<PlaceResponse.Place> places;
    private static MutableLiveData<List<PlaceResponse.Place>> placeData = new MutableLiveData<>();
    private static String RESPONSE_STATUS = "ok";
    private static String RESPONSE_SUCCESS = "place response success...";
    private static String RESPONSE_FAILED = "place response failed...";
    private static String RESPONSE_ERROR = "place response error...";
    private static String RESPONSE_FINISH = "place response finish...";
    public MutableLiveData<List<PlaceResponse.Place>> searchPlaces(String query){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final PlaceResponse placeResponse = WeatherNetwork.searchPlaces(query);
                    if(placeResponse.getStatus().equals(RESPONSE_STATUS)) {
                        places = placeResponse.getPlaces();
                        Log.d(TAG, RESPONSE_SUCCESS);
                        placeData.postValue(places);
                    } else {
                        Log.d(TAG, RESPONSE_ERROR);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, RESPONSE_FAILED);
                } finally {
                    Log.d(TAG, RESPONSE_FINISH);
                }
            }
        }).start();
        return placeData;
    }
}
