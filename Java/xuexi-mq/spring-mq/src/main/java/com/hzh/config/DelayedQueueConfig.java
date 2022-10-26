package com.hzh.config;

import com.rabbitmq.client.BuiltinExchangeType;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedQueueConfig {

    public static final String DELAYED_EXCHANGE = "delayed.exchange";
    public static final String DELAYED_QUEUE = "delayed.queue";
    public static final String DELAYED_ROUTING_KEY = "delayed.routingkey";


    /**
     * 队列
     * @return 结果
     */
    @Bean
    public Queue queueDelayed(){
        return new Queue(DELAYED_QUEUE);
    }

    /**
     * 绑定
     * @return 结果
     */
    @Bean
    public CustomExchange delayedExchange(){

        Map<String,Object> arguments = new HashMap<>();

        //不能直接用枚举,不然声明不了
        arguments.put("x-delayed-type", "direct");

        return new CustomExchange(DELAYED_EXCHANGE,"x-delayed-message",true,false,arguments);
    }

    @Bean
    public Binding bind(
            @Qualifier("queueDelayed") Queue queueDelayed,
            @Qualifier("delayedExchange") CustomExchange delayedExchange){
       return BindingBuilder.bind(queueDelayed).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }



}
