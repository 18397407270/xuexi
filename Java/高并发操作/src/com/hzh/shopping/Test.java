package com.hzh.shopping;

/*
* 测试类
* */
public class Test {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        //十个生产者

        ProcedureRunnable runnable1 = new ProcedureRunnable(factory);

        for (int i = 0; i < 10; i++) {
            new Thread(runnable1,"生产者"+i).start();
        }

        //二十个消费者

        ConsumerRunnable runnable2 = new ConsumerRunnable(factory);

        for (int i = 0; i < 20; i++) {
            new Thread(runnable2,"消费者"+i).start();
        }


    }
}
