package com.hzh.shopping2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 商品工厂类
* */
public class ProductFactory {
    LinkedList<String> list = new LinkedList<>();
    int max = 10;

    Lock lock = new ReentrantLock();
    Condition Procedurecondition = lock.newCondition();
    Condition Consumercondition = lock.newCondition();


    public ProductFactory() {
    }

    public ProductFactory(int max) {
        this.max = max;
    }

    //存储商品

    public void SaveProduct(){

    }

    //生产商品
    public void ProduceProduct(String name){
        lock.lock();
        //生产到了上限,停止生产
        try {
            while (list.size()==max){
                try {
                    Procedurecondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            list.add(name);
            System.out.println(Thread.currentThread().getName()+"生产了"+name+",当前商品总数"+list.size());

            //仓库满了,通知消费者消费
            if (list.size()==max){
                try {
                    //通知一个消费者消费
                   Consumercondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }

    }

    //消费商品

    public void ConsumeProduct(){
        lock.lock();
        try{
            while (list.size()==0){
                try {
                    Consumercondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String name = list.remove(0);
            System.out.println(Thread.currentThread().getName()+"消费了"+name+",当前商品总数"+list.size());
            //如果商品为空,则进行等待
            if (list.size()==0){
                //通知所有生产者生产
               Procedurecondition.signalAll();
            }
        }finally {
            lock.unlock();
        }


    }




}
