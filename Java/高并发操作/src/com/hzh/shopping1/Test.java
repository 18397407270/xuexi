package com.hzh.shopping1;

import com.hzh.shopping.ConsumerRunnable;
import com.hzh.shopping.ProcedureRunnable;

/*
* 测试类
* */
public class Test {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory(30);
        //十个生产者

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    factory.ProduceProduct("商品"+i);
                    i++;
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable1,"生产者"+i).start();
        }

        //二十个消费者

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    factory.ConsumeProduct();
                }
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(runnable2,"消费者"+i).start();
        }


    }
}
