package com.hzh.controller;


import com.hzh.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/send")
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message){
        log.info("当前时间:{},发送一条信息给两个TTL队列:{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("X","XA",message);
        rabbitTemplate.convertAndSend("X","XB",message);
    }

    @GetMapping("/sendMsg/{message}/{time}")
    public void sendMsg(@PathVariable String message,@PathVariable String time){
        log.info("当前时间:{},发送一条信息给QC队列:{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("X","XC",message,message1 -> {
            //发送消息 如果第一个时间长,第二个短  这时候第二个要等第一个过期后才会执行  解决方案: 安装RabbitMQ的延迟插件
            message1.getMessageProperties().setExpiration(time);
            return message1;
        });
    }

    @GetMapping("/sendDelayedMsg/{message}/{time}")
    public void sendDelayedMsg(@PathVariable String message,@PathVariable String time){
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE,DelayedQueueConfig.DELAYED_ROUTING_KEY,message, message1 -> {
            //发送消息 如果第一个时间长,第二个短  这时候第二个要等第一个过期后才会执行  解决方案: 安装RabbitMQ的延迟插件
            message1.getMessageProperties().setExpiration(time);
            return message1;
        });
    }
}
