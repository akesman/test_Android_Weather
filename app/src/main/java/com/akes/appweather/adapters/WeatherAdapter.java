package com.akes.appweather.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.WeatherStruct;
import com.akes.appweather.screen.InfoActivity;

import java.util.Collection;
import java.util.HashMap;

public class WeatherAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    Collection<WeatherStruct> objects;

    public WeatherAdapter(Context context, HashMap<String, WeatherStruct> products) {
        ctx = context;
        objects = (products.values());
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.toArray()[position];
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }


    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        final WeatherStruct p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.textnamecity)).setText(p.getNameCity());
        ((TextView) view.findViewById(R.id.texttemp)).setText(p.getTemperature() + "°C");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("WeatherAdapter" , "Click Item id = " + p.getNameCity());
                InfoActivity.startActivity(ctx, p);
            }
        });

        return view;
    }

    // товар по позиции
    WeatherStruct getProduct(int position) {
        return ((WeatherStruct) getItem(position));
    }

}