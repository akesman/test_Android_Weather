package com.akes.appweather.screen;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.Weather;
import com.akes.appweather.dataStruct.WeatherStruct;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoActivity extends AppCompatActivity {

    WeatherStruct weatherType;

    ListView listView;


    //FIXME VBS
    public static void startActivity(Context context, WeatherStruct weatherType)
    {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra("name", weatherType.getNameCity());
        intent.putExtra("temp", weatherType.getTemperature());
        intent.putExtra("wind", weatherType.getWind());
        intent.putExtra("humidity", weatherType.getHumidity());
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        getSupportActionBar().hide();

        weatherType = new WeatherStruct();

        Bundle b = getIntent().getExtras();

        if(b != null) {
            weatherType.setNameCity(b.getString("name"));
            weatherType.setTemperature(b.getInt("temp"));
            weatherType.setWind(b.getInt("wind"));
            weatherType.setHumidity(b.getInt("humidity"));
        }

        initList();
        initButton();

        initListView(7);
    }

    public void initListView(int count)
    {
        ArrayList<String> name = new ArrayList<>();

        HashMap<String, WeatherStruct> hashMap = MainActivity.managerModule.getMainListModule().getArrayListWeathrt();

        WeatherStruct weatherStruct = hashMap.get(weatherType.getNameCity());

        int size = weatherStruct.getArrayListWeather().size();

        for(int i=0;i<(count<size?count:weatherStruct.getArrayListWeather().size());i++)
        {
            name.add( weatherStruct.getArrayListWeather().get(i).date +  "    " +weatherStruct.getArrayListWeather().get(i).hourly.get(0).tempC+"°C" );
        }

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, name);

        // присваиваем адаптер списку
        listView.setAdapter(adapter);
    }


    private void initButton() {
        Button buttonCancel = findViewById(R.id.button26);
        Button buttonOk = findViewById(R.id.button44);

        Button button5 = findViewById(R.id.button3);
        Button button7 = findViewById(R.id.button2);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initListView(5);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initListView(7);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initList() {
        listView = findViewById(R.id.listView);
        ((TextView) findViewById(R.id.textView134)).setText(weatherType.getNameCity());
        ((TextView) findViewById(R.id.textView132)).setText(""+weatherType.getTemperature() + "°C");
        ((TextView) findViewById(R.id.textView84)).setText(""+weatherType.getHumidity() + "%");
    }

}