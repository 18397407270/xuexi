package cn.hzh.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Iterator_1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("张三");
        coll.add("李四");
        coll.add("赵柳");
        coll.add("刘备");
        coll.add("关羽");


        Iterator iterator = coll.iterator();

        //输出形式一
        System.out.println("=============利用while循环输出=============");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //输出形式二
        System.out.println("==============利用for循环输出==================");
        for(Iterator<String> it = coll.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
        //输出形式三
        System.out.println("==============foreach输出=================");
        for (String s :coll
             ) {
            System.out.println(s);
        }


    }
}
