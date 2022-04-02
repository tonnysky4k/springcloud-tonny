package com.hystrix.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    public String getInfo_Ok(Integer id);

    public String getInfo_timeout(Integer id);
    public String paymentCircuitBreaker(Integer id);
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id);
}