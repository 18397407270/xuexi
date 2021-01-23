package cn.hzh.iterator1;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Iterator_2 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(2,"黄晓明");
        map.put(1,"胡歌");
        map.put(3,"成龙");
        //System.out.println(map);
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();

        //遍历方式一

        System.out.println("=============KeySet迭代器遍历=============");
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
        System.out.println("===========KeySet增强for遍历======================");
        //遍历方式二
        for (Integer ints: map.keySet()) {
            Integer i = ints;
            System.out.println(map.get(i));
        }


        //遍历方式三
        System.out.println("==========entrySet迭代器遍历===============");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();

        while (iterator1.hasNext()){
            Map.Entry<Integer, String> next = iterator1.next();
            Integer i = next.getKey();
            String s = next.getValue();
            System.out.println("key:"+i+"---value:"+s);
        }
        //遍历方式四
        System.out.println("================entrySet=====================");
        for (Map.Entry<Integer,String> next: entries) {
            Integer i = next.getKey();
            String s = next.getValue();
            System.out.println("key:"+i+"---value:"+s);
        }
    }
}
