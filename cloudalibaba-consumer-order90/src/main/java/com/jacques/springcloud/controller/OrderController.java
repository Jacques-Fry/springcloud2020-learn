package com.jacques.springcloud.controller;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class OrderController {

    /**
     * 集群版
     */
    @Value("${server-url.nacos-payment-service}")
    public String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("添加支付信息")
    @PostMapping("/addPayment")
    public Result<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(serverURL +"/payment/add",payment,Result.class);
    }

    @ApiOperation("查询支付信息")
    @GetMapping("/getPayment/{id}")
    public Result<Payment> get(@PathVariable long id){
        return restTemplate.getForObject(serverURL +"/payment/get/"+id,Result.class);
    }


}
