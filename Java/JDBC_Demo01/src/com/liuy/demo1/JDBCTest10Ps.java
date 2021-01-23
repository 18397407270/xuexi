package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest10Ps {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) {


        try {
            //1: 获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "delete from userinfo where uid = 5";

            //2: 获取预处理对象; 可以先对我们的sql进行
            PreparedStatement ps = connection.prepareStatement(sql);

            //3: 设置参数

            //4: 执行sql
            int i = ps.executeUpdate();

            if(i > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

            ps.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
