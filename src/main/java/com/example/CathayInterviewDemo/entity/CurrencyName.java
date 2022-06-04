package com.example.CathayInterviewDemo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CURRENCY_MAPPING")
public class CurrencyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CURRENCY_NAME")
    private String currencyName;

    @Column(name = "CURRENCY_CH_NAME")
    private String chinessName;

    @LastModifiedDate
    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime;

    public CurrencyName() {}

    public CurrencyName(String currencyName, String chinessName) {
        this.currencyName = currencyName;
        this.chinessName = chinessName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getChinessName() {
        return chinessName;
    }

    public void setChinessName(String chinessName) {
        this.chinessName = chinessName;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CurrencyName{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                ", chinessName='" + chinessName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
