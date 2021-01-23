package com.hzh.day_02;
/*
* 使用lambda表达式优化日志案例
* */

public class Domain_log_lam  {
    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "world";
        String msg3 = "yel";
        showLog(1,()-> {
            String s = msg1 + msg2 + msg3;
            return s;
        });
        /*
        * 使用lambda表达式时,把传递过去,如果等级不是1,就不会对字符串进行拼接返回
        * 等级是1才会执行
        * 性能则得到了优化
        * */

    }
    public static void showLog(int level,Messgelog log){
        if(level==1){
            System.out.println(log.buildMessge());
        }
    }
}
