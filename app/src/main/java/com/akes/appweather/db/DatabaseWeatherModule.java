package com.akes.appweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.akes.appweather.dataStruct.Hourly;
import com.akes.appweather.dataStruct.Weather;
import com.akes.appweather.dataStruct.WeatherDesc;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.module.ManagerModule;

import java.util.ArrayList;
import java.util.List;

public class DatabaseWeatherModule {
    ManagerModule managerModule;

    String tag = "DB";
    DBHelper dbHelper;
    SQLiteDatabase db;

    public DatabaseWeatherModule(ManagerModule managerModule)
    {
        this.managerModule = managerModule;
        dbHelper = new DBHelper(managerModule.getContext());
    }


    public void readDB(ArrayList<WeatherStruct> arrayListWeather)
    {
        db = dbHelper.getWritableDatabase();

        Cursor c = db.query("weatherTable", null, null, null, null, null, null);
        if (c.moveToFirst()) {

            int nameColIndex =          c.getColumnIndex("NameCity");
            int humidityColIndex =      c.getColumnIndex("Humidity");
            int dateColIndex =          c.getColumnIndex("Date");
            int temperatureColIndex =   c.getColumnIndex("Temperature");
            int windColIndex =          c.getColumnIndex("Wind");
            int timeDayIndex =          c.getColumnIndex("timeDay");
            int tempDayIndex =          c.getColumnIndex("tempDay");
            int weatherStatusIndex =    c.getColumnIndex("weatherStatus");

            do {
                String str = c.getString(dateColIndex);
                WeatherStruct weatherStruct = new WeatherStruct(c.getString(nameColIndex),
                        c.getInt(temperatureColIndex),
                        c.getInt(humidityColIndex),
                        c.getInt(windColIndex),
                        str);


                //TODO считываем прогноз погоды за неделю
                String timeDayList = c.getString(timeDayIndex);
                String tempDayList = c.getString(tempDayIndex);
                String weatherStatusList = c.getString(weatherStatusIndex);

                String[] listTime = timeDayList.split(",");
                String[] listTemp = tempDayList.split(",");
                String[] listWeather = weatherStatusList.split(",");

                ArrayList<Weather> weathers = weatherStruct.getArrayListWeather();
                Weather weather = new Weather();
                for (int i = 0; i < listTime.length; i++) {
                    Hourly hourly = new Hourly();

                    hourly.setTime(listTime[i]);
                    hourly.setTempC(Integer.valueOf(listTemp[i]));
                    hourly.getWeatherDesc().add(new WeatherDesc(listWeather[i]));

                    weather.getHourly().add(hourly);

                }
                weathers.add(weather);

                arrayListWeather.add(weatherStruct);

            } while (c.moveToNext());
        } else
            Log.d(tag, "0 rows");
        c.close();
    }

    public void writeDB(WeatherStruct weatherType)
    {
        db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("NameCity",  weatherType.getNameCity());
        cv.put("Humidity",  weatherType.getHumidity());
        cv.put("Date",      weatherType.getDate());
        cv.put("Temperature", weatherType.getTemperature());
        cv.put("Wind",      weatherType.getWind());

        //TODO записываем прогноз погоды за неделю
        String timeDayList = "";
        String tempDayList = "";
        String weatherStatusList = "";

        if(weatherType.getArrayListWeather()!=null && weatherType.getArrayListWeather().size()!=0) {
            List<Hourly> hourlyList = weatherType.getArrayListWeather().get(0).getHourly();

            for (int i = 0; i < hourlyList.size(); i++) {

                timeDayList += hourlyList.get(i).time;
                tempDayList += hourlyList.get(i).tempC;
                weatherStatusList += hourlyList.get(i).getWeatherDesc().get(0).getValue();

                if (i != hourlyList.size() - 1) {
                    weatherStatusList += ",";
                    tempDayList += ",";
                    timeDayList += ",";
                }
            }

            cv.put("timeDay", timeDayList);
            cv.put("tempDay", tempDayList);
            cv.put("weatherStatus", weatherStatusList);
        }
        //////////////////////////////////////////////

        db.insert("weatherTable", null, cv);
        // закрываем подключение к БД
        dbHelper.close();

    }


    public void clearDB()
    {
        //if(db == null || db.isOpen()) return;

        // подключаемся к БД
        db = dbHelper.getWritableDatabase();

        int clearCount = db.delete("weatherTable", null, null);

        // закрываем подключение к БД
        dbHelper.close();
    }


    class DBHelper extends SQLiteOpenHelper {

        private DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(tag, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table weatherTable ("
                    + "NameCity text primary key,"
                    + "Humidity text,"
                    + "Date text,"
                    + "Temperature text,"
                    + "Wind text,"
                    + "timeDay text,"
                    + "tempDay text,"
                    + "weatherStatus text"
                    + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
