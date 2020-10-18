package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/14 23:16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain90.class);
    }
}
