package com.hzh.rabbitmq.eight;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Produce {

    public static final String EXCHANGE_NAME_NORMAL = "normal_exchange";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().expiration("10000").build();

        for (int i = 0; i < 10; i++) {
            String message = i + "" ;
            channel.basicPublish(EXCHANGE_NAME_NORMAL,"zhangsan",basicProperties,message.getBytes(StandardCharsets.UTF_8));
        }

    }
}
