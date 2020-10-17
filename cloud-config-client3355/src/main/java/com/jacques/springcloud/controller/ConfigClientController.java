package com.jacques.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @date 2020/10/17 23:28
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
