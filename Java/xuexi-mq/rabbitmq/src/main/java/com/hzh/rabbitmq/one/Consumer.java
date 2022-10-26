package com.hzh.rabbitmq.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();

        //工厂Ip 连接MQ
        factory.setHost("81.68.239.244");

        factory.setUsername("hzh");

        factory.setPassword("Hengde123");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            /**
             * 1.消费哪个队列
             * 2.消费成功后是否自动应答 true代表自动应答
             * 3.消费者未成功消费的一个回调
             * 4.消费者取消消费的回调
             *
             */

            //声明 接收消息
            DeliverCallback deliverCallback = (consumerTag,message) ->{
                System.out.println(new String(message.getBody()));
            };

            //声明 接收消息
            CancelCallback cancelCallback = consumerTag ->{
                System.out.println("消息消费被中断");
            };

            channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);


        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }

}
