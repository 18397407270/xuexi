package com.hzh.rabbitmq.two;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public class WorkerOne {

    public static final String QUEUE_NAME = "hello";


    public static void main(String[] args) {

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

        //接收消息
        try {
            System.out.println("C3等待接受消息....");
            channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
