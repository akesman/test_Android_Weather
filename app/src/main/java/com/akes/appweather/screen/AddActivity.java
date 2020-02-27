package com.akes.appweather.screen;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.WeatherStruct;

public class AddActivity extends AppCompatActivity {

    WeatherStruct weatherType;

    public static void startActivity(Context context)
    {
        Intent intent = new Intent(context, AddActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_city);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        getSupportActionBar().hide();

        weatherType = new WeatherStruct();

        initButton();
    }

    private void initButton() {
        Button buttonAdd = findViewById(R.id.button);
        final EditText textView = findViewById(R.id.editText);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getEditableText().toString();
                if(text != "")
                    MainActivity.managerModule.getRetrofitApiModule().getWeatherByCity(text);
                finish();

            }
        });

        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}