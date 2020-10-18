package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 消息生产者
 * @date 2020/10/18 13:31
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMqProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqProviderMain8801.class);
    }
}
