package com.hzh.day_03;
/*
* lambda表达式作为参数使用
* */
public class Lambda_Runable {
    public static void main(String[] args) {
        Adjust_Runable(()-> System.out.println(Thread.currentThread().getName()+"正在运行"));
    }
    public static void Adjust_Runable(Runnable run){
        new Thread(run).start();
    }
}
