package com.tonny.payment.Service.impl;

import com.commons.entity.Payment;

import com.tonny.payment.Mapper.PaymentMapper;
import com.tonny.payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public void save(Payment payment) {

        paymentMapper.insert(payment);

    }

    @Override
    public Payment queryById(Integer id) {
        return paymentMapper.selectById(id);
    }
}
