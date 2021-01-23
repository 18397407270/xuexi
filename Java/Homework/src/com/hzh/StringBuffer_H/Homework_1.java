package com.hzh.StringBuffer_H;
/*
1.对字符串进行分割
2.找出a所在的所有索引
3.大写转小写
4.小写转大写
6，统计字符串的长度
7，把字符串前后的空格去掉
8，把字符串中所有空格去掉
9，找出最后一个R所在的索引
* */

import java.util.LinkedList;

public class Homework_1 {
    private static void Split(String s){
        String[] split = s.split(",");
        for (String s1:split) {
            System.out.println(s1);
        }
    }
    private static void Getindex(String s1){
        LinkedList link = new LinkedList();
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)=='a'){
                link.add(i);
            }
        }
        System.out.println(link);
    }
    private static void UpString(String s2){
        String s = s2.toUpperCase();
        System.out.println(s);
    }
    private static void LowString(String s2){
        String s = s2.toLowerCase();
        System.out.println(s);
    }
    public static void main(String[] args) {
        String s="  ac,42,123,sdFa  ,cdf,4,adf,5ewRRre   ";
        //分割作业
        Split(s);
        //得到下标作业
        Getindex(s);
        //大写转小写作业
        UpString(s);
        //小写转大写作业
        LowString(s);
        //统计字符串的长度
        GetLen(s);
        //把字符串前后的空格去掉
        De_block(s);
        //去除所有空格
        De_all_block(s);
        //找到最后一个R所在的索引
        Find_index(s);
    }

    private static void Find_index(String s) {
        int r = s.lastIndexOf("R");
        System.out.println(r);
    }

    private static void De_all_block(String s) {
        String strip = s.strip();
        System.out.println(strip);
    }

    private static void De_block(String s) {
        //去除前面的空格
        String s1 = s.stripLeading();
        //去除后面的空格
        String s2 = s1.stripTrailing();
        System.out.println(s2);

    }

    private static void GetLen(String s) {
        System.out.println(s.length());
    }
}
