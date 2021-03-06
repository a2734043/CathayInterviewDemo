package com.example.CathayInterviewDemo.utils;

import com.example.CathayInterviewDemo.entity.CurrentPriceBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ConnectionPool connectionPool = new ConnectionPool(20, 10, TimeUnit.MINUTES);
    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(Duration.ofMillis(10000))
            .readTimeout(Duration.ofMillis(10000))
            .connectionPool(connectionPool)
            .retryOnConnectionFailure(true)
            .build();
    private static String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public static CurrentPriceBean get() {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            int status = response.code();
            if (status == 200) {
                String res = response.body().string();
                CurrentPriceBean currentPriceBean = null;
                try {
                    currentPriceBean = objectMapper.readValue(res, CurrentPriceBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return currentPriceBean;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
