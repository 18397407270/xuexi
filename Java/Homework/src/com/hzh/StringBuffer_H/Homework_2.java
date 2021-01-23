package com.hzh.StringBuffer_H;
/*
GDFADFADSFADSFDASnhsdaf!@$%@#45324rdsf"
统计字符串大写字母，小写字母，其它的个数
 */

public class Homework_2 {
    public static void main(String[] args) {
        String s="ADGDFADFADSFADSFDASnhsdaf!@$%@#45324rdsf";
        //计算各种字符的数量
        Count_string(s);
        //查找AD在s中出现的次数
        String s1="AD";
        Count_a_string(s,s1);
    }

    private static void Count_a_string(String s,String s1) {
        int count=0;
        while(s.lastIndexOf(s1)!=-1){
            count++;
            s = s.substring(0,s.lastIndexOf(s1));
        }
        System.out.println(s1+"在s出现的次数:"+count);

    }

    private static void Count_string(String s) {
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)>=65&&s.charAt(i)<=90){
                count++;
            }else if(s.charAt(i)>=97&&s.charAt(i)<=122){
                count1++;
            }else {
                count2++;
            }
        }
        System.out.println("大写字母的个数为:"+count);
        System.out.println("小写字母的个数为:"+count1);
        System.out.println("其它字符的个数:"+count2);
    }
}
