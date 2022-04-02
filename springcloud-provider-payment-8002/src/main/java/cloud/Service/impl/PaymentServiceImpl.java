package cloud.Service.impl;

import cloud.Mapper.PaymentMapper;
import cloud.Service.PaymentService;
import com.commons.entity.Payment;

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
