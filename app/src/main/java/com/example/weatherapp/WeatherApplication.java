package com.example.weatherapp;

import android.app.Application;
import android.content.Context;

public class WeatherApplication extends Application {
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }

    //申请到的令牌值
    public static final String TOKEN="605ITHI5C2KH4bW1";
}
