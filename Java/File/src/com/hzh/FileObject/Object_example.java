package com.hzh.FileObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*
* 将多个类对象存储到集合当中,然后将其序列化,反序列化
*
* */
public class Object_example {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义集合储存数据
        List<Person> list = new ArrayList<>();
        list.add(new Person("李华",18));
        list.add(new Person("胡歌",31));
        list.add(new Person("黄晓明",35));
        list.add(new Person("刘亦菲",30));

        //2.序列化集合
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("People_Information2.txt"));
        output.writeObject(list);
        output.close();
        ObjectInput input = new ObjectInputStream(new FileInputStream("People_Information2.txt"));
        Object o = input.readObject();
        input.close();
        List<Person> list2 = null;
        if(o instanceof List){
            list2 = (List<Person>)o;
        }
        if(list2!=null){
            for (Person peoson:list2) {
                System.out.println("姓名:"+peoson.getName()+"----年龄:"+peoson.getAge());
            }
        }

    }
}
