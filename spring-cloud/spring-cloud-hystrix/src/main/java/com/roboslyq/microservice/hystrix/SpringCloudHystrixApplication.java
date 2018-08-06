package com.roboslyq.microservice.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class SpringCloudHystrixApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(SpringCloudHystrixApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
