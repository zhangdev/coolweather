package com.coolweather.android.gson;

/**
 * Created by August on 2017/3/6.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
