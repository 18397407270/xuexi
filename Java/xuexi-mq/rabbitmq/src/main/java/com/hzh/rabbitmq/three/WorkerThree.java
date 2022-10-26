package com.hzh.rabbitmq.three;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WorkerThree {

    public static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) {

        Channel channel = RabbitMqUtils.getChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("接收消息");
            System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
            //手动应答
            /**
             * 消息的标记
             * 是否批量,false表示不批量应答信道的消息,true表示批量
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
        };

        //声明 接收消息
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println(consumerTag +" 消息消费被中断");
        };

        //接收消息
        try {
            System.out.println("C2等待接受消息....");
            //设置不公平分发
            channel.basicQos(1);
            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAME,autoAck,deliverCallback,cancelCallback);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
