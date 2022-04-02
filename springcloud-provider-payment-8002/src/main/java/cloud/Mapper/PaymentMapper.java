package cloud.Mapper;


import com.commons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    // 保存一个支付流水
    public void insert(Payment payment);

    // 根据id获取具体的支付信息
    public Payment selectById(@Param("id") Integer id);
}
