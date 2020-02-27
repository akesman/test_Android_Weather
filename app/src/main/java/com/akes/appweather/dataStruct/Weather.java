package com.akes.appweather.dataStruct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class Weather {

    @SerializedName("avgtempC")
    @Expose
    public int avgtempC;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("maxtempC")
    @Expose
    public String maxtempC;
    @SerializedName("maxtempF")
    @Expose
    public String maxtempF;
    @SerializedName("mintempC")
    @Expose
    public String mintempC;
    @SerializedName("mintempF")
    @Expose
    public String mintempF;
    @SerializedName("totalSnow_cm")
    @Expose
    public String totalSnowCm;
    @SerializedName("sunHour")
    @Expose
    public String sunHour;
    @SerializedName("uvIndex")
    @Expose
    public String uvIndex;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = new ArrayList<>();

    public int getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(int avgtempC) {
        this.avgtempC = avgtempC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getTotalSnowCm() {
        return totalSnowCm;
    }

    public void setTotalSnowCm(String totalSnowCm) {
        this.totalSnowCm = totalSnowCm;
    }

    public String getSunHour() {
        return sunHour;
    }

    public void setSunHour(String sunHour) {
        this.sunHour = sunHour;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

}