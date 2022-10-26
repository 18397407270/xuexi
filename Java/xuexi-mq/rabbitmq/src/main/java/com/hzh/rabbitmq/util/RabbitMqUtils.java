package com.hzh.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtils {

    public static Channel getChannel(){
        ConnectionFactory factory = new ConnectionFactory();

        //远端需要开放5672端口,否则会提示超时 用Windows版本的RabbitMQ 会经常丢失信息,切勿使用!!!

        factory.setHost("81.68.239.244");

        factory.setUsername("hzh");

        factory.setPassword("Hengde123");

        Connection connection = null;
        try {
            connection = factory.newConnection();
            return connection.createChannel();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
