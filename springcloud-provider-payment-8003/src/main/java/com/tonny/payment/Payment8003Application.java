package com.tonny.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment8003Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8003Application.class , args);
    }
}
