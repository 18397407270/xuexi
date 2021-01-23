package cn.hzh.Stream;

import java.util.stream.Stream;

public class Stream_map {
    public static void main(String[] args) {
        /*
        * 映射
        * 通过function中apply方法将字符串类型转为Integer类型
        * */
        Stream<String> stream = Stream.of("1","2","3","4");
        Stream<Integer> integerStream = stream.map((s) -> Integer.parseInt(s));
        integerStream.forEach((s) -> System.out.println(s));

    }
}
