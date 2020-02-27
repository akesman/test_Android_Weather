package com.akes.appweather.api;


import android.widget.Toast;

import com.akes.appweather.dataStruct.ResultList;
import com.akes.appweather.dataStruct.Weather;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.interfaces.WorldWeatherAPI;
import com.akes.appweather.module.ManagerModule;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiModule {
    retrofit2.Retrofit retrofit;
    WorldWeatherAPI worldWeatherAPI;
    ManagerModule managerModule;

    public RetrofitApiModule(ManagerModule managerModule){
        this.managerModule = managerModule;
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://api.worldweatheronline.com") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        worldWeatherAPI = retrofit.create(WorldWeatherAPI.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public void getWeatherByCity(final String city)
    {
        try {
            Call<ResultList> call = worldWeatherAPI.getData(city, "json", 1);
            call.enqueue(new Callback<ResultList>() {
                @Override
                public void onResponse(Call<ResultList> call, Response<ResultList> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null

                    if(response.body().data == null || response.body().data.weather == null) {
                        Toast.makeText(managerModule.getContext(), "Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(response.body().data.weather.size()>0) {

                        List<Weather> list = response.body().data.weather;
                        WeatherStruct weatherStruct = new WeatherStruct();
                        weatherStruct.setNameCity(city);
                        weatherStruct.setDate(list.get(0).date);
                        weatherStruct.setTemperature(list.get(0).getAvgtempC());
                        if(list.get(0).getHourly().size()>0) {
                            //weatherStruct.setTemperature(list.get(0).getHourly().get(0).getTempC());
                            weatherStruct.setHumidity(list.get(0).getHourly().get(0).humidity);
                            weatherStruct.setWind(list.get(0).getHourly().get(0).windspeedKmph);
                        }

                        for (Weather item:list
                             ) {
                            weatherStruct.addWeather(item);
                        }
                        managerModule.getMainListModule().addToList(weatherStruct);
                    }
                }
                @Override
                public void onFailure(Call<ResultList> call, Throwable t) {
                    System.out.println("error");
                    //Произошла ошибка
                }
            });
        }catch (Exception e)
        {

        }
    }
}
