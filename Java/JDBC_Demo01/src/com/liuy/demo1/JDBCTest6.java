package com.liuy.demo1;

import java.sql.*;

public class JDBCTest6 {

    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String name = "root";
    static String pass = "123456";

    public static void main(String[] args) {

        try {
            //获取连接
            Connection connection = DriverManager.getConnection(url, name, pass);

            //获取发送sql的对象
            Statement statement = connection.createStatement();

            //发送DQL语句
            String sql = "SELECT uid id,uname username,upass userpass FROM userinfo";

            //结果集; 就是你查询过来的所有内容;都在这个对象里面
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){ //如果有下一条记录,进入循环;通过列名位置获取这一行的数据

                //如果你的查询语句有别名,一定要使用别名去获取
                int uid = resultSet.getInt("id");
                String uname = resultSet.getString("username");
                String upass = resultSet.getString("userpass");

                System.out.println(uid + "," + uname + "," + upass);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
