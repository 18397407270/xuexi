package com.hzh.rabbitmq.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

public class Produce {

    //队列名称
    public static final String QUEUE_NAME = "hello";

    //发消息
    public static void main(String[] args) {

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //工厂Ip 连接MQ
        factory.setHost("81.68.239.244");

        factory.setUsername("hzh");

        factory.setPassword("Hengde123");


        try {
            //创建连接
            Connection connection = factory.newConnection();

            //创建信道
            Channel channel = connection.createChannel();

            /**
             * 生成队列
             * 1.队列名称
             * 2.队列里面的消息是否持久化(磁盘),默认存在内存中
             * 3.该队列是否只供一个消费者消费,是否进行消息共享,true可以多个消费者消费
             * 4.是否自动删除,当所有消费者都与这个队列断开连接时,这个队列是否自动删除
             * 5.其他参数
             */
            Map<String,Object> arg = new HashMap<>();
            arg.put("x-max-priority",10); //设置过大会浪费性能
            channel.queueDeclare(QUEUE_NAME,true,false,false,arg);

            for (int i = 0 ;i<100 ;i++){
                String msg = i+"";

                if (i == 5){
                    AMQP.BasicProperties p = new AMQP.BasicProperties().builder().priority(5).build();
                    channel.basicPublish("", QUEUE_NAME,p,msg.getBytes(StandardCharsets.UTF_8));
                }
                else {

                    channel.basicPublish("", QUEUE_NAME,null,msg.getBytes());
                }
            }
            System.out.println("消息发送完毕");



        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }

}
