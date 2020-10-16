package com.jacques.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.jacques.springcloud.dao.PaymentMapper;
import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    /**
     * 服务超时
     * @return
     * @param id
     */
    /**
     * HystrixCommand 启用注解
     */
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            /**
             * 5秒服务超时
             */
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String hystrixTimeout(Integer id) {
        int seconds = 2;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务访问线程池:" + Thread.currentThread().getName() + " ID:" + id + " 服务调用耗时(秒):" + seconds;
    }

    /**
     * 兜底函数
     */
    public String hystrixTimeoutHandler(Integer id) {
        return "服务访问线程池:" + Thread.currentThread().getName() + " ID:" + id + " 系统繁忙或运行报错,请稍后再试";
    }

    /**
     * 服务异常
     * @return
     */
    /**
     * HystrixCommand 启用注解
     */
    @HystrixCommand(fallbackMethod = "errorHandler")
    @Override
    public String error() {
        int a = 1 / 0;
        return null;
    }

    /**
     * 兜底函数
     */
    public String errorHandler() {
        return "服务访问线程池:" + Thread.currentThread().getName() + " 系统繁忙或运行报错,请稍后再试";
    }


    /**
     * 服务熔断
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//60%失败率后触发
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("#####id不能为负数");
        }
        String serialNumber = IdUtil.fastSimpleUUID();
        return Thread.currentThread().getName() + "     服务正常: 流水号" + serialNumber;
    }
    public String paymentCircuitBreakerHandler(Integer id){
        return "id不能为负数,请稍后再试 id:"+id;
    }

}
