package com.akes.appweather.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
    static StringBuilder stringBuilder = new StringBuilder();

    static public int hoursToMillisec(int hours)
    {
        int time = hours;
        time *= 36000;
        return time;
    }
    static public String intToTime(String timeInt)
    {return intToTime(Integer.valueOf(timeInt)); }
    static public String intToTime(int millis)
    {
        stringBuilder.setLength(0);
        if (TimeUnit.MILLISECONDS.toHours(millis) >= 1) {
            stringBuilder.append(TimeUnit.MILLISECONDS.toHours(millis));
            stringBuilder.append(":");
        }
        if (TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1) < 10)
            stringBuilder.append(0);
        stringBuilder.append(TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1));
        //stringBuilder.append(":");

        //if (TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1) < 10)
        //    stringBuilder.append(0);
        //stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));

        String str = stringBuilder.toString();
        return str;

    }
}
