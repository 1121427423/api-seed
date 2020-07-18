package com.king.api.core;

/**
 * @author king
 * @Title: WeatherUtil
 * @Package com.king.api.core
 * @Description: 通过api获取地取的天气信息
 * @date 2020/7/1820:01
 */
public class WeatherUtil {
    private static final String WEATHER_URL_CITY_NAME = "http://wthrcdn.etouch.cn/weather_mini?city=";
    private static final String WEATHER_URL_CITY_KEY = "http://wthrcdn.etouch.cn/weather_mini?citykey=";

  /**
  　　* @Description: 根据城市名GET请求天气信息
  　　* @param cityName
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 20:33
  　　**/
    public static String getInfoByCityName(String cityName){
        String url = WEATHER_URL_CITY_NAME + cityName;
        return HttpUrlConnection.get(url);
    }
  /**
  　　* @Description: 根据城市编号GET请求天气信息
  　　* @param cityKey
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 20:33
  　　**/
    public static String getInfoByCityKey(Integer cityKey){
        String url = WEATHER_URL_CITY_KEY + cityKey;
        return HttpUrlConnection.get(url);
    }
}
