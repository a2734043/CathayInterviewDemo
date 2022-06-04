package com.example.CathayInterviewDemo.controller;

import com.example.CathayInterviewDemo.entity.CurrencyName;
import com.example.CathayInterviewDemo.repository.CurrencyNameRepository;
import com.example.CathayInterviewDemo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/currencies")
    public ResponseEntity getCurrencyName(){
        List<CurrencyName> currencyNames = currencyService.findAll();
        Map<Object, Object> map = new HashMap();
        map.put("Currency", currencyNames);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/currency/{id}")
    public ResponseEntity getCurrencyById(@PathVariable String id){
        Long id_long;
        try {
            id_long = Long.valueOf(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
        CurrencyName currencyName = currencyService.findById(id_long).orElse(null);
        if (currencyName == null) {
            return ResponseEntity.ok("null");
        }
        return ResponseEntity.ok(currencyName);
    }

    @PostMapping(value = "/currency", consumes = "application/json", produces = "application/json")
    public ResponseEntity createCurrencyName(@RequestBody CurrencyName currencyName){
        CurrencyName result = currencyService.create(currencyName);
        return ResponseEntity.ok(result.toString());
    }

    @DeleteMapping(value = "/currency/{id}")
    public ResponseEntity deleteCurrencyName(@PathVariable String id){
        Long id_long;
        try {
            id_long = Long.valueOf(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
        currencyService.delete(id_long);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping(value = "/currency/{id}")
    public ResponseEntity updateCurrencyName(
            @RequestBody CurrencyName inputCurrencyName,
            @PathVariable String id
    ){
        Long id_long;
        try {
            id_long = Long.valueOf(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("id type error");
        }
        Optional<CurrencyName> currencyNameById = currencyService.findById(id_long);
        CurrencyName currencyName = currencyNameById.orElse(new CurrencyName());
        currencyName.setCurrencyName(inputCurrencyName.getCurrencyName());
        currencyName.setChinessName(inputCurrencyName.getChinessName());

        CurrencyName result = currencyService.create(currencyName);
        return ResponseEntity.ok(result.toString());
    }

}
