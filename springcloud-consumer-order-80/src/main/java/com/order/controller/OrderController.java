package com.order.controller;

import com.commons.bean.ResponseResult;
import com.commons.entity.Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://springcloud-payment-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
 /*

    // 根据id查询
    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult queryById(@PathVariable("id") Integer id){
        ResponseResult rs = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id , ResponseResult.class);
        return rs;
    }

    // 创建订单
    @GetMapping("/consumer/payment/save")
    public ResponseResult save(Payment payment){
        ResponseResult rs = restTemplate.postForObject(PAYMENT_URL + "/payment/save" , payment,ResponseResult.class);
        return rs;
    }


    // 根据id查询
    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult queryById(@PathVariable("id") Integer id){

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-PROVIDER-SERVICE");
        ServiceInstance instance = serviceInstances.get(0);

        ResponseResult rs = restTemplate.getForObject("http://"+ instance.getHost() + ":" + instance.getPort() + "/payment/get/" + id , ResponseResult.class);
        return rs;
    }

    // 创建订单
    @GetMapping("/consumer/payment/save")
    public ResponseResult save(Payment payment){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-PROVIDER-SERVICE");
        ServiceInstance instance = serviceInstances.get(0);

        ResponseResult rs = restTemplate.postForObject("http://"+ instance.getHost() + ":" + instance.getPort() + "/payment/save" , payment,ResponseResult.class);
        return rs;
    }

     */

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate
                .getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
}
