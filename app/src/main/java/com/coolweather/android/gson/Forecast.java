package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by August on 2017/3/6.
 */

public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    public class Temperature {
        public String max;
        public String min;
    }

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
