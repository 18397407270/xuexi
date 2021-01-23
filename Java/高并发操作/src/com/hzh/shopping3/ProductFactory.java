package com.hzh.shopping3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/*
 * 商品工厂类
 * */
public class ProductFactory {
    /*
    * BlockingQueue,阻塞条件:队列满了或者队列空了
    * 容量一旦指定就不能改变
    * 先进先出
    * 线程安全
    *不能有null
    * put,take方法
    *
    * */
    //BlockingQueue<String> list = new ArrayBlockingQueue(10);
    BlockingQueue<String> list = new LinkedBlockingQueue(10);
    int max = 10;
    public ProductFactory() {
        this(10);
    }

    public ProductFactory(int max) {
        this.max = max;
        list = new LinkedBlockingQueue(max);
    }


    //生产商品
    public void ProduceProduct(String name) {

        try {
            list.put(name);
            System.out.println(Thread.currentThread().getName() + "生产了" + name + ",当前商品总数" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //消费商品

    public void ConsumeProduct() {

        String name = null;
        try {
            name = list.take();
            System.out.println(Thread.currentThread().getName() + "消费了" + name + ",当前商品总数" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
