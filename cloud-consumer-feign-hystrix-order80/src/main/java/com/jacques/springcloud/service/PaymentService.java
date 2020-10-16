package com.jacques.springcloud.service;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 支付服务
 * @date 2020/10/16 1:38
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @PostMapping("/payment/add")
    Result<Payment> add(Payment payment);

    @GetMapping("/payment/get/{id}")
    Result<Payment> get(@PathVariable(value = "id") long id);

    @GetMapping("/payment/feign/timeout")
    String feignTimeOut();

    @GetMapping("/payment/hystrix/timeout/{id}")
    Result<String> hystrixTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/error")
    Result<String> error();
}
