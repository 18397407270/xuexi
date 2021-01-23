package com.hzh.StringBuffer_H;

import org.jetbrains.annotations.NotNull;

/*
 使用StringBuffer将一个数字字符串转换成逗号分隔的数字串,从右边每三个开始插入
**/
public class Homework_3 {
    public static void main(String[] args) {
        Integer a=12345678;
        Insert_string(a);
    }

    private static void Insert_string(@NotNull Integer a) {
        StringBuffer buf = new StringBuffer(a.toString());
        if(buf.length()>3){
            for(int i=buf.length()-3;i>=0;i-=3){
                buf = buf.insert(i, ',');
            }
        }
        System.out.println(buf);

    }

}
