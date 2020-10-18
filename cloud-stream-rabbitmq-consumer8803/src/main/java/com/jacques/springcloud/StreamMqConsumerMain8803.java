package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jacques·Fry
 * @info stream消息消费者
 * @version 1.0
 * @date 2020/10/18 14:00
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMqConsumerMain8803 {

    public static void main(String[] args) {

        SpringApplication.run(StreamMqConsumerMain8803.class,args);
    }

}
