package com.jacques.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jacques.springcloud.entity.Result;
import com.jacques.springcloud.handler.CommonBlockHandlerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @date 2020/10/18 22:11
 */
@Api(tags = "SentinelResource详解")
@RestController
public class RateLimitController {

    @ApiOperation("限流测试")
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public Result<String> byResource(){
        return new Result<>(200,"限流测试ok "+ IdUtil.randomUUID() );
    }

    /**
     * 自定义错误提示
     * @return
     */
    public Result<String> handleException(BlockException exception){
        return new Result<>(5000,exception.getClass().getCanonicalName()+"   服务不可用");
    }

    @ApiOperation("按url限流测试")
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public Result<String> byUrl(){
        return new Result<>(200,"按url限流测试OK "+ IdUtil.randomUUID() );
    }

    @ApiOperation("自定义限流错误提醒")
    @GetMapping("/customErrorMsg")
    @SentinelResource(value = "customErrorMsg",blockHandlerClass = CommonBlockHandlerException.class,blockHandler = "blockHandlerException")
    public Result<String> customErrorMsg(){
        return new Result<>(200,"自定义限流错误提醒 "+ IdUtil.randomUUID() );
    }
}
