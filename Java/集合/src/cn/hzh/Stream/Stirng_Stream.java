package cn.hzh.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Stirng_Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张三丰");
        list.add("黄晓明");
        list.add("张良");


        list.stream().filter(name->name.length()==3)
                     .filter(name->name.startsWith("张"))
                     .forEach(name-> System.out.println(name));
        //遍历全部数据
        list.stream().forEach(name-> System.out.println(name));

    }
}
