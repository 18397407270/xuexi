package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest9Regist {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //1: 注册,需要用户输入用户名密码信息
        System.out.println("欢迎使用xxx系统,注册功能");
        System.out.println("请输入你的用户名:");
        String name = scan.next();
        System.out.println("请输入你的密码:");
        String pass = scan.next();

        //拼接插入的sql语句
        String sql = "insert into userinfo(uname,upass) values('" + name + "','" + pass +"')";
        System.out.println(sql);

        try {
            //需要将这条记录插入到mysql里面
            Connection connection = DriverManager.getConnection(url, username, password);

            //获取执行对象
            Statement statement = connection.createStatement();

            //执行影响的行数
            int result = statement.executeUpdate(sql);

            if(result > 0){
                System.out.println("注册成功");
            }else{
                System.out.println("注册失败");
            }

            //关闭连接
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
