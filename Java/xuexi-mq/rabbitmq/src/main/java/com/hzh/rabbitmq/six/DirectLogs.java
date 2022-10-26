package com.hzh.rabbitmq.six;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DirectLogs {

    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String b = scanner.next();

            if (b.equals("info")){
                channel.basicPublish(EXCHANGE_NAME,"info", MessageProperties.PERSISTENT_TEXT_PLAIN,b.getBytes(StandardCharsets.UTF_8));
            }
            else {
                channel.basicPublish(EXCHANGE_NAME,"error", MessageProperties.PERSISTENT_TEXT_PLAIN,b.getBytes(StandardCharsets.UTF_8));
            }

            System.out.println("生产者发出消息: "+b);

        }
    }
}
