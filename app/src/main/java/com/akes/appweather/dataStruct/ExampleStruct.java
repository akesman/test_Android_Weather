package com.akes.appweather.dataStruct;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ExampleStruct extends BaseObservable {
    private String name;
    private int count;
    private int width;
    private int sizeM;


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.akes.appweather.BR.name);
    }

    @Bindable
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyPropertyChanged(com.akes.appweather.BR.count);
    }

    @Bindable
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        notifyPropertyChanged(com.akes.appweather.BR.width);
    }

    @Bindable
    public int getSizeM() {
        return sizeM;
    }

    public void setSizeM(int sizeM) {
        this.sizeM = sizeM;
        notifyPropertyChanged(com.akes.appweather.BR.sizeM);
    }
}
