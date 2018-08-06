package com.roboslyq.microservice.hystrix.controller;

import com.roboslyq.microservice.hystrix.service.StoreIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
    @Autowired
    private StoreIntegration storeIntegration;
    @GetMapping("/hystrix/say/{message}")
    public String say(@PathVariable String message){
        try {
            return  "hello," + message+storeIntegration.getStores(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "aa";
    }
}
