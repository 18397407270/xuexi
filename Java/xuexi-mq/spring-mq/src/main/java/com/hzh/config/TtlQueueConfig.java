package com.hzh.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TtlQueueConfig {

    //普通交换机的名称

    private static final String X_EXCHANGE = "X";

    //死信交换机的名称
    private static final String Y_DEAD_EXCHANGE = "Y";

    //普通队列
    public static final String A_QUEUE = "QA";
    public static final String B_QUEUE = "QB";

    public static final String C_QUEUE = "QC";

    //死信队列
    public static final String D_QUEUE = "QD";

    @Bean("xExchange")
    public DirectExchange xExchange(){
        return new DirectExchange(X_EXCHANGE);
    }


    @Bean("yExchange")
    public DirectExchange yExchange(){
        return new DirectExchange(Y_DEAD_EXCHANGE);
    }

    @Bean("queueA")
    public Queue queueA(){
        Map<String,Object> map = new HashMap<>(3);
        map.put("x-dead-letter-exchange",Y_DEAD_EXCHANGE);
        map.put("x-dead-letter-routing-key","YD");
        map.put("x-message-ttl",10000);
        return QueueBuilder.durable(A_QUEUE).withArguments(map).build();
    }


    @Bean("queueB")
    public Queue queueB(){
        Map<String,Object> map = new HashMap<>(3);
        map.put("x-dead-letter-exchange",Y_DEAD_EXCHANGE);
        map.put("x-dead-letter-routing-key","YD");
        map.put("x-message-ttl",40000);
        return QueueBuilder.durable(B_QUEUE).withArguments(map).build();
    }

    @Bean("queueC")
    public Queue queueC(){
        Map<String,Object> map = new HashMap<>(3);
        map.put("x-dead-letter-exchange",Y_DEAD_EXCHANGE);
        map.put("x-dead-letter-routing-key","YD");
        return QueueBuilder.durable(C_QUEUE).withArguments(map).build();
    }


    @Bean("queueD")
    public Queue queueD(){
        return QueueBuilder.durable(D_QUEUE).build();
    }

    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }

    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    @Bean
    public Binding queueCBindingX(@Qualifier("queueC") Queue queueC,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueC).to(xExchange).with("XC");
    }

    @Bean
    public Binding queueDBindingY(@Qualifier("queueD") Queue queueD,@Qualifier("yExchange") DirectExchange yExchange){
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }


}
