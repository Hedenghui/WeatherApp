package com.example.weatherapp.ui.place;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.logic.Repository;
import com.example.weatherapp.logic.model.PlaceResponse;

import java.util.ArrayList;
import java.util.List;

public class PlaceViewModel extends ViewModel {
    private Repository repository = new Repository();
    private MutableLiveData<String> searchLiveData = new MutableLiveData<>();
    private static List<PlaceResponse.Place> placeList = new ArrayList<>();
    public final LiveData<List<PlaceResponse.Place>> placeLiveData = Transformations.switchMap(searchLiveData,
            query->repository.searchPlaces(query));

    public void searchPlace(String query) {
        searchLiveData.postValue(query);
    }


    public List<PlaceResponse.Place> getPlaceList() {
        return placeList;
    }

    public void listClear() {
        placeList.clear();
    }

    public void addAllList(List<PlaceResponse.Place> places) {
        placeList.addAll(places);
    }
}
