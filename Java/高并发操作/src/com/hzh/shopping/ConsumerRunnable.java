package com.hzh.shopping;

/*
* 消费者
* */
public class ConsumerRunnable implements Runnable{
    private ProductFactory factory;

    public ConsumerRunnable() {

    }

    public ConsumerRunnable(ProductFactory factory) {
        this.factory = factory;
    }

    public ProductFactory getFactory() {
        return factory;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

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
}
