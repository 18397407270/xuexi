package com.hzh.rabbitmq.five;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * 消息接受
 */
public class ReceiveLogs {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //声明一个临时队列
        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue,EXCHANGE_NAME,"");

        System.out.println("等待接受消息");

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println("接收消息");
            System.out.println(new String(message.getBody()));
        };

        //声明 撤回消息
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println(consumerTag +" 消息消费被中断");
        };


        channel.basicConsume(queue,true,deliverCallback,cancelCallback);


    }

}
