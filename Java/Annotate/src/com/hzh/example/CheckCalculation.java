package com.hzh.example;

/*
* 简单的测试框架
* 检测被检测的方法(加了@Check的方法)
*
*
* */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class CheckCalculation {
    public static void main(String[] args) throws IOException {
        //1.创建计算机对象
        Calculation c  = new Calculation();

        //2.获取字节码
        Class cla = c.getClass();

        //3.获取所有对象
        Method[] methods = cla.getMethods();

        int number=0;//出现异常的次数
        BufferedWriter buff = new BufferedWriter(new FileWriter("bug.txt"));
        //4.判断方法是否有注解
        for(Method method : methods){
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    number++;
                    buff.write(method.getName()+"出现了异常");
                    buff.newLine();
                    buff.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    buff.newLine();
                    buff.write("异常的原因"+e.getCause().getMessage());
                    buff.newLine();

                }

            }
        }

        buff.write("本次测试出现了"+number+"次异常");
        buff.flush();
        buff.close();


    }
}
