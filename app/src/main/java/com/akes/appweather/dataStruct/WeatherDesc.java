package com.akes.appweather.dataStruct;


import com.google.gson.annotations.Expose;

public class WeatherDesc {

    @Expose
    private String value;

    public WeatherDesc(String s) {
        value = s;
    }

    /**
     *
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}