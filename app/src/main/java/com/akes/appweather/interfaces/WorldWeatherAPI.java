package com.akes.appweather.interfaces;

import com.akes.appweather.dataStruct.PostModel;
import com.akes.appweather.dataStruct.ResultList;
import com.akes.appweather.dataStruct.WeatherDay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WorldWeatherAPI {
    @GET("/premium/v1/weather.ashx?key=2139434ca47343119bf174702201902")
    Call<ResultList> getData(@Query("q") String resourceName, @Query("format") String format);
    @GET("/premium/v1/weather.ashx?key=2139434ca47343119bf174702201902")
    Call<ResultList> getData(@Query("q") String resourceName, @Query("format") String format,  @Query("num_of_days") int num_of_days);
}
