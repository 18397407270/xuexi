package com.liuy.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest1 {

    //jdbc:mysql:// 通过jdbc去连接mysql的固定写法
    //127.0.0.1:3306 我们mysql数据库的ip地址和端口号
    // /mytest 我们需要通过mysql操作里面的哪一个数据库
    static String url = "jdbc:mysql://127.0.0.1:3306/mytest";
    static String name = "root";
    static String pass = "123456";

    public static void main(String[] args) {

        /*
        #### 3.1 注册驱动
        #### 3.2 获取连接
        #### 3.3 获取执行对象
        #### 3.4 执行sql语句
         */

        try {
            //3.1 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //3.2 获取连接
            Connection connection = DriverManager.getConnection(url, name, pass);

            //3.3 获取执行对象
            Statement statement = connection.createStatement();

            //3.4 通过statement对象发送sql语句到我们的mysql执行;
            // 执行dml语句; 返回收影响的行数; 如果说大于0就代表当前sql执行成功;
            String sql = "INSERT INTO userinfo(uname,upass) VALUES('jerry','123456'),('tly','123456')";//我们一定要先在客户端软件里面测试,确实可用
            int result = statement.executeUpdate(sql); //执行我们的DML语句(插入,修改,删除)

            if(result > 0){
                System.out.println("恭喜你,插入成功");
            }else{
                System.out.println("插入失败");
            }

            //3.5 一定要关闭连接
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
