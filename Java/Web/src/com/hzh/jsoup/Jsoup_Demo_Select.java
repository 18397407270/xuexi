package com.hzh.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Jsoup_Demo_Select {
    /*
    Jsoup可以解析html或者xml
    * 用Jsoup来解析xml
    可用来爬虫
    * */
    public static void main(String[] args) throws IOException {
        //1.获取文件路径
        String path = Jsoup_Demo_Select.class.getClassLoader().getResource("student.xml").getPath();
        //2.加载文件
        Document document = Jsoup.parse(new File(path), "utf-8");

        /*
        * select选择器
        * */
        Elements elements = document.select("name");
        System.out.println(elements);

        Elements select = document.select("student[number='heima_0002']");
        System.out.println(select);

        Elements select1 = document.select("student[number='heima_0002']>age");
        System.out.println(select1);
    }
}
