package com.jacques.springcloud.comtroller;

import com.jacques.springcloud.entity.Payment;
import com.jacques.springcloud.entity.Result;
import com.jacques.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 文件信息
 * @note 文件说明
 * @date 2020/10/14 22:38
 */
@Api(tags = "支付模块")
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    @ApiOperation("新增")
    @PostMapping("/payment/add")
    public Result<Payment> add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("插入结果:{}",result);
        if (result > 0) {
            return new Result<>(200, "插入成功,服务端口: "+serverPort, payment);
        } else {
            return new Result<>(5000, "插入失败,服务端口: "+serverPort, payment);
        }
    }

    @ApiOperation("修改")
    @PutMapping("/payment/upd")
    public Result<Payment> upd(@RequestBody Payment payment) {
        int result = paymentService.upd(payment);
        log.info("修改结果:{}",result);
        if (result > 0) {
            return new Result<>(200, "修改成功,服务端口: "+serverPort, payment);
        } else {
            return new Result<>(5000, "修改失败,服务端口: "+serverPort, payment);
        }
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/payment/del/{id}")
    public Result<Payment> del(@PathVariable long id) {
        int result = paymentService.del(id);
        log.info("删除结果:{}",result);
        if (result > 0) {
            return new Result<>(200, "删除成功,服务端口: "+serverPort);
        } else {
            return new Result<>(5000, "删除失败,服务端口: "+serverPort);
        }
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/payment/get/{id}")
    public Result<Payment> get(@PathVariable long id) {
        Payment result = paymentService.get(id);
        log.info("查询结果:{}",result);
        if (result != null) {
            return new Result<>(200, "查询成功,服务端口: "+serverPort, result);
        } else {
            return new Result<>(5000, "没有对应的记录,服务端口: "+serverPort, null);
        }
    }

    /**
     * 模拟feign超时
     */
    @ApiOperation("模拟feign超时")
    @GetMapping("/payment/feign/timeout")
    public String feignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
