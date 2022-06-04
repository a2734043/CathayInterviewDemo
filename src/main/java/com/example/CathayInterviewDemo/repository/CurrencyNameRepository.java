package com.example.CathayInterviewDemo.repository;

import com.example.CathayInterviewDemo.entity.CurrencyName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyNameRepository extends JpaRepository<CurrencyName, Long> {
    List<CurrencyName> findAll();
    List<CurrencyName> findByCurrencyName(String currencyName);
}
