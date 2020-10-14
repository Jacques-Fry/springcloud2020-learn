package com.jacques.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info springboot启动类
 * @note 文件说明
 * @date 2020/10/14 22:01
 */
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(value = "com.jacques.springcloud.dao")
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
