package com.hzh.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Jsoup_Demo_Xpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取文件路径
        String path = Jsoup_Demo_Select.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.创建JxDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4.结合语法查询
        List<JXNode> jxNodes = jxDocument.selN("//student");
        //遍历
        jxNodes.stream().forEach(name-> System.out.println(name));

        System.out.println("---------------------------------");

        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        jxNodes1.stream().forEach(name-> System.out.println(name));

        System.out.println("---------------------------------");

        /*选取student下带有id的name标签*/
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        jxNodes2.stream().forEach(name-> System.out.println(name));

        System.out.println("-----------------------");

        /*选取student下带有id为hzh1的name标签*/
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='hzh1']");
        jxNodes3.stream().forEach(name-> System.out.println(name));
    }
}
