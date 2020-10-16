package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @date 2020/10/16 2:47
 */

/**
 * 开启服务降级
 */
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class);
    }
}

