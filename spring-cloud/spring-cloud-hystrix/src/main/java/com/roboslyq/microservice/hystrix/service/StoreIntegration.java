package com.roboslyq.microservice.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("storeIntegration")
public class StoreIntegration {

    @HystrixCommand(
            fallbackMethod = "defaultStores",
            commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
        }
    )
    public Object getStores(Map<String, Object> parameters) throws Exception {
//        return "success"; //do stuff that might fail
        throw new Exception();
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "default fail back";/* something useful */
    }
}