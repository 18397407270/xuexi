package com.hzh.day_06;

import java.util.function.Function;

//接口用来根据一个数据的类型得到另外一个数据的类型
public class Lambda_function {
    public static void main(String[] args) {
        String s ="1234";
        Chage(s,(s1)->{
            return Integer.parseInt(s1);
        });
    }
    public static void Chage(String s, Function<String,Integer>fun) {
        Integer apply = fun.apply(s);
        System.out.println(apply);
    }

}
