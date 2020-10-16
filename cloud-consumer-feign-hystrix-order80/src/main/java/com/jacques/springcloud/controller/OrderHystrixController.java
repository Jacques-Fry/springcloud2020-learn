package com.jacques.springcloud.controller;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import com.jacques.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "订单模块")
@RequestMapping("/order")
@RestController
@Slf4j
/**
 * 全局Fullback
 */
@DefaultProperties(defaultFallback = "orderGlobalFullbackMethod")
/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/14 23:18
 */
public class OrderHystrixController {

    @Resource
    private PaymentService paymentService;

    @ApiOperation("添加支付信息")
    @PostMapping("/addPayment")
    public Result<Payment> add(@RequestBody Payment payment) {
        return paymentService.add(payment);
    }

    @ApiOperation("查询支付信息")
    @GetMapping("/getPayment/{id}")
    public Result<Payment> get(@PathVariable long id) {
        return paymentService.get(id);
    }


    /**
     * 模拟hystrix超时
     */
    @ApiOperation("模拟hystrix超时")
    @GetMapping("/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "hystrixTimeOutHandler",commandProperties = {
            /**
             * 1.5秒服务超时
             */
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public Result<String> hystrixTimeOut(@PathVariable("id") Integer id) {
        return paymentService.hystrixTimeOut(id);
    }
    public Result<String> hystrixTimeOutHandler(@PathVariable("id")Integer id){
        return new Result<>(5000,"消费端80服务访问超时,对方服务系统繁忙或系统出错,请稍后再试");
    }

    /**
     * 模拟服务错误
     */
    @HystrixCommand
    @ApiOperation("模拟服务错误")
    @GetMapping("/error")
    public Result<String> error(){
        return paymentService.error();
    }

    /**
     * 全局fullback函数
     * @return
     */
    public Result<String> orderGlobalFullbackMethod(){
        return new Result<>(5000,"Global异常处理信息: 服务繁忙或系统错误,请稍后重试");
    }
}
