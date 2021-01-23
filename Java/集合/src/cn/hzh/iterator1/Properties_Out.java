package cn.hzh.iterator1;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class Properties_Out {
    public static void main(String[] args) throws IOException {
        //method_1();//遍历集合

        method_2();//持久化储存数据store方法  字节输入流不能存储中文   字符输入流能存储中文

        method_3();//load方法的使用  字节输出流不能输出中文   字符输出流能输出中文
    }

    private static void method_3() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("a.txt"));

        Set<String> s = properties.stringPropertyNames();
        for (String key:s) {
            String value = properties.getProperty(key);
            System.out.println("key:"+key+"->"+"value:"+value);
        }
    }

    private static void method_2() throws IOException {
        Properties properties = new Properties();
        //添加属性
        properties.setProperty("李四","18");
        properties.setProperty("李五","19");
        properties.setProperty("张三","20");
        properties.setProperty("张四","18");

        FileWriter writer = new FileWriter("a.txt");
        properties.store(writer,"this is a properties file");
        writer.close();
    }

    private static void method_1() {
        Properties properties = new Properties();
        //添加属性
        properties.setProperty("李四","18");
        properties.setProperty("李五","19");
        properties.setProperty("张三","20");
        properties.setProperty("张四","18");

        //遍历集合
        Set<String> s = properties.stringPropertyNames();
        for (String key:s) {
            String value = properties.getProperty(key);
            System.out.println("key:"+key+"->"+"value:"+value);
        }
    }
}
