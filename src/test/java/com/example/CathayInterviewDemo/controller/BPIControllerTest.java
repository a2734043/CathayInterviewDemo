package com.example.CathayInterviewDemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class BPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void get() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bpi/currentprice")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getCurrenciesInfo() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bpi/currenciesInfo")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}