package com.akes.appweather.dataStruct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Hourly {

    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("tempC")
    @Expose
    public int tempC;
    @SerializedName("tempF")
    @Expose
    public String tempF;
    @SerializedName("windspeedMiles")
    @Expose
    public String windspeedMiles;
    @SerializedName("windspeedKmph")
    @Expose
    public int windspeedKmph;
    @SerializedName("winddirDegree")
    @Expose
    public String winddirDegree;
    @Expose
    private List<WeatherDesc> weatherDesc = new ArrayList<>();
    @SerializedName("winddir16Point")
    @Expose
    public String winddir16Point;
    @SerializedName("weatherCode")
    @Expose
    public String weatherCode;
    @SerializedName("precipMM")
    @Expose
    public String precipMM;
    @SerializedName("humidity")
    @Expose
    public int humidity;
    @SerializedName("visibility")
    @Expose
    public String visibility;
    @SerializedName("pressure")
    @Expose
    public String pressure;
    @SerializedName("cloudcover")
    @Expose
    public String cloudcover;
    @SerializedName("HeatIndexC")
    @Expose
    public String heatIndexC;
    @SerializedName("HeatIndexF")
    @Expose
    public String heatIndexF;
    @SerializedName("DewPointC")
    @Expose
    public String dewPointC;
    @SerializedName("DewPointF")
    @Expose
    public String dewPointF;
    @SerializedName("WindChillC")
    @Expose
    public String windChillC;
    @SerializedName("WindChillF")
    @Expose
    public String windChillF;
    @SerializedName("WindGustMiles")
    @Expose
    public String windGustMiles;
    @SerializedName("WindGustKmph")
    @Expose
    public String windGustKmph;
    @SerializedName("FeelsLikeC")
    @Expose
    public String feelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    public String feelsLikeF;
    @SerializedName("chanceofrain")
    @Expose
    public String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    public String chanceofremdry;
    @SerializedName("chanceofwindy")
    @Expose
    public String chanceofwindy;
    @SerializedName("chanceofovercast")
    @Expose
    public String chanceofovercast;
    @SerializedName("chanceofsunshine")
    @Expose
    public String chanceofsunshine;
    @SerializedName("chanceoffrost")
    @Expose
    public String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    public String chanceofhightemp;
    @SerializedName("chanceoffog")
    @Expose
    public String chanceoffog;
    @SerializedName("chanceofsnow")
    @Expose
    public String chanceofsnow;
    @SerializedName("chanceofthunder")
    @Expose
    public String chanceofthunder;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTempC() {
        return tempC;
    }

    public void setTempC(int tempC) {
        this.tempC = tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }


    public int getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(int windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getHeatIndexC() {
        return heatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    public String getHeatIndexF() {
        return heatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        this.heatIndexF = heatIndexF;
    }

    public String getDewPointC() {
        return dewPointC;
    }

    public void setDewPointC(String dewPointC) {
        this.dewPointC = dewPointC;
    }

    public String getDewPointF() {
        return dewPointF;
    }

    public void setDewPointF(String dewPointF) {
        this.dewPointF = dewPointF;
    }

    public String getWindChillC() {
        return windChillC;
    }

    public void setWindChillC(String windChillC) {
        this.windChillC = windChillC;
    }

    public String getWindChillF() {
        return windChillF;
    }

    public void setWindChillF(String windChillF) {
        this.windChillF = windChillF;
    }

    public String getWindGustMiles() {
        return windGustMiles;
    }

    public void setWindGustMiles(String windGustMiles) {
        this.windGustMiles = windGustMiles;
    }

    public String getWindGustKmph() {
        return windGustKmph;
    }

    public void setWindGustKmph(String windGustKmph) {
        this.windGustKmph = windGustKmph;
    }

    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    public String getChanceofrain() {
        return chanceofrain;
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public String getChanceofremdry() {
        return chanceofremdry;
    }

    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public String getChanceofwindy() {
        return chanceofwindy;
    }

    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public String getChanceofovercast() {
        return chanceofovercast;
    }

    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public String getChanceoffrost() {
        return chanceoffrost;
    }

    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public String getChanceoffog() {
        return chanceoffog;
    }

    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public String getChanceofsnow() {
        return chanceofsnow;
    }

    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public String getChanceofthunder() {
        return chanceofthunder;
    }

    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }
}
