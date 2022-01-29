package com.example.weatherapp.logic;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.logic.model.PlaceResponse;
import com.example.weatherapp.logic.network.WeatherNetwork;

import java.util.List;

public class Repository {
    private static List<PlaceResponse.Place> places;
    private static MutableLiveData<List<PlaceResponse.Place>> placeData=new MutableLiveData<>();
    public MutableLiveData<List<PlaceResponse.Place>> searchPlaces(String query){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    final PlaceResponse placeResponse= WeatherNetwork.searchPlaces(query);
                    if(placeResponse.getStatus().equals("ok")){
                        places=placeResponse.getPlaces();
                        Log.d("Repository","place response success " );
                        placeData.postValue(places);
                    }else{
                        Log.d("Repository","返回的状态不为ok");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Log.d("Repository","PlaceResponse Error!");
                }finally{
                    Log.d("Repository","PlaceResponse finish!");
                }
            }
        }).start();
        return placeData;
    }
}
