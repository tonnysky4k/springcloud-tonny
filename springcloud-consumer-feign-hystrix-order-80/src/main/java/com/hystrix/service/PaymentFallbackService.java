package com.hystrix.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String getInfo_Ok(Integer id) {
        return "----PaymentFallbackService getInfo_Ok 失败了...";
    }

    @Override
    public String getInfo_timeout(Integer id) {
        return "---PaymentFallbackService getInfo_timeout 失败了...";
    }
}