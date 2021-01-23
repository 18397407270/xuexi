package com.liuy.view;

import com.liuy.bean.BookBean;
import com.liuy.code.SystemCode;
import com.liuy.serivce.IBookService;
import com.liuy.serivce.impl.BookServiceImpl;

import java.util.Scanner;

public class DemoStart {

    static Scanner scan = new Scanner(System.in);

    //视图层需要调用业务层的内容
    static IBookService bookService = new BookServiceImpl();

    public static void main(String[] args) {

        System.out.println("请选择对数据的操作:");
        System.out.println("1: 添加书籍");
        System.out.println("2: 删除书籍");
        System.out.println("3: 修改书籍");
        System.out.println("4: 查看所有书籍");

        int i = scan.nextInt();

        switch (i){
            case 1:
                addBook();break;
            case 2:
                delBook();break;
            case 3:
                updBook();break;
            case 4:
                selBook();break;
            default:
                System.out.println("非法输入");
        }

    }

    //查询所有书籍
    private static void selBook() {

    }

    //修改书籍
    private static void updBook() {

    }

    //删除书籍
    private static void delBook() {

    }

    //添加书籍
    private static void addBook() {

        System.out.println("请输入书籍的名称:");
        String s = scan.next();
        System.out.println("请输入书籍的价格:");
        float v = scan.nextFloat();

        BookBean bookBean = new BookBean(s,v);

        //我们不在这里连接数据库;直接调用业务层;
        int result = bookService.addBook(bookBean); // 添加书籍的业务

        if(result == SystemCode.ADD_ERROR){
            System.out.println("你添加的书籍已经存在");
        }else{
            System.out.println("添加成功");
        }

    }
}
