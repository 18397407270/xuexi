package cn.hzh.Stream;

import java.util.*;
import java.util.stream.Stream;
/*
* 集合转为Stream的方式
* */
public class Stream_imp {
    public static void main(String[] args) {
        //1.将List集合转为Straem流
        List<String> list = new ArrayList<String>();
        Stream<String> stream = list.stream();

        //2.将set集合转为Straem流
        Set<String> set = new HashSet<String>();
        Stream<String> stream1 = set.stream();

        //3.将map集合转为Stream流
        Map<String,String> map = new HashMap<String,String>();
        //3.1获取键
        Set<String> keyset = map.keySet();
        Stream<String> stream2 = keyset.stream();

        //3.2获取值
        Collection<String> values = map.values();;
        Stream<String> stream3 = values.stream();

        //3.3获取键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();

        //将数组转为Stream流
        Stream<Integer> Stream4 = Stream.of(1,2,3,4,5);

        //可变参数可以传递数组
        Integer [] arr = {1,2,3,4,5};
        Stream<Integer> Stream5 = Stream.of(arr);
        
        String [] arr1 = {"1","2","3","4","5"};
        Stream<String> Stream6 = Stream.of(arr1);


    }
}
