package com.hzh.rabbitmq.four;

import com.hzh.rabbitmq.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 发布确认模式
 *
 * 1.单个确认
 * 2.批量确认
 * 3.异步批量确认
 *
 */
public class ConfirmMessage {

    //批量发消息的个数
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws Exception {


        //1.单个确认  远程服务器 30多秒
//        publishMessageIndividually();

        //2.批量确认  271ms
//        publishMessageBatch();

        //3.异步批量确认 37 ms
        publishMessageAsync();

    }

    //单个确认
    public static void publishMessageIndividually() throws Exception{

        Channel channel = RabbitMqUtils.getChannel();

        //队列声明

        String queueName = UUID.randomUUID().toString();

        channel.queueDeclare(queueName,true,false,false,null);

        //开启发布确认
        channel.confirmSelect();

        //开始时间
        long beginTime = System.currentTimeMillis();

        for (int i = 0 ; i < MESSAGE_COUNT ;i++){
            String message = i+"";
            channel.basicPublish("",queueName, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            boolean b = channel.waitForConfirms();
            if (b){
                System.out.println("消息发送成功");
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("发布"+MESSAGE_COUNT+"次消息,采用单个确认模式用时"+(endTime - beginTime) );


    }

    //批量确认
    public static void publishMessageBatch() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();

        //队列声明

        String queueName = UUID.randomUUID().toString();

        channel.queueDeclare(queueName,true,false,false,null);

        //开启发布确认
        channel.confirmSelect();


        int batchSize = 100;

        //开始时间
        long beginTime = System.currentTimeMillis();

        for (int i = 0 ; i < MESSAGE_COUNT ;i++){
            String message = i+"";
            channel.basicPublish("",queueName,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            if (i % batchSize==0){
                boolean b = channel.waitForConfirms();
                if (b){
                    System.out.println("消息发送成功");
                }
            }

        }

        long endTime = System.currentTimeMillis();

        System.out.println("发布"+MESSAGE_COUNT+"次消息,采用批量确认模式用时"+(endTime - beginTime) );


    }

    //异步确认
    public static void publishMessageAsync() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();

        //有序hash  并发的线程越多，ConcurrentSkipListMap越能体现出他的优势
        ConcurrentSkipListMap<Long,String> concurrentSkipListMap = new ConcurrentSkipListMap<>();

        //队列声明

        String queueName = UUID.randomUUID().toString();

        channel.queueDeclare(queueName,true,false,false,null);

        //开启发布确认
        channel.confirmSelect();


        //消息确认成功
        ConfirmCallback ackCallback = ((a,b) ->{
            System.out.println("确认消息"+a);
            //如果是批量
            if (b){
                ConcurrentNavigableMap<Long, String> confirmed = concurrentSkipListMap.headMap(a);
            }
            //如果是单条
            else{
                concurrentSkipListMap.remove(a);
            }
        });

        //消息确认失败
        ConfirmCallback nackCallback = ((a,b) ->{
            String s = concurrentSkipListMap.get(a);

            System.out.println("未确认消息 :"+s);

            System.out.println("标记为 :"+a);
        });


        //准备消息的监听器  监听哪些消息发送成功了 哪些消息发送失败了
        channel.addConfirmListener(ackCallback,nackCallback);




        //开始时间
        long beginTime = System.currentTimeMillis();

        for (int i = 0 ; i < MESSAGE_COUNT ;i++){
            String message = i+"";
            channel.basicPublish("",queueName,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            concurrentSkipListMap.put(channel.getNextPublishSeqNo(),message);

        }
        long endTime = System.currentTimeMillis();

        System.out.println("发布"+MESSAGE_COUNT+"次消息,采用异步确认模式用时"+(endTime - beginTime) );

    }

}
