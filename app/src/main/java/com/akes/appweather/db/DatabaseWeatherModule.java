package com.akes.appweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.module.ManagerModule;

import java.util.ArrayList;

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
        //if(db == null || db.isOpen()) return;

        db = dbHelper.getWritableDatabase();
        Log.d(tag, "--- Rows in mytable: ---");
        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = db.query("weatherTable", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int nameColIndex = c.getColumnIndex("NameCity");
            int humidityColIndex = c.getColumnIndex("Humidity");
            int precipitationColIndex = c.getColumnIndex("Precipitationaccuracy");
            int temperatureColIndex = c.getColumnIndex("Temperature");
            int windColIndex = c.getColumnIndex("Wind");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(tag,
                                ", name = " + c.getString(nameColIndex) +
                                ", email = " + c.getString(nameColIndex));


                arrayListWeather.add(new WeatherStruct(c.getString(nameColIndex),
                        c.getInt(temperatureColIndex),
                        c.getInt(humidityColIndex),
                        c.getInt(windColIndex),
                        c.getInt(precipitationColIndex)));

                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d(tag, "0 rows");
        c.close();
    }

    public void writeDB(WeatherStruct weatherType)
    {
       // if(db == null || db.isOpen()) return;

        // подключаемся к БД
        db = dbHelper.getWritableDatabase();

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        cv.put("NameCity", weatherType.getNameCity());
        cv.put("Humidity", weatherType.getHumidity());
        cv.put("Precipitationaccuracy", weatherType.getPrecipitation_accuracy());
        cv.put("Temperature", weatherType.getTemperature());
        cv.put("Wind", weatherType.getWind());
        long rowID = db.insert("weatherTable", null, cv);
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
                    + "Precipitationaccuracy text,"
                    + "Temperature text,"
                    + "Wind text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
