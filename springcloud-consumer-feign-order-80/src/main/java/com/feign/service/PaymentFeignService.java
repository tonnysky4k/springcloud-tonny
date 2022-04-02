package com.feign.service;


import com.commons.bean.ResponseResult;
import com.commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "springcloud-payment-provider-service")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public ResponseResult<Payment> queryById(@PathVariable(name = "id") Integer id);

    @GetMapping("/payment/getInfo")
    public ResponseResult getInfo();
}
