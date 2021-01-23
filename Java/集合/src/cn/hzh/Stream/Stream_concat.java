package cn.hzh.Stream;

import java.util.stream.Stream;

/*
* 合并两个流的方法
* */
public class Stream_concat {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("喜洋洋", "懒洋洋", "灰太狼", "红太狼", "小灰灰");
        Stream<String> stream1 = Stream.of("张三丰","张无忌","赵敏","小昭");
        Stream<String> concat = Stream.concat(stream, stream1);
        concat.forEach(s -> System.out.println(s));
    }
}
