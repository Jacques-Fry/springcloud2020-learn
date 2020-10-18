package com.jacques.springcloud.controller;

import com.jacques.springcloud.service.IMessageProvider;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 消息发送
 * @date 2020/10/18 13:43
 */
@Api(tags = "消息发送")
@RestController
public class MessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/msg/send")
    public String send(){
        iMessageProvider.sendMsg();
        return "执行成功";
    }
}
