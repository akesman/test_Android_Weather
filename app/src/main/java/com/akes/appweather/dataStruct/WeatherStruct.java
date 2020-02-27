package com.akes.appweather.dataStruct;

import java.util.ArrayList;

/**
 * Необходимо создать погодное приложение. Приложение должно иметь
 * минимум 2 встроенных города (Санкт-Петербург, Москва), пользователь
 * может добавить свой город. Приложение должно выводить города с
 * указание температуры, приложение должно уметь показывать более
 * подробную информацию по городу и уметь показывать прогноз погоды (3
 * или 7 дней.
 */

public class WeatherStruct {
    String nameCity;
    String date;
    int temperature;
    int humidity;
    int wind;
    int precipitation_accuracy;
    ArrayList<Weather> arrayListWeather;
    public WeatherStruct()
    {
        this.date = "";
        this.nameCity = "";
        this.temperature = -1;
        this.humidity = -1;
        this.wind = -1;
        this.precipitation_accuracy = -1;
        arrayListWeather= new ArrayList<>();
    }


    public WeatherStruct(String nameCity, int temperature, int humidity, int wind, String date) {
        this.nameCity = nameCity;
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.date = date;
        arrayListWeather = new ArrayList<>();
    }

    public String getNameCity() {
        return nameCity;
    }

    public ArrayList<Weather> getArrayListWeather() {
        return arrayListWeather;
    }

    public void setArrayListWeather(ArrayList<Weather> arrayListWeather) {
        this.arrayListWeather = arrayListWeather;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getWind() {
        return wind;
    }

    public int getPrecipitation_accuracy() {
        return precipitation_accuracy;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public void setPrecipitation_accuracy(int precipitation_accuracy) {
        this.precipitation_accuracy = precipitation_accuracy;
    }

    public void addWeather(Weather weather)
    {
        arrayListWeather.add(weather);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
