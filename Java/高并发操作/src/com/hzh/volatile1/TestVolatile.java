package com.hzh.volatile1;

public class TestVolatile {

    /*
    * volatile synchronize final:可见性
    * synchronize:原子性
    * volatile synchronize：有序性(禁止指令重排)
    * */
    volatile static boolean flag = true;//不加volatile会导致flag的修改无法实时更新到内存
    public static void main(String[] args) {
        new Thread(()->{
            while (flag){
                //System.out.println("--------------");
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }
}
