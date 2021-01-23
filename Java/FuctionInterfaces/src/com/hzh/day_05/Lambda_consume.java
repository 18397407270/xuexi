package com.hzh.day_05;
//消费数据
import java.util.function.Consumer;

public class Lambda_consume {
    public static void main(String[] args) {

        ConsumeString("苍老师",(name)-> {
            //消费方式一
            //System.out.println(name);
            //消费方式二
            String rename = new StringBuffer(name).reverse().toString();
            System.out.println(rename);
        });

    }
    public static void ConsumeString(String s, Consumer<String> co){
       co.accept(s);
    }
}
