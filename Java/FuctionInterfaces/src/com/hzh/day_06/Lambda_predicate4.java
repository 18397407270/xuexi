package com.hzh.day_06;
/*
* 用arraylist集合存储性别为女,姓名至少四位的人
*
* */
import java.util.ArrayList;
import java.util.function.Predicate;

public class Lambda_predicate4 {
    public static void main(String[] args) {
        String[] s ={"迪丽热巴,女","古力娜扎,女","胡歌,男"};
        //解法一
        /*ArrayList<String> list=new ArrayList<String>();
        for(String s1:s){
            boolean b = CheckString(s1, (s2) -> {
                String[] split = s2.split(",");
                return split[0].length() >= 4;
            }, (s3) -> {
                String[] split = s3.split(",");
                return split[1].equals("女") ;
            });
            if(b){
                list.add(s1);
            }
        }
        for (String s1:list
             ) {
            System.out.println(s1);
        }*/
        //解法二
        ArrayList<String> female = CheckString(s, (s2) -> {
            String[] split = s2.split(",");
            return split[0].length() >= 4;
        }, (s3) -> {
            String[] split = s3.split(",");
            return split[1].equals("女");
        });

        for (String s1:female
             ) {
            System.out.println(s1);
        }

    }
    public static ArrayList<String> CheckString(/*String s*/ String[]  s, Predicate<String> pre,Predicate<String> pre1) {
        //写法一
       /* return pre.and(pre1).test(s);*/
        //return pre.test(s)&& pre1.test(s);

        //写法二
        ArrayList<String> list = new ArrayList<String>();
        for (String s1: s
             ) {
            boolean b= pre.and(pre1).test(s1);
            if (b){
                list.add(s1);
            }
        }
        return list;

    }
}
