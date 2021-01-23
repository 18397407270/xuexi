package com.hzh.map;

public class ListTest {
    public static void main(String[] args) {
        //创建线性顺序表
        List list = new ArrayList();
        //向末尾添加元素
        list.add("11111");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("33333");
        list.add("22222");
        list.add("11111");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("33333");
        list.add("22222");
        list.add("22222");
        list.add(null);
        list.add(3, "AAAAA");
        //进行各种操作验证添加
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.contains("44444"));
        System.out.println(list.indexOf("22222"));
        System.out.println(list.indexOf(null));//-1
        System.out.println(list.toString());
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String elem = it.next();
            System.out.println(elem);
        }
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}

