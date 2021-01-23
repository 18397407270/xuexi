package com.liuy.demo1;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest7Login {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //1: 用户输入密码等信息
        System.out.println("请输入你的用户名:");
        String name = scan.nextLine();
        System.out.println("请输入你的密码:");
        String pass = scan.nextLine();

        //2: 需要使用这个用户名和密码去数据库查询是否有这个用户
        //拼接一个sql语句
        String sql = "select uid,uname,upass from userinfo where uname = '" + name + "' and upass = '" + pass + "'";
        System.out.println(sql);

        //3: 需要将sql发送到数据库去查询;如果查到了就说明这个用户是登录成功

        try {
            //获取数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //执行sql的对象
            Statement statement = connection.createStatement();

            //发送sql
            ResultSet resultSet = statement.executeQuery(sql);

            //不需要遍历整个结果集,只需要判断这个结果集里面是否有记录就可以

            if(resultSet.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }

            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
