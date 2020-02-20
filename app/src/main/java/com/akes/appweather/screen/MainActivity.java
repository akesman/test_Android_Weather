package com.akes.appweather.screen;

import android.os.Bundle;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.module.ManagerModule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    static ManagerModule managerModule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddActivity.startActivity(MainActivity.this);
            }
        });



        //запускаем все модули
        managerModule = new ManagerModule(this);

        loadDB();

        initScreen();

    }

    private void loadDB() {
        ArrayList<WeatherStruct> arrayListWeather = new ArrayList<>();
        managerModule.getDatabaseWeatherModule().readDB(arrayListWeather);
        managerModule.getMainListModule().addToList(arrayListWeather);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void initScreen()
    {

        managerModule.getRetrofitApiModule().getWeatherByCity("Moscow");
        managerModule.getRetrofitApiModule().getWeatherByCity("Sankt petersburg");

        managerModule.getMainListModule().refreshList();

        /*managerModule.getDatabaseWeatherModule().readDB(arrayListWeather);


        Call<ResultList> call = managerModule.getRetrofitApiModule().getWorldWeatherAPI().getData("London", "json", 5);
        call.enqueue(new Callback<ResultList>() {
            @Override
            public void onResponse(Call<ResultList> call, Response<ResultList> response) {
                System.out.println("asdasd");
                //Данные успешно пришли, но надо проверить response.body() на null

            }
            @Override
            public void onFailure(Call<ResultList> call, Throwable t) {
                System.out.println("error");
                //Произошла ошибка
            }
        });*/

    }


}
