package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest3 {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String name = "root";
    static String pass = "123456";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(url, name, pass);

            Statement statement = connection.createStatement();

            String sql = "update userinfo set uname='jerry' where uid = 5";
            int result = statement.executeUpdate(sql);

            if(result >0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }

            //3.5 一定要关闭连接
            statement.close();
            connection.close(); //不能先关闭连接;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
