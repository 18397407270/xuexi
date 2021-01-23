package cn.hzh.Domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Compare_to1 {
    public static void main(String[] args) {
        List<Person> list = new LinkedList<>();
        Collections.addAll(list,new Person("黄志鸿",20),new Person("陈泽文",20),
                                          new Person("赵珅",21),new Person("肖木鹏",21));
        //初始状态
        System.out.println("===========初始状态============");
        System.out.println(list);
        //打乱顺序后
        System.out.println("===========打乱顺序后============");
        Collections.shuffle(list);
        System.out.println(list);
        //进行自定义排序后(按年龄排序)
        System.out.println("==========进行自定义排序后(按年龄排序)=======)");
        Collections.sort(list);
        System.out.println(list);

        List<Student> list1 = new LinkedList<>();
        Collections.addAll(list1,new Student("黄志鸿",23),new Student("陈泽文",20),
                new Student("a赵珅",21),new Student("肖木鹏",21));
        //初始状态
        System.out.println("===========初始状态============");
        System.out.println(list1);
        //打乱顺序后
        System.out.println("===========打乱顺序后============");
        Collections.shuffle(list1);
        System.out.println(list1);
        //进行自定义排序后(按年龄排序)
        System.out.println("==========进行自定义排序后(按年龄排序)=======)");

        //按照年龄升序排列
       /* Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getAge()-o2.getAge();
            }
        });*/
        Collections.sort(list1,(o1,o2)->o1.getAge()-o2.getAge());
        System.out.println("按照年龄升序排列");
        System.out.println(list1);

        //按照年龄降序排列
        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o2.getAge()-o1.getAge();
            }
        });
        System.out.println("按照年龄降序排列");
        System.out.println(list1);

        //按照姓名排序排列
        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getName().charAt(0)- o2.getName().charAt(0);
            }
        });
        System.out.println("按照姓名第一字排列");
        System.out.println(list1);
    }
}
