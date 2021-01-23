package com.hzh.annotate;

/*
* 注解三: @SuppressWarnings("all")
* 压制所有警告
* */
@SuppressWarnings("all")
public class Annotate {
    public static void main(String[] args) {

    }
    /*
    *
    * 注解一: @Override
    * 检测继承父类方法是否重写
    * */

    @Override
    public String toString() {
        return super.toString();
    }

    /*
    * 注解二:@Deprecated
    * 标记方法已经过时
    * */

    @Deprecated
    public void method1(){
        //有缺陷,已经过时

    }

    public void method2(){
        //新的替代方案

    }

    public void Demo(){
        method1();//选择这个方法的时候显示这个方法已经过时
        method2();
    }
}
