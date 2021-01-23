package com.hzh.shopping1;

import java.util.LinkedList;

/*
* 商品工厂类
* */
public class ProductFactory {
    LinkedList<String> list = new LinkedList<>();
    int max = 10;

    public ProductFactory() {
    }

    public ProductFactory(int max) {
        this.max = max;
    }

    //存储商品

    public void SaveProduct(){

    }

    //生产商品
    public synchronized void ProduceProduct(String name){
        //生产到了上限,停止生产
        while (list.size()==max){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.add(name);
        System.out.println(Thread.currentThread().getName()+"生产了"+name+",当前商品总数"+list.size());

        //仓库满了,通知消费者消费
        if (list.size()==max){
            try {
                this.notifyAll();//唤醒所有的线程,唤醒一个的话会陷入等待状态,导致无法生产
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //消费商品

    public synchronized void ConsumeProduct(){
        //如果商品为空,则进行等待
        while (list.size()==0){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String name = list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费了"+name+",当前商品总数"+list.size());

        if (list.size()==0){
            this.notifyAll();
        }
    }




}
