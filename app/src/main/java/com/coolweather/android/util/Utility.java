package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by August on 2017/3/3.
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i <allProvinces.length() ; i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();//添加到数据库中
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
/**
 * 解析和处理服务器返回的市级数据
 */
    public static boolean handleCityResponse(String response,int provinceId){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i <allCities.length() ; i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);

                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
/**
 * 解析和处理服务器返回的县级数据
 */
    public static boolean handleCountyResponse(String response,int cityId){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i <allCounties.length() ; i++) {
                    JSONObject cityObject = allCounties.getJSONObject(i);

                    County county = new County();
                    county.setCountyName(cityObject.getString("name"));
                    county.setWeatherId(cityObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

}
