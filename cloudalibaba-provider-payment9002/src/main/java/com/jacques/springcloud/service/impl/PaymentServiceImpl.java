package com.jacques.springcloud.service.impl;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.service.PaymentService;
import com.jacques.springcloud.dao.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 支付服务
 * @note 文件说明
 * @date 2020/10/14 22:27
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * set注入
     */
    private PaymentMapper paymentMapper;

    @Autowired
    public void getPaymentMapper(@Lazy PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    /**
     * 新增
     */
    @Override
    public int add(Payment payment) {
        return paymentMapper.insert(payment);
    }

    /**
     * 修改
     */
    @Override
    public int upd(Payment payment) {
        return paymentMapper.updateById(payment);
    }

    /**
     * 删除
     */
    @Override
    public int del(long id) {
        return paymentMapper.deleteById(id);
    }

    /**
     * 查询
     *
     * @return
     */
    @Override
    public Payment get(long id) {
        return paymentMapper.selectById(id);
    }
}
