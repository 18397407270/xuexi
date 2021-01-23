package com.hzh.map;

public class ListTest {
    public static void main(String[] args) {

        java.util.LinkedList linkedList;
        //创建线性顺序表
        List list = new LinkedList();
        //向末尾添加元素
        list.add("11111");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("33333");
        list.add("22222");
        list.add(3, "AAAAA");
        //进行各种操作验证添加
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
    }
}

