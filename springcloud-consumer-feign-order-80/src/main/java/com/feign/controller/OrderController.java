package com.feign.controller;


import com.commons.bean.ResponseResult;
import com.commons.entity.Payment;
import com.feign.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public Payment getPaymentById(@PathVariable("id") Integer id) {
        return paymentFeignService.queryById(id).getData();
    }

    @GetMapping("/consumer/payment/getInfo")
    public ResponseResult getInfo(){
        return paymentFeignService.getInfo();
    }
}
