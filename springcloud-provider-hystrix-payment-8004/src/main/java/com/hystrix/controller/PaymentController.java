package com.hystrix.controller;

import com.hystrix.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String getInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentService.getInfo_Ok(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String getInfo_timeout(@PathVariable("id") Integer id) {
        String result = paymentService.getInfo_timeout(id);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }
}