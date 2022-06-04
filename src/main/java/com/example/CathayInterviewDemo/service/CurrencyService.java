package com.example.CathayInterviewDemo.service;

import com.example.CathayInterviewDemo.entity.CurrencyName;
import com.example.CathayInterviewDemo.repository.CurrencyNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyNameRepository currencyNameRepository;

    public List<CurrencyName> findAll(){
        return currencyNameRepository.findAll();
    }

    public Optional<CurrencyName> findById(Long id) {
        Optional<CurrencyName> currencyName = currencyNameRepository.findById(id);
        return currencyName;
    }

    public CurrencyName create(CurrencyName currencyName) {
        return currencyNameRepository.save(currencyName);
    }

    public String delete(Long id) {
        currencyNameRepository.deleteById(id);
        return "Deleted";
    }

    public String deleteAll() {
        currencyNameRepository.deleteAll();
        return "Deleted all";
    }

}
