package com.akes.appweather.dataStruct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultList {


    @SerializedName("data")
    @Expose
    public Data data;

    @Override public String toString() {
        return data.toString();
    }

}