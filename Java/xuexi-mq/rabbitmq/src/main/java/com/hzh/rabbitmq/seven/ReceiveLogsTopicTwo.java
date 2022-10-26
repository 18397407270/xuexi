package com.hzh.rabbitmq.seven;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * 主题模式
 */
public class ReceiveLogsTopicTwo {

    public static final String EXCHANGE_NAME = "topic_logs";

    public static final String QUEUE_NAME = "Q2";

    public static void main(String[] args) throws IOException {

        //1.创建通道
        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"*.*.rabbit");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"lazy.#");

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


        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);

    }

}
