package com.liuy.demo1;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest8Login {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //1: 用户输入密码等信息
        System.out.println("请输入你的用户名:");
        String name = scan.next();
        System.out.println("请输入你的密码:");
        String pass = scan.next();

        //2: 需要使用这个用户名和密码去数据库查询是否有这个用户
        //根据用户输入的用户名,去数据库查找这条记录是否存在;
        String sql = "select uid,uname,upass from userinfo where uname = '" + name + "'";
        System.out.println(sql);

        //3: 需要将sql发送到数据库去查询;如果查到了就说明这个用户是登录成功

        try {
            //获取数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //执行sql的对象
            Statement statement = connection.createStatement();

            //发送sql
            ResultSet resultSet = statement.executeQuery(sql);

            //代表我们根据用户名,没有找到这条记录;说明这个用户根本就在数据库里面不存在
            if(resultSet.next()){

                //代表查到了一条记录 判断一下他的密码是否正确

                //用户输入的密码,pass;
                //获取数据库里面的密码;
                String upass = resultSet.getString("upass");

                if(upass.equals(pass)){
                    System.out.println("登录成功");
                }else{
                    System.out.println("登录失败,密码错误");
                }

            }else{
                System.out.println("你的用户不存在,请重试");
            }

            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
