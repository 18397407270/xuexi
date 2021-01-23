package com.hzh.day_06;
/*
* 将返回结果取反
*
* */
import java.util.function.Predicate;

public class Lambda_predicate3 {
    public static void main(String[] args) {
        String s = "abcdef";
        boolean a = CheckString(s, (s1) -> s1.length() > 5);
        System.out.println(a);
    }
    public static boolean CheckString(String s, Predicate<String> pre) {
        //取反
        return pre.negate().test(s);
    }
}
