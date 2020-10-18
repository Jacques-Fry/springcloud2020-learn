package com.jacques.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jacques.springcloud.entity.Result;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 自定义限流错误提醒
 * @date 2020/10/18 22:25
 */
public class CommonBlockHandlerException {

    public static Result<String> blockHandlerException(BlockException exception){
        return new Result<>(5000,"自定义错误提醒: 服务器繁忙,请稍后再试");
    }
}
