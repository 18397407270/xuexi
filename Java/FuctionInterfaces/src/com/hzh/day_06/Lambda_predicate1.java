package com.hzh.day_06;
/*
* 判断一个字符串是否长度大于5并且包含a
*
* */
import java.util.function.Predicate;

public class Lambda_predicate1 {
    public static void main(String[] args) {
        String s = "abcdef";
        boolean a = CheckString(s, (s1) -> s1.length() > 5, (s2) -> s2.contains("a"));
        System.out.println(a);
    }
    public static boolean CheckString(String s, Predicate<String> pre,Predicate<String> pre1) {

        //return pre.test(s)&& pre1.test(s);
        return pre.and(pre1).test(s);
    }
}
