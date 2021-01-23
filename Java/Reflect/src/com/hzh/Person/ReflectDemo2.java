package com.hzh.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        //获取字节码对象
        Class<Person> personClass = Person.class;

        /*
        * Field
        * */

        //获取所有Public成员变量
        Field[] fields = personClass.getFields();
        for (Field f:fields
             ) {
            System.out.println(f);
        }

        //获取指定的public 成员变量
        Field name = personClass.getField("name");

        //get与set用法
        Person p = new Person();
        Object o = name.get(p);
        System.out.println(o);

        name.set(p,"张三");
        System.out.println(p);

        //获取所有的成员变量,不管修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field de:declaredFields
             ) {
            System.out.println(de);
        }
        Field age = personClass.getDeclaredField("age");

        //暴力反射,忽略访问机制
        age.setAccessible(true);
        System.out.println(age);

        /*
        * Construct
        * */

        //获取所有构造器
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor co:constructors
             ) {
            System.out.println(co);
        }
        //获取指定构造器
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);
        //构造对象
        Person p1 = constructor.newInstance("张三", 18);
        System.out.println(p1);
        //使用空参构造

        //推荐使用这种
        Person person1 = personClass.getDeclaredConstructor().newInstance();
        System.out.println(person1);
       /*
        //已经过时
        Person person = personClass.newInstance();
        System.out.println(person);*/


        //Method
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method de:declaredMethods
             ) {
            System.out.println(de);
        }

    }
}
