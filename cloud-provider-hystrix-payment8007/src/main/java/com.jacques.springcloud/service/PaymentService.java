package com.jacques.springcloud.service;

import com.jacques.springcloud.entity.Payment;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 支付信息服务
 * @note 文件说明
 * @date 2020/10/14 22:18
 */
public interface PaymentService {
    /**
     * 新增
     */
    int add(Payment payment);

    /**
     * 修改
     */
    int upd(Payment payment);

    /**
     * 删除
     */
    int del(long id);

    /**
     * 查询
     * @return
     */
    Payment get(long id);

    /**
     * 服务超时
     * @return
     * @param id
     */
    String hystrixTimeout(Integer id);

    /**
     * 服务异常
     * @return
     */
    String error();


    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
