package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest11Ps {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的id:");
        int id = scanner.nextInt();

        try {
            //1: 获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            //如果使用预处理的对象,采用占位符的方式来设置参数; ? 代表一个占位符;
            String sql = "delete from userinfo where uid = ? or uname = ?";

            //2: 获取预处理对象; 可以先对我们的sql进行
            PreparedStatement ps = connection.prepareStatement(sql);

            //3: 设置参数 ;  有几个占位符,就要设置几个参数
            ps.setInt(1,id); //指定哪一个问好是这个值
            ps.setString(2,"rose");

            //4: 执行sql
            int i = ps.executeUpdate();

            if(i > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
