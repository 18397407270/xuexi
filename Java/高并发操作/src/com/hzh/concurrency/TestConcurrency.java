package com.hzh.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestConcurrency {
    public static void main(String[] args) {
        //第一代,同步方法锁线程安全,效率低下
        Vector vector = new Vector();

        //第二代
        List arrayList = new ArrayList();

        //通过此方法即可使线程安全
        arrayList = Collections.synchronizedList(arrayList);

        //第三代,继承了Lock锁

        //Segment<K,V> extends ReentrantLock
        ConcurrentHashMap chm;
        /*读数据不加锁
        * 对数据进行操作的时候会将原来的数组复制一份,原数组不加锁,复制的数组加锁,即读到的是原来的数据,正在操作的数据别的线程是无法读写的
        * 如果要求是实时数据,就不适合用此容器
        * 有序,,数据不具有唯一性
        * */
        CopyOnWriteArrayList coal;

        /*
        * 底层是CopyOnWriteArrayList
        * 无序,数据唯一性
        * */
        CopyOnWriteArraySet coas;
    }
}
