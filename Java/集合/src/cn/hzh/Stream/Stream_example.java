package cn.hzh.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Stream_example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("迪丽热巴");
        list.add("洪七公");
        list.add("胡歌");
        list.add("黄蓉");
        list.add("郭靖");

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("古力娜扎");
        list1.add("张无忌");
        list1.add("张三丰");
        list1.add("苍老师");
        list1.add("小昭");
        list1.add("赵敏");

        /*
        * 第一支队伍取名字为三个字符的前三个
        * */
        Stream<String> stream = list.stream();
        Stream<String> stringStream = stream.filter(name -> name.length() == 3).limit(3);

        /*
        * 第二支队伍只需要名字为张的人且跳过钱两个人
        *
        * */
        Stream<String> stream1 = list1.stream();
        Stream<String> stream2 = stream1.filter(name -> name.startsWith("张")).skip(2);

        /*
        * 合并筛选后的两个流,储存到一个新集合
        * 根据姓名创建Person对象,存储到一个新集合
        * 打印整个队伍的person对象信息
        * */
       Stream.concat(stringStream, stream2).map(name -> new Person(name)).forEach(name -> System.out.println(name));




    }
}
