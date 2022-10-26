package com.hzh.rabbitmq.seven;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TopicLogs {

    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String b = scanner.next();

            channel.basicPublish(EXCHANGE_NAME,"v.orange.c", MessageProperties.PERSISTENT_TEXT_PLAIN,b.getBytes(StandardCharsets.UTF_8));

            System.out.println("生产者发出消息: "+b);

        }

    }
}
