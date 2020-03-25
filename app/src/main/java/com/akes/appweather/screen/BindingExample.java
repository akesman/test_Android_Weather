package com.akes.appweather.screen;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.ExampleStruct;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.databinding.ActivityBindingExampleBinding;
import com.akes.appweather.module.ManagerModule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BindingExample extends AppCompatActivity {

    ExampleStruct exampleStruct;

    volatile boolean running = true;
    volatile int indexChange = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding_example);


        exampleStruct = new ExampleStruct();
        ActivityBindingExampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_example);
        binding.setBindingExample(exampleStruct);

        startThread();

    }

    private void startThread() {
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {

                    indexChange++;
                    System.out.println("CurrentChangename " + exampleStruct.getName());
                    exampleStruct.setName(""+indexChange);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
