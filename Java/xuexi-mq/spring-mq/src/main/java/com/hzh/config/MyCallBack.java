package com.hzh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        //注入
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 交换机确认回调方法
     * 1.发消息 交换机接收到了 回调
     * 2.发消息 交换机接收失败 回调
     *
     * @param correlationData 保存回调消息的ID以及相关信息
     * @param ack             交换机收到信息 true  || false
     * @param cause           失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("交换机");
        }
    }

    /**
     * 当消息传递过程中不可到达目的地的时候将消息返回给生产者
     *
     * @param message
     * @param rCode,
     * @param s
     * @param exchange
     * @param key
     */
    @Override
    public void returnedMessage(Message message, int rCode, String s, String exchange, String key) {
        log.error("消息 {},被交换机{}退回,退回原因: {},路由Key: {}", new java.lang.String(message.getBody()), exchange, s, key);
    }

}
