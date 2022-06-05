package com.example.CathayInterviewDemo.service;

import com.example.CathayInterviewDemo.entity.CurrencyName;
import com.example.CathayInterviewDemo.entity.CurrentPriceBean;
import com.example.CathayInterviewDemo.repository.CurrencyNameRepository;
import com.example.CathayInterviewDemo.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class BPIService {
    @Autowired
    CurrencyNameRepository currencyNameRepository;

    public CurrentPriceBean get() throws JsonProcessingException {
        CurrentPriceBean currentPriceBean = HttpUtils.get();
        return currentPriceBean;
    }

    public Map<String, Object> getCurrenciesInfo() {
        Map<String, Object> result = new HashMap<>();

        CurrentPriceBean currentPriceBean = HttpUtils.get();
        String updateISO = currentPriceBean.getTime().getUpdatedISO();
        String updateTime = convertDisplayUpdatedTime(updateISO);
        result.put("UpdatedTime", updateTime);

        List<Map<String, Object>> currencies = new ArrayList<>();
        Map<String, Object> bpiList = currentPriceBean.getBpi();
        bpiList.keySet().forEach((key) -> {
            Map<String, Object> bpiMap = (Map<String, Object>) bpiList.get(key);
            currencies.add(getBPIInfo(bpiMap));
        });
        result.put("currencies", currencies);
        return result;
    }

    private Map<String, Object> getBPIInfo(Map<String, Object> bpiMap){
        Map<String, Object> bpiInfo = new HashMap<>();
        bpiInfo.put("code", bpiMap.getOrDefault("code", ""));
        bpiInfo.put("rate", bpiMap.getOrDefault("rate", ""));
        String code_chinessName = getCurrencyCHName((String) bpiMap.getOrDefault("code", ""));
        bpiInfo.put("chinessName", code_chinessName);
        return bpiInfo;
    }

    private String getCurrencyCHName(String code){
        List<CurrencyName> currencyNames = currencyNameRepository.findByCurrencyName(code);
        String name = currencyNames.stream().count() >= 1 ? currencyNames.get(0).getChinessName() : "";
        return name;
    }

    private String convertDisplayUpdatedTime(String updatedISO) {
        Date date = null;
        String dateToStr = "";
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(updatedISO);
            dateToStr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
        } catch (ParseException e) {
            dateToStr = updatedISO;
            e.printStackTrace();
        }
        return dateToStr;
    }
}
