package cn.hzh.Stream;

import java.util.stream.Stream;
/*
* 属于管道流,只能被消费一次
* 第一个Stream流调用完毕,就会跳转到下一个Stream流
* 所以第一个Stream就会关闭
* */

public class Stream_filter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰","张无忌","赵敏","小昭");
        Stream<String> stream1 = stream.filter((name) -> name.startsWith("张"));
        stream1.forEach(name-> System.out.println(name));

        /*
        此时这个Stream流已经使用过一次了,被关闭了
        stream.forEach((name) -> System.out.println(name));
        */

    }
}
