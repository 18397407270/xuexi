package com.hzh.shopping2;

/*
* 测试类
* */
public class Test {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory(30);
        //十个生产者
        Object o = new Object();
        final int[] i = {0};
        /*
        * lambda表达式简化操作
        * */
        for (int j = 0; j < 10; j++) {
            new Thread(()->{while (true){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //防止别的线程访问到相同的i
                synchronized (o){
                    factory.ProduceProduct("商品"+ i[0]);
                    i[0]++;
                }

            }},"生产者"+j).start();
        }

        //二十个消费者

        for (int j = 0; j < 20; j++) {
            new Thread(()->{while (true){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                factory.ConsumeProduct();
            }},"消费者"+j).start();
        }


    }
}
