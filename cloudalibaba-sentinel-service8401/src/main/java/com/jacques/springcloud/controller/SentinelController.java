package com.jacques.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jacques.springcloud.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @date 2020/10/18 20:42
 */
@Api(tags = "sentinel的简单使用")
@Slf4j
@RestController
public class SentinelController {

    @GetMapping("/a")
    public String a(){
        String serial=IdUtil.randomUUID();
        log.info("访问了a 流水号:{}",serial);
        return Thread.currentThread().getName()+"  /a  流水号:"+serial;
    }

    @GetMapping("/b")
    public String b(){
        String serial=IdUtil.randomUUID();
        log.info("访问了b 流水号:{}",serial);
        return Thread.currentThread().getName()+"  /b  流水号:"+serial;
    }

    @ApiOperation("超时测试")
    @GetMapping("testTimeOut")
    public String testTimeOut(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        String serial=IdUtil.randomUUID();
        log.info("访问了testTimeOut 流水号:{}",serial);
        return Thread.currentThread().getName()+"  /testTimeOut  流水号:"+serial;
    }

    @ApiOperation("错误数测试")
    @GetMapping("testErrorCount")
    public String testErrorCount(){
        int i=1/0;
        String serial=IdUtil.randomUUID();
        log.info("访问了testErrorCount 流水号:{}",serial);
        return Thread.currentThread().getName()+"  /testErrorCount  流水号:"+serial;
    }

    @ApiOperation("错误率测试")
    @GetMapping("testErrorPercentage")
    public String testErrorPercentage(){
        int i=1/0;
        String serial=IdUtil.randomUUID();
        log.info("访问了testErrorPercentage 流水号:{}",serial);
        return Thread.currentThread().getName()+"  /testErrorPercentage  流水号:"+serial;
    }


    @ApiOperation("热点规则")
    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "error_testHotKey")
    public  Result<String> testHotKey(String token){
        String serial=IdUtil.randomUUID();
        log.info("访问了testHotKey 流水号:{}",serial);
        return new Result<>(200,Thread.currentThread().getName()+"  /testHotKey  流水号:"+serial);
    }

    /**
     * 兜底函数
     * @return
     */
    public Result<String> error_testHotKey(String token, BlockException exception){
        return new Result<>(5000,token+ " error_testHotKey 访问过于频繁");
    }
}
