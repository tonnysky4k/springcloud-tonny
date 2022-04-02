package com.tonny.payment.controller;

import com.commons.bean.ResponseResult;
import com.commons.entity.Payment;
import com.tonny.payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

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
        System.out.println("payment="+payment);
        paymentService.save(payment);
        return new ResponseResult(200,"成功!"+serverPort,payment);
    }
}
