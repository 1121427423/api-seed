package com.king.api.service.impl;

import com.king.api.core.IpUtil;
import com.king.api.core.WeatherUtil;
import com.king.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author king
 * @Title: ApiServiceImpl
 * @Package com.king.api.service.impl
 * @Description: ApiService的具体实现类
 * @date 2020/7/1818:14
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Override
    public String getIpLocation(String ipAddress) {
        return  IpUtil.getUserLocation(ipAddress);
    }

    @Override
    public String getWeatherInfo(String cityName) {
        return WeatherUtil.getInfoByCityName(cityName);
    }

    @Override
    public String getWeatherInfo(Integer cityKey) {
        return WeatherUtil.getInfoByCityKey(cityKey);
    }
}
