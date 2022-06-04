package com.example.CathayInterviewDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BPIController {

    @GetMapping("bpi/faq")
    public String getFaq() {
        return "ok";
    }
}
