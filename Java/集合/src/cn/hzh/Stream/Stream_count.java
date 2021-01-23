package cn.hzh.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
* 统计元素个数
* count方法是一个终结方法
* 不能再调用流中的其他方法了--终结方法
* */
public class Stream_count {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream stream = list.stream();
        long count = stream.count();
        System.out.println(count);

       /*
       这个方法无法执行
       count是终结方法,一旦调用,则无法继续执行这个流中的方法
        stream.forEach(name -> System.out.println(name));
        */


    }
}
