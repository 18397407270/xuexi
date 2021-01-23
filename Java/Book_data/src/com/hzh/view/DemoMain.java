package com.hzh.view;

import com.hzh.bean.BookBean;
import com.hzh.code.SystemCode;
import com.hzh.service.IBookService;
import com.hzh.service.imp.IBookServiceImp;

import java.util.List;
import java.util.Scanner;

public class DemoMain {

    static Scanner scan = new Scanner(System.in);

    //视图层需要调用业务层的内容
    static IBookService bookService = new IBookServiceImp();

    public static void main(String[] args) {

        while (true){
            System.out.println("请选择对数据的操作:");
            System.out.println("1: 添加书籍");
            System.out.println("2: 删除书籍");
            System.out.println("3: 修改书籍");
            System.out.println("4: 查看所有书籍");
            System.out.println("5: 退出系统");
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
                case 5:
                    System.exit(0);
                default:
                    System.out.println("非法输入");
            }

        }
        }


    //查询所有书籍
    private static void selBook() {
        List<BookBean> bookBeans = bookService.SelectBooks();
        for (BookBean b:bookBeans
             ) {
            System.out.println(b);
        }
    }

    //修改书籍
    private static void updBook() {
        System.out.println("请输入要修改的书籍的名称:");
        String s = scan.next();

        System.out.println("请输入要修改书籍的价格:");
        float v = scan.nextFloat();

        BookBean bookBean = new BookBean(s,v);

        int i = bookService.UpdateBook(bookBean);

        if(i == SystemCode.Update_SUCCESS){
            System.out.println("成功修改书籍");
        }else{
            System.out.println("修改书籍失败");
        }

    }

    //删除书籍
    private static void delBook() {
        System.out.println("请输入要删除的书籍的名称:");
        String s = scan.next();
        BookBean bookBean = new BookBean(s);
        int i = bookService.DeleteBook(bookBean);
        if(i == SystemCode.Delete_SUCCESS){
            System.out.println("成功删除书籍");
        }else{
            System.out.println("书籍删除失败");
        }
    }

    //添加书籍
    private static void addBook() {

        System.out.println("请输入书籍的名称:");
        String s = scan.next();
        System.out.println("请输入书籍的价格:");
        float v = scan.nextFloat();

        BookBean bookBean = new BookBean(s,v);

        //我们不在这里连接数据库;直接调用业务层;
        int result = bookService.AddBook(bookBean); // 添加书籍的业务

        if(result == SystemCode.ADD_ERROR){
            System.out.println("你添加的书籍已经存在");
        }else{
            System.out.println("添加成功");
        }

    }
}
