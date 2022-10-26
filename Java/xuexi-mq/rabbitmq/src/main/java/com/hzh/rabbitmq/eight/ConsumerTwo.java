package com.hzh.rabbitmq.eight;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public class ConsumerTwo {

    public static final String QUEUE_NAME_DEAD = "dead-queue";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println("接收消息");
            System.out.println(new String(message.getBody()));
        };

        //声明 撤回消息
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println(consumerTag +" 消息消费被中断");
        };

        channel.basicConsume(QUEUE_NAME_DEAD,true,deliverCallback,cancelCallback);


    }
}
