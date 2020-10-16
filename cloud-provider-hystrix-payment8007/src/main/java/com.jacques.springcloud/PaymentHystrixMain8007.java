package com.jacques.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 开启断路器
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(value = "com.jacques.springcloud.dao")
@SpringBootApplication
/**
 * @author Jacques·Fry
 * @version 1.0
 * @info springboot启动类
 * @note 文件说明
 * @date 2020/10/14 22:01
 */
public class PaymentHystrixMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8007.class);
    }

    /**
     * 此配置是为了服务监控而配置,与服务本身无关,springcloud升级后的ken
     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     * 只要在项目加上下面的servlet即可
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
