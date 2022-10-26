package com.hzh.rabbitmq.eight;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 死信队列
 *
 */
public class ConsumerOne {


    public static final String EXCHANGE_NAME_NORMAL = "normal_exchange";

    public static final String EXCHANGE_NAME_DEAD = "dead_exchange";

    public static final String QUEUE_NAME_DEAD = "dead-queue";

    public static final String QUEUE_NAME_NORMAL = "normal-queue";

    public static void main(String[] args) throws IOException {

        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME_NORMAL, BuiltinExchangeType.DIRECT);

        channel.exchangeDeclare(EXCHANGE_NAME_DEAD, BuiltinExchangeType.DIRECT);

        Map<String,Object> map = new HashMap<>();

        //过期时间 生产者与消费者都可以声明,一般在生产者声明
//        map.put("x-message-ttl",10000);
        //正常队列转死信队列
        map.put("x-dead-letter-exchange",EXCHANGE_NAME_DEAD);
        map.put("x-dead-letter-routing-key","lisi");
        //设置长度限制
        map.put("x-max-length",6);

        //正常队列
        channel.queueDeclare(QUEUE_NAME_NORMAL,false,false,false,map);
        //死信队列
        channel.queueDeclare(QUEUE_NAME_DEAD,false,false,false,null);


        //绑定 普通
        channel.queueBind(QUEUE_NAME_NORMAL,EXCHANGE_NAME_NORMAL,"zhangsan");
        //绑定 死信
        channel.queueBind(QUEUE_NAME_DEAD,EXCHANGE_NAME_DEAD,"lisi");


        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            String s = new String(message.getBody());
            if ("1".equals(s)){
                System.out.println("此消息被拒收");
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            }else {
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
                System.out.println(new String(message.getBody()));
            }
        };

        //声明 撤回消息
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println(consumerTag +" 消息消费被中断");
        };



        channel.basicConsume(QUEUE_NAME_NORMAL,true,deliverCallback,cancelCallback);
    }
}
