package com.tonny.cloud.controller;

import com.commons.bean.ResponseResult;

import com.commons.entity.Payment;
import com.tonny.cloud.Service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {
/*
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;	// 加端口

    @GetMapping("/payment/get/{id}")
    public ResponseResult queryById(@PathVariable(name = "id") Integer id){
        Payment payment = paymentService.queryById(id);
        if (payment != null){
            return new ResponseResult(200 , "成功!"+serverPort,payment);
        }else{
            return new ResponseResult(404, "没有对应记录，查询ID:" + id, null);
        }
    }

    @PostMapping("/payment/save")
    public ResponseResult save(@RequestBody Payment payment){
        paymentService.save(payment);
        return new ResponseResult(200,"成功!"+serverPort,payment);
    }


    @GetMapping("/payment/getInfo")
    public ResponseResult getInfo(){
        try {
            // 模拟需要3秒钟执行
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String value = UUID.randomUUID().toString() + ":" + serverPort;
        return new ResponseResult(200,"成功!", value);
    }
    */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "paymentZipkin provider";
    }
}
