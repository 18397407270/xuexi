package com.hzh.rabbitmq.six;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * direct交换机
 */
public class ReceiveLogsDirectOne {

    public static final String EXCHANGE_NAME = "direct_logs";
    
    public static final String QUEUE_NAME = "console";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        //声明一个临时队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");

        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");

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
