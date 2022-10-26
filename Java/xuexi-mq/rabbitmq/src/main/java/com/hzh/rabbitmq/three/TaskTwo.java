package com.hzh.rabbitmq.three;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 消息在手动应答时,放回队列中重新消费
 */
public class TaskTwo {


    //队列名称
    public static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        //开启发布确认模式
        channel.confirmSelect();

        //队列持久化
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String message = scanner.next();

            //设置生产者发送消息为持久化消息(保存到磁盘上) PERSISTENT_TEXT_PLAIN
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes(StandardCharsets.UTF_8));

            System.out.println("生产者发送消息");

        }

    }

}
