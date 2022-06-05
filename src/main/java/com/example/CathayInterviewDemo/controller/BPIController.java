package com.example.CathayInterviewDemo.controller;

import com.example.CathayInterviewDemo.entity.CurrentPriceBean;
import com.example.CathayInterviewDemo.service.BPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BPIController {

    @Autowired
    BPIService bpiService;

    @GetMapping("bpi/currentprice")
    public ResponseEntity get() {
        try {
            CurrentPriceBean currentPriceBean = bpiService.get();
            return ResponseEntity.ok(currentPriceBean);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("bpi/currenciesInfo")
    public ResponseEntity getCurrenciesInfo(){
        Map<String, Object> result = bpiService.getCurrenciesInfo();
        return ResponseEntity.ok(result);
    }
}
