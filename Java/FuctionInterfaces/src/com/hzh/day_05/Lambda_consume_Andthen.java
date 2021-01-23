package com.hzh.day_05;

import java.util.function.Consumer;

public class Lambda_consume_Andthen {
    public static void main(String[] args) {
        String name="Hello";
        Consume(name,(name1)-> System.out.println(name1.toUpperCase()),
                (name2)-> System.out.println(name2.toLowerCase())
                );
    }
    public static void Consume(String s,Consumer<String> co1,Consumer<String> co2){
     //消费方式一
    /* co1.accept(s);
     co2.accept(s);*/
     //消费方式二
     co1.andThen(co2).accept(s);
    }
}
