package com.hzh.consumer;

import com.hzh.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {


    @RabbitListener(queues = ConfirmConfig.QUEUE_NAME)
    public void receiveConfirmMessage(Message message){
        String s = new String(message.getBody());
        log.info("接收到队列 confirm.queue 消息: {}",s);
    }

}
