package com.hzh.day_06;

import java.util.function.Function;

//把"123"->123,把转换后的结果加10,在转换回Integer
public class Lambda_function1 {
    public static void main(String[] args) {
        String s ="1234";
        Chage(s,(s1)->{
             return Integer.parseInt(s1)+10;
        },(i)->{
            return i+"";
        });

    }
    public static void Chage(String s, Function<String,Integer>fun,Function<Integer,String>fun1) {
        String apply = fun.andThen(fun1).apply(s);
        System.out.println(apply);
    }

}
