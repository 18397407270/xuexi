package com.hzh.day_06;
//判断接口
import java.util.function.Predicate;

public class Lambda_predicate {
    public static void main(String[] args) {
        String s = "hzh";
        //判断字符串长度
        boolean b = CheckString(s, s1 -> s1.length() > 5);
        System.out.println(b);

    }
    public static boolean CheckString(String s, Predicate<String> predicate){
         return predicate.test(s);
    }
}
