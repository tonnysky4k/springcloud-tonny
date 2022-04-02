package com.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer server_port;

    @GetMapping("/payment/consul")
    public String getPayment(){
        return UUID.randomUUID().toString()+"---端口:"+server_port;
    }


}
