package com.hystrix.controller;

import com.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String getInfo_Ok(@PathVariable("id") Integer id){
        return paymentService.getInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String getInfo_timeout(@PathVariable("id") Integer id){
        return paymentService.getInfo_timeout(id);
    }

    public String getInfo_timeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者,对方超时或者自己程序运行出错了，我先撤了..";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，服务器忙，请稍后再试";
    }
}