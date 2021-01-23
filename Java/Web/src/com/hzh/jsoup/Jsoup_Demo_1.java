package com.hzh.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Jsoup_Demo_1 {
    /*
    Jsoup可以解析html或者xml
    * 用Jsoup来解析xml
    可用来爬虫
    * */
    public static void main(String[] args) throws IOException {
        //1.获取文件路径
        String path = Jsoup_Demo_1.class.getClassLoader().getResource("student.xml").getPath();
        //2.加载文件
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取指定标签的内容 public class Elements extends ArrayList<Element>
        /*Elements name = document.getElementsByTag("name");

        System.out.println("--------------------------");

        //4.遍历集合
        for (Element n:name
             ) {
            System.out.println(n.text());
        }
        System.out.println("-----------------------------");*/
        /*
        * 获取student的属性值
        * */
       /* Element student = document.getElementsByTag("student").get(0);
        String number = student.attr("number");
        System.out.println(number);

        System.out.println("--------------------------");*/

       /* Elements elements = document.getElementsByAttribute("number");
        System.out.println(elements);

        System.out.println("-------------------------------");*/

        /*
        * 获取文本内容
        * */
        Element name1 = document.getElementsByTag("name").get(0);
        /*获取所有子标签的纯文本内容*/
        String text = name1.text();
        /*获取标签所有内容*/
        String html = name1.html();
        System.out.println(text);
        System.out.println(html);

        System.out.println("--------------------------");

      /*  Elements elements1 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements1);*/

        /*document.getElementById("")*/
        //通过url解析内容
        /*URL url = new URL("https://edu.csdn.net/");
        Document parse = Jsoup.parse(url,10000);
        System.out.println(parse);*/
    }
}
