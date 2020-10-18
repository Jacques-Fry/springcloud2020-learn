package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info nacos配置客户端
 * @date 2020/10/18 16:20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class);
    }
}
