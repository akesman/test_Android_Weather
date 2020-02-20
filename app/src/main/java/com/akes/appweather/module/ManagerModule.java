package com.akes.appweather.module;

import android.content.Context;

import com.akes.appweather.api.RetrofitApiModule;
import com.akes.appweather.db.DatabaseWeatherModule;
import com.akes.appweather.mainList.MainList;
import com.akes.appweather.screen.MainActivity;

public class ManagerModule {

    Context context;
    MainList mainListModule;
    DatabaseWeatherModule databaseWeatherModule;
    RetrofitApiModule retrofitApiModule;

    public ManagerModule(MainActivity mainActivity) {
        context = mainActivity;
        mainListModule = new MainList(this);
        databaseWeatherModule = new DatabaseWeatherModule(this);
        retrofitApiModule = new RetrofitApiModule(this);
    }

    public MainList getMainListModule() {
        return mainListModule;
    }

    public DatabaseWeatherModule getDatabaseWeatherModule() {
        return databaseWeatherModule;
    }

    public Context getContext() {
        return context;
    }

    public RetrofitApiModule getRetrofitApiModule() {
        return retrofitApiModule;
    }
}
