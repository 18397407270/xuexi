package com.hzh.lock2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能：多个读操作可以同时进行，读写操作、写写操作互斥的
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        Operator operator = new Operator();
        //创建5个读线程并启动
        Runnable runnable1 =new Runnable() {
            @Override
            public void run() {
                //while(true){
                operator.read();
                //}
            }
        };


        //创建5个写线程并启动
        Runnable runnable2 =new Runnable() {
            @Override
            public void run() {
                //while(true){
                operator.write();
                //}
            }
        };
        for (int i = 0; i <10 ; i++) {
            new Thread(runnable1,"读线程"+i).start();
        }
        for (int i = 0; i <10; i++) {
            new Thread(runnable2,"写线程"+i).start();
        }
    }
}

class Operator{

    //private Lock lock = new ReentrantLock();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void read(){
        //lock.lock();
        rwl.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"读数据开始");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读数据结束");
        }finally {
            //lock.unlock();
            rwl.readLock().unlock();
        }

    }

    public void write(){
        //lock.lock();
        rwl.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写数据开始");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写数据结束");
        }finally {
            //lock.unlock();
            rwl.writeLock().unlock();
        }
    }
}
