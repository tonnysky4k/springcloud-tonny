package com.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients            // 开启OpenFeign的支持，该注解千万不能忘记
public class OrderNacosMain84 {

    public static void main(String[] args) {

        SpringApplication.run(OrderNacosMain84.class, args);
    }
}