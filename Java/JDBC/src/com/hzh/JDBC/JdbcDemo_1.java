package com.hzh.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo_1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动包

        /*
        * DriverManager :1.注册驱动
        *               :2.数据库连接
        * Connection    :1.获取执行sql语句的对象
        *               :2.管理事务:1.开启事务 setAutocommit() ,false,即为开启事务
        *                          2.提交事务 commit()
        *                          3.回滚事务 rollback()
        * Statement      1.execute() 可以执行任意语句,结果返回boolen值,不常用
        *                2.executeUpdate(),可以执行DML(增删改查),DDL语句(create,alert.drop等操作),返回值是影响的行数
        *                3.executeQuery(),执行DQL语句(Select)
        *
        * */

        //2.注册驱动
        /*
        * 在com.mysql.jdbc.Driver中用了静态块,在其中进行了注册
        * */
        Class.forName("com.mysql.jdbc.Driver");

        //3.获取数据库连接对象
        /*
        * jdbc:mysql://ＩＰ（域名）:端口号/数据库名称,账户,密码　　固定写法
        *如果连接的本机数据库,ＩＰ（域名）:端口号  可以省略
        * */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "260477");

        //4.定义sql语句
        String sql = "update user set sex='男' where id=40";

        //5.获取执行sql语句的对象
        Statement statement = conn.createStatement();

        //6.执行sql语句
        int i = statement.executeUpdate(sql);

        //7.处理结果
        System.out.println(i);

        //8.释放资源
        statement.close();
        conn.close();

    }
}
