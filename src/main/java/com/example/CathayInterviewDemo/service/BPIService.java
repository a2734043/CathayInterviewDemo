package com.example.CathayInterviewDemo.service;

import com.example.CathayInterviewDemo.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BPIService {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public void get() throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();

        String res = HttpUtils.get();
        Map<String, Object> bpis = objectMapper.readValue(res, Map.class);
        bpis.keySet().forEach((key) -> {
//            Map<String, Object> bpi = objectMapper.
//            String code = bpi.get(key);

        });

//        Map<String, Object> timeMap
//        String updateTime = (Map<String, Object> bpis.get("time")).get("updatedISO").toString();

//        response.put("updatedTime", updateTime);
    }
}
