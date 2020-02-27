package com.akes.appweather.screen;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.akes.appweather.R;
import com.akes.appweather.adapters.InfoAdapter;
import com.akes.appweather.dataStruct.Hourly;
import com.akes.appweather.dataStruct.WeatherStruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    WeatherStruct weatherType;

    ListView listView;

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
        //getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        getSupportActionBar().hide();

        weatherType = new WeatherStruct();

        Bundle b = getIntent().getExtras();

        if(b != null) {
            weatherType.setNameCity(b.getString("name"));
            weatherType.setTemperature(b.getInt("temp"));
            weatherType.setWind(b.getInt("wind"));
            weatherType.setHumidity(b.getInt("humidity"));
        }


        initButton();
        initListView();
        initList();

    }

    public void initListView()
    {
        ArrayList<String> name = new ArrayList<>();

        HashMap<String, WeatherStruct> hashMap = MainActivity.managerModule.getMainListModule().getArrayListWeathrt();

        WeatherStruct weatherStruct = hashMap.get(weatherType.getNameCity());

        if(weatherStruct.getArrayListWeather().size()<=0) return;

        weatherType.setDate(weatherStruct.getDate());
        weatherType.setWind(weatherStruct.getWind());

        List<Hourly> listHourly = weatherStruct.getArrayListWeather().get(0).getHourly();

        // создаем адаптер
        InfoAdapter adapter = new InfoAdapter(this, listHourly);

        // присваиваем адаптер списку
        listView.setAdapter(adapter);
    }


    private void initButton() {
        Button buttonCancel = findViewById(R.id.button26);
        Button buttonOk = findViewById(R.id.button44);
        listView = findViewById(R.id.listView);
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
        ((TextView) findViewById(R.id.textView134)).setText(weatherType.getNameCity());
        ((TextView) findViewById(R.id.textView132)).setText(""+weatherType.getTemperature() + "°C");
        ((TextView) findViewById(R.id.textView84)).setText(""+weatherType.getHumidity() + "%");
        ((TextView) findViewById(R.id.textView6)).setText(""+weatherType.getDate());
        ((TextView) findViewById(R.id.textView4)).setText(""+weatherType.getWind() + " km/h");
    }
}