package com.liuy.demo1;

import java.sql.*;

public class JDBCTest5 {

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
            String sql = "select uid,uname,upass from userinfo";

            //结果集; 就是你查询过来的所有内容;都在这个对象里面
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){ //如果有下一条记录,进入循环;通过列名位置获取这一行的数据

                //通过列的名字取获取这一列保存的信息
                int uid = resultSet.getInt("uid");
                String uname = resultSet.getString("uname");
                String upass = resultSet.getString("upass");

                System.out.println(uid + "," + uname + "," + upass);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
