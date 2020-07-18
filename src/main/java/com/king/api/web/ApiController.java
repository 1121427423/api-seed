package com.king.api.web;

import com.alibaba.fastjson.JSONObject;
import com.king.api.model.User;
import com.king.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author king
 * @Title: ApiController
 * @Package com.king.api.web
 * @Description: api的controller
 * @date 2020/7/1817:56
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Resource
    private ApiService apiService;
  /**
  　　* @Description: 查询ip的所在地
  　　* @param ipAddress
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 18:06
  　　**/
    @GetMapping(value = "/ip")
    public JSONObject getIpLocation(@RequestParam String ipAddress) {
      return (JSONObject) JSONObject.parse(apiService.getIpLocation(ipAddress));
    }

  /**
  　　* @Description: 根据城市名GET请求天气信息
  　　* @param cityName
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 20:39
  　　**/
    @GetMapping(value = "/weather1")
    public JSONObject getWeatherInfo(@RequestParam String cityName) {
        return (JSONObject) JSONObject.parse(apiService.getWeatherInfo(cityName));
    }

  /**
  　　* @Description: 根据城市编号GET请求天气信息
  　　* @param cityKey
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 20:39
  　　**/
    @GetMapping(value = "/weather")
    public JSONObject getWeatherInfo(@RequestParam Integer cityKey) {
        return (JSONObject) JSONObject.parse(apiService.getWeatherInfo(cityKey));
    }
}
