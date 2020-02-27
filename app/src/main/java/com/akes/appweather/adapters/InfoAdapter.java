package com.akes.appweather.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.akes.appweather.R;
import com.akes.appweather.dataStruct.Hourly;
import com.akes.appweather.utils.TimeUtils;

import java.util.List;

public class InfoAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    List<Hourly> objects;

    public InfoAdapter(Context context, List<Hourly> infoList) {
        ctx = context;
        objects = infoList;
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
        return objects.get(position);
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
            view = lInflater.inflate(R.layout.item_info_list, parent, false);
        }

        final Hourly p = ((Hourly)getItem(position));

        int time = Integer.valueOf(p.getTime());
        ((TextView) view.findViewById(R.id.texttime)).setText(TimeUtils.intToTime(TimeUtils.hoursToMillisec(time)));
        ((TextView) view.findViewById(R.id.texttemp)).setText(p.getTempC() + "°C");
        ((TextView) view.findViewById(R.id.textWeatherDesc)).setText(p.getWeatherDesc().get(0).getValue());

        return view;
    }



}