package cn.hzh.Stream;

import java.util.stream.Stream;

/*
* 跳过几个元素
* */
public class Stream_skip {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        Stream<String> skip = stringStream.skip(3);
        skip.forEach(s-> System.out.println(s));

    }
}
