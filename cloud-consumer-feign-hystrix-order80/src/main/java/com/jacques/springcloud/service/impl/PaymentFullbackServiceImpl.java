package com.jacques.springcloud.service.impl;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import com.jacques.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info PaymentService服务降级
 * @date 2020/10/17 1:04
 */
@Component
public class PaymentFullbackServiceImpl implements PaymentService {
    @Override
    public Result<Payment> add(Payment payment) {
        return new Result<>(5000, "PaymentFullbackServiceImpl fallback add 服务器超时或异常,请稍后重试");
    }

    @Override
    public Result<Payment> get(long id) {
        return new Result<>(5000, "PaymentFullbackServiceImpl fallback get 服务器超时或异常,请稍后重试");
    }

    @Override
    public Result<String> hystrixTimeOut(Integer id) {
        return new Result<>(5000, "PaymentFullbackServiceImpl hystrixTimeOut error 服务器超时或异常,请稍后重试");
    }

    @Override
    public Result<String> error() {
        return new Result<>(5000, "PaymentFullbackServiceImpl fallback error 服务器超时或异常,请稍后重试");
    }
}
