package com.hzh.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置  发布_确认
 */
@Configuration
public class ConfirmConfig {


    public static final String EXCHANGE_NAME = "confirm.exchange";
    public static final String EXCHANGE_NAME_BACK = "back.confirm.exchange";
    public static final String QUEUE_NAME = "confirm.queue";
    public static final String QUEUE_NAME_BACK = "back.confirm.queue";
    public static final String QUEUE_NAME_WARN= "warn.confirm.queue";
    public static final String ROUTING_KEY_NAME = "confirm.queue";

    @Bean("warnConfirmQueue")
    public Queue warnConfirmQueue(){
        return QueueBuilder.durable(QUEUE_NAME_WARN).build();
    }

    @Bean("backConfirmQueue")
    public Queue backConfirmQueue(){
        return QueueBuilder.durable(QUEUE_NAME_BACK).build();
    }

    @Bean("confirmQueue")
    public Queue confirmQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**
     * 备份交换机的优先级高于实现回退机制的监听方式
     * @return
     */
    @Bean("confirmExchange")
    public DirectExchange confirmExchange(){
        return ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).withArgument("alternate-exchange",EXCHANGE_NAME_BACK).build();
    }

    @Bean("backConfirmExchange")
    public FanoutExchange backConfirmExchange(){
        return new FanoutExchange(EXCHANGE_NAME_BACK);
    }

    @Bean
    public Binding queueBindingExchange(@Qualifier("confirmQueue") Queue confirmQueue,
                                        @Qualifier("confirmExchange") DirectExchange confirmExchange){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with(ROUTING_KEY_NAME);
    }

    @Bean
    public Binding queueBindingBackExchange(@Qualifier("backConfirmQueue") Queue confirmQueue,
                                        @Qualifier("backConfirmExchange") FanoutExchange confirmExchange){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange);
    }

    @Bean
    public Binding queueBindingWarnExchange(@Qualifier("warnConfirmQueue") Queue confirmQueue,
                                            @Qualifier("backConfirmExchange") FanoutExchange confirmExchange){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange);
    }

}
