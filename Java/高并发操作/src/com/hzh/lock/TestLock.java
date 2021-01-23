package com.hzh.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {
    public static void main(String[] args) {

        /*
        * 可重入锁:Lock(接口),ReadWriteLock(接口),synchronized是可重入锁
        * ReadLock:共享锁,WriteLock,ReentrantLock(实现类),synchronized:独占锁
        * 公平锁和非公平锁
        * */
        Lock lock = new Lock() {
            /*
            * Lock中六个方法
            * 前四个产生锁
            * 第五个解锁
            * 第六个产生一个等待队列
            * */

            //拿不到锁就一直等待,拿到就执行后续的代码
            @Override
            public void lock() {

            }

            //拿不到就一直等待,中途可以被其他线程中断
            @Override
            public void lockInterruptibly() throws InterruptedException {

            }

            //拿到锁就返回true,拿不到就返回false
            @Override
            public boolean tryLock() {
                return false;
            }

            //拿到锁就返回true,拿不到就尝试指定的时间时间到了之后仍然拿不到就返回true
            @Override
            public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public void unlock() {

            }

            @Override
            public Condition newCondition() {
                return null;
            }
        };

        ReadWriteLock writeLock = new ReentrantReadWriteLock();
        /*
        * lock1和lock2是同一把锁
        * */
        Lock lock1 = writeLock.readLock();
        Lock lock2 = writeLock.readLock();

        /*
        * lock3和lock4是同一把锁
        * */
        Lock lock3 = writeLock.writeLock();
        Lock lock4 = writeLock.writeLock();
    }
}
