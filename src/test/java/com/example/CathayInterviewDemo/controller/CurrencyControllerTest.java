package com.example.CathayInterviewDemo.controller;

import com.example.CathayInterviewDemo.entity.CurrencyName;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class CurrencyControllerTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCurrencyName() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/currencies")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void createCurrencyName() throws Exception {
        CurrencyName currencyName = new CurrencyName("TWD", "新台幣");
        String currencyNameJson = objectMapper.writeValueAsString(currencyName);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/currency").content(currencyNameJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void deleteCurrencyName() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/currency/9");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void updateCurrencyName() throws Exception {
        CurrencyName currencyName = new CurrencyName("TWD", "新台幣");
        String currencyNameJson = objectMapper.writeValueAsString(currencyName);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/currency/1").content(currencyNameJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}