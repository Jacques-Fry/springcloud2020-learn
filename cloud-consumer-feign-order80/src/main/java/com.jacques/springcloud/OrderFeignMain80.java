package com.jacques.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/14 23:16
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
/**
 * 启用自定义负载均衡算法规则
 */
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = {MySelfRule.class})
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class);
    }
}
