package com.jacques.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.jacques.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author Jacques·Fry
 * @version 1.0
 * @info 消息发送服务
 * @date 2020/10/18 13:33
 *
 * Source 定义消息的推送管道
 */
@Slf4j
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Autowired
    private MessageChannel output;

    @Value("${server.port}")
    public String port;
    /**
     * 发送消息
     */
    @Override
    public void sendMsg() {
        String msg="消息生产者: "+port+"  发送消息: "+IdUtil.randomUUID();
        output.send(MessageBuilder.withPayload(msg).build());
        log.info("消息已发送: {}",msg);
    }
}
