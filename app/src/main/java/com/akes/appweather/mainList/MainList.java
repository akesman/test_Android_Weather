package com.akes.appweather.mainList;

import android.util.Log;
import android.widget.ListView;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.module.ManagerModule;
import com.akes.appweather.screen.MainActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainList {

    ManagerModule managerModule;
    HashMap<String,WeatherStruct> arrayListWeathrt;
    WeatherAdapter adapter;


    public MainList(ManagerModule managerModule)
    {
        arrayListWeathrt = new HashMap<>();
        this.managerModule = managerModule;

        //ListView
        ListView lvMain = (ListView) ((MainActivity)managerModule.getContext()).findViewById(R.id.weather_list);
        adapter = new WeatherAdapter(managerModule.getContext(), arrayListWeathrt);
        lvMain.setAdapter(adapter);

    }


    public void addToList(WeatherStruct weatherType)
    {
        arrayListWeathrt.put(weatherType.getNameCity(),weatherType);
        managerModule.getDatabaseWeatherModule().writeDB(weatherType);
        if(adapter!=null )adapter.notifyDataSetChanged();

        Log.e("TAGS" , "size Massive " + arrayListWeathrt.size() + " size adapter = " +  adapter.getCount());
    }

    public void addToList(ArrayList<WeatherStruct> weatherType)
    {
        for (WeatherStruct item:weatherType
             ) {
            arrayListWeathrt.put(item.getNameCity(),item);
            managerModule.getDatabaseWeatherModule().writeDB(item);
        }
        if(adapter!=null )adapter.notifyDataSetChanged();
    }

    /**
     * обновляем данные с сайта
     */
    public void refreshList()
    {
        for (Map.Entry<String, WeatherStruct>  item:arrayListWeathrt.entrySet()
        ) {
            managerModule.getRetrofitApiModule().getWeatherByCity(item.getValue().getNameCity());
        }
    }

    public HashMap<String, WeatherStruct> getArrayListWeathrt() {
        return arrayListWeathrt;
    }
}
