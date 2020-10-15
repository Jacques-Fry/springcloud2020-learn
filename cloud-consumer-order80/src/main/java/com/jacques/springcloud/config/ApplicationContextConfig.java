package com.jacques.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @date 2020/10/14 23:23
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 开启轮询均衡负载
     */
    //@LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
