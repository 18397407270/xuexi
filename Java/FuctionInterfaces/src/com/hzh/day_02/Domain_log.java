package com.hzh.day_02;
/*
* 日志案例
* 存在性能浪费问题,当调用showlog方法是一个拼接的字符串
* 如果传递的level不是一级
* 则拼接的字符串也白费了
* */

public class Domain_log {
    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "world";
        String msg3 = "yel";
        showLog(1,msg1+msg2+msg3);

    }
    public static void showLog(int level,String message){
        if(level==1){
            System.out.println(message);
        }
    }
}
