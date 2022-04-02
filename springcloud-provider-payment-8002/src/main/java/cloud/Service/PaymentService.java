package cloud.Service;


import com.commons.entity.Payment;

public interface PaymentService {

    // 保存一个支付流水
    public void save(Payment payment);

    // 根据id获取具体的支付信息
    public Payment queryById(Integer id);
}
