package com.king.api.core;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class HttpUrlConnection {

    /**
     　　* @Description: GET请求天气信息
     　　* @param url
     　　* @return String
     　　* @throws
     　　* @author king
     　　* @date 2020/7/18 20:31
     　　**/
    public static String get(String url) {
        HttpURLConnection conn = null;
        StringBuffer weatherInfo = null;
        try {
            conn = getConn(url, "GET");
            weatherInfo = new StringBuffer();
            InputStream stream = new GZIPInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(stream,"utf-8"));
            String line = null;
            while ((line = br.readLine()) != null)
                weatherInfo.append(line);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
        return weatherInfo.toString();
    }

  /**
  　　* @Description: POST请求天气信息
  　　* @param url
  　　* @return String
  　　* @throws
  　　* @author king
  　　* @date 2020/7/18 20:31
  　　**/
    public static String post(String url) {
        HttpURLConnection conn = null;
        StringBuffer data = null;
        try {
            conn = getConn(url, "POST");
            InputStream stream = new GZIPInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(stream,"utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                data.append(line);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
        return data.toString();
    }

    /**
     　　* @Description: http连接
     　　* @param url，reqType
     　　* @return HttpURLConnection
     　　* @throws
     　　* @author king
     　　* @date 2020/7/18 20:31
     　　**/
    public static HttpURLConnection getConn(String url, String reqType) throws IOException {
        HttpURLConnection conn = null;  //java.net.HttpURLConnection
        URL u = new URL(url);
        conn = (HttpURLConnection) u.openConnection();
        //默认为false,post方法需要写入参数,设定true
        conn.setConnectTimeout(3000);// 设置连接超时时间，单位毫秒
        conn.setReadTimeout(3000);// 设置读取数据超时时间，单位毫秒
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");//设定post方法,默认get
        conn.connect();//建立连接
        return conn;
    }
}
