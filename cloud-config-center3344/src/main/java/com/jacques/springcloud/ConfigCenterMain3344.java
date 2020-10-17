package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info config配置中心
 * @date 2020/10/17 22:59
 */

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class);
    }
}
