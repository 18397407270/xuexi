package cn.hzh.Stream;

import java.util.stream.Stream;

/*
* limit
* 截取方法
* 对流中元素进行截取,截取之后任然可以使用流中的方法
* */
public class Stream_limit {
    public static void main(String[] args) {
        Stream<String> stream= Stream.of("喜洋洋", "懒洋洋", "灰太狼", "红太狼", "小灰灰");
        /*
        * 只要前三个元素
        * */
        Stream<String> limit = stream.limit(3);
        limit.forEach(i -> System.out.println(i));
    }
}
