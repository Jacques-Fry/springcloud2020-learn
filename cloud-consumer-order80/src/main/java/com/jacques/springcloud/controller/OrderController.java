package com.jacques.springcloud.controller;

import com.jacques.springcloud.entity.Result;
import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.lb.LoadBalancer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    //单机版
    //public static final String PAYMENT_URL="http://127.0.0.1:8001";
    /**
     * 集群版
     */
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("添加支付信息")
    @PostMapping("/addPayment")
    public Result<Payment> add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,Result.class);
    }

    @ApiOperation("查询支付信息")
    @PostMapping("/getPayment/{id}")
    public Result<Payment> get(@PathVariable long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,Result.class);
    }

    @ApiOperation("自定义轮询算法 查询支付信息 getForEntity")
    @PostMapping("/getPayment/getForEntity/{id}")
    public Result<Payment> getForEntity(@PathVariable long id){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(null==instances||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.instance(instances);

        URI uri=serviceInstance.getUri();

        ResponseEntity<Result> forEntity = restTemplate.getForEntity(uri + "/payment/get/" + id, Result.class);
        log.info("响应状态码: {}",forEntity.getStatusCode());
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new Result<>(5000,"服务调用失败");
        }
    }


}
