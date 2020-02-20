package com.akes.appweather.dataStruct;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String type) {
        this.date = type;
    }

}
