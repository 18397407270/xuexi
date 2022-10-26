package com.hzh.rabbitmq.two;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;

public class TaskOne {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        Channel channel = RabbitMqUtils.getChannel();

        try {
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);

            //从控制台中接受信息

            for (int i = 0 ;i<100;i++){
                channel.basicPublish("",QUEUE_NAME,null,(String.valueOf(i)).getBytes());
                System.out.println("消息发送成功"+i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
