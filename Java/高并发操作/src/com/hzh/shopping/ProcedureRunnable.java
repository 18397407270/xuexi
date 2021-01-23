package com.hzh.shopping;

/*
* 生产者
* */
public class ProcedureRunnable implements Runnable{
    private ProductFactory factory;

    public ProcedureRunnable() {
    }

    public ProcedureRunnable(ProductFactory factory) {
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
        int i=0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            factory.ProduceProduct("商品"+i);
            i++;
        }
    }
}
