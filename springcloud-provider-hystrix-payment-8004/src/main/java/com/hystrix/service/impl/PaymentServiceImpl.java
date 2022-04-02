package com.hystrix.service.impl;

import com.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    public String getInfo_Ok(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " getInfo_Ok,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "getInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getInfo_timeout(Integer id) {
        int timeOut = 5;
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " getInfo_timeout,id:" + id + "\t" + "耗时（秒）" + timeOut;
    }

    // 兜底的方法
    public String getInfo_timeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " getInfo_timeoutHandler,id:" + id + "\t" + "我哭了，我是打杂的。";
    }

    // 在10秒内，如果10(或者以上)次请求有6次是失败的，就会进行服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    // 兜底的方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}