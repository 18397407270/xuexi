package com.hzh.day_04;

import java.util.Arrays;
import java.util.Comparator;

/*
* 定义一个方法获取一个Comparetor接口类型作为返回值
*
* */
public class Lambda_Re_value {
    public static void main(String[] args) {
        String [] s = {"hzh234","hzh","hzh1","hzh23"};
        //排序前
        System.out.println(Arrays.toString(s));

        Arrays.sort(s,getComparator1());
        //排序后
        System.out.println(Arrays.toString(s));

    }
    //匿名内部类实现
    /*public static Comparator<String> getComparator(){
        return new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
    }*/
    //lambda表达式实现
    public static Comparator<String> getComparator1(){
        return (o1,o2)->o1.length()-o2.length();
    }

}
