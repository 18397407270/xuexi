package com.hzh.example1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(getClassName = "com.hzh.example1.Demo1",getMethodName = "show")
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.获取类字节码
        Class<Test> testClass = Test.class;
        //2.获取注释对象
        Pro annotation = testClass.getAnnotation(Pro.class);
        String className = annotation.getClassName();
        String methodName = annotation.getMethodName();
        System.out.println(className);
        System.out.println(methodName);

        //3.
        //把类加载到内存
        Class aClass = Class.forName(className);

        //生成对象
        Object o = aClass.newInstance();

        //生成对象方法
        Method methods = aClass.getMethod(methodName);

        //调用方法
        methods.invoke(o);
    }
}
