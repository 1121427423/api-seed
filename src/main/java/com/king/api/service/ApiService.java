package com.king.api.service;

import org.springframework.stereotype.Service;

/**
 * @author king
 * @Title: ApiService
 * @Package com.king.api.service
 * @Description: api的service
 * @date 2020/7/1818:11
 */

public interface ApiService {
    String getIpLocation(String ipAddress);
    String getWeatherInfo(String cityName);
    String getWeatherInfo(Integer cityKey);
}
