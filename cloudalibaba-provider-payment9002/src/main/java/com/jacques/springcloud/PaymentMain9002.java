package com.jacques.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info springboot启动类
 * @date 2020/10/14 22:01
 */
@EnableDiscoveryClient
@MapperScan(value = "com.jacques.springcloud.dao")
@SpringBootApplication
public class PaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class);
    }
}
