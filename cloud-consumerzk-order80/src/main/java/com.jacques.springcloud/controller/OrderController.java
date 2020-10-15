package com.jacques.springcloud.controller;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/14 23:18
 */
@Api(tags = "订单模块")
@RequestMapping("/order")
@RestController
public class OrderController {

    //单机版
    //public static final String PAYMENT_URL="http://127.0.0.1:8001";
    /**
     * 集群版
     */
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("添加支付信息")
    @PostMapping("/addPayment")
    public Result<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,Result.class);
    }

    @ApiOperation("查询支付信息")
    @PostMapping("/getPayment/{id}")
    public Result<Payment> add(@PathVariable long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,Result.class);
    }
}
