package com.hzh.Person;

public class ReflectDeom1 {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
        * 不管哪一种获取的class对象都是一样的
        * */
        //获取方式一:Class.forname("全类名")
       /* Class aClass = Class.forName("com.hzh.Person.Person");
        System.out.println(aClass);

        //获取方式二:类名.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //获取方式三:对象.getClass()
        Person p = new Person();
        Class aClass1 = p.getClass();
        System.out.println(aClass1);*/

        //直接获取类名
        String name = ReflectDeom1.class.getSimpleName();
        System.out.println(name);


    }
}
