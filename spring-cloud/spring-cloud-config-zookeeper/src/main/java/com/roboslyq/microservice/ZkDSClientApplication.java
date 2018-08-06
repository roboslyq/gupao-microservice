package com.roboslyq.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient //尽可能使用EnableDiscoveryClient
public class ZkDSClientApplication
{
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/services")
    public List<String> getAllServices() {
         return  discoveryClient.getServices();
    }

    @GetMapping("/service/instance/{serviceName}")
    public List<String> getAllServiceInstance(@PathVariable String serviceName){
        return discoveryClient.getInstances(serviceName).stream().map(s->
                s.getServiceId()+"_"+s.getHost()+"_"+s.getPort()
        ).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZkDSClientApplication.class).web(true).run(args);
    }
}
