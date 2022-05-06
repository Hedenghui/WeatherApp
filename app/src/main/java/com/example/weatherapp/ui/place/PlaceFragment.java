package com.example.weatherapp.ui.place;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;

import com.example.weatherapp.logic.model.PlaceResponse;

import java.util.List;

public class PlaceFragment extends Fragment {
    private static PlaceViewModel viewModel;
    public PlaceViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        viewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        return inflater.inflate(R.layout.fragment_place, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView);
        //设置LayoutManager
        recyclerView.setLayoutManager(layoutManager);

        PlaceAdapter adapter = new PlaceAdapter(this, viewModel.getPlaceList());
        //设置适配器
        recyclerView.setAdapter(adapter);

        ImageView bgImageView;
        bgImageView = getActivity().findViewById(R.id.bgImageView);

        EditText searchPlaceEdit = getActivity().findViewById(R.id.searchPlaceEdit);
        //监听搜索框内部变化情况
        searchPlaceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String content = s.toString();
                Log.d("PlaceFragment", "query is" + content);
                if(content.isEmpty()) {
                    recyclerView.setVisibility(View.GONE);
                    bgImageView.setVisibility(View.VISIBLE);
                    viewModel.listClear();
                    adapter.notifyDataSetChanged();
                } else {
                    viewModel.searchPlace(content);
                    Log.d("PlaceFragment",""+viewModel.placeLiveData.getValue());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        viewModel.placeLiveData.observe(getViewLifecycleOwner(), new Observer<List<PlaceResponse.Place>>() {
            @Override
            public void onChanged(List<PlaceResponse.Place> placeList) {
                if(placeList != null) {
                    Log.d("PlaceFragment","数据已变化");
                    recyclerView.setVisibility(View.VISIBLE);
                    bgImageView.setVisibility(View.GONE);
                    viewModel.listClear();
                    viewModel.addAllList(placeList);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d("PlaceFragment","数据空");
                    Toast.makeText(getActivity(), "未能查询到任何地点", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

