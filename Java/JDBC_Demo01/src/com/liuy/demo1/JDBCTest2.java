package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String name = "root";
    static String pass = "123456";

    public static void main(String[] args) {


        try {
            //1获取连接
            Connection connection = DriverManager.getConnection(url, name, pass);

            //2获取发送sql的对象
            Statement statement = connection.createStatement();

            //3发送sql到
            int result = statement.executeUpdate("delete from userinfo where uid = 4");

            //根据受影响的行数来确定我们这次操作是否成功;并且要响应
            if(result > 0 ){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

            //3.5 一定要关闭连接
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
