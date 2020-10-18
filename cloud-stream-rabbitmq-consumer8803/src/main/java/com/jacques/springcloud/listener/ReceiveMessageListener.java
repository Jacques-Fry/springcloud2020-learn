package com.jacques.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 消息消费
 * @date 2020/10/18 14:03
 *
 * Sink 表明消费者
 */
@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    public String port;

    /**
     * Sink.INPUT输入源
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者 {} 接收到消息: {}",port,message.getPayload());
    }
}
